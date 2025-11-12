package com.tyrone.pruebas;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ScreenServer {

    public static void main(String[] args) throws Exception {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();

        System.out.println("Pantallas detectadas:");
        for (int i = 0; i < screens.length; i++) {
            DisplayMode mode = screens[i].getDisplayMode();
            System.out.printf("[%d] %s - %dx%d @ %dHz%n",
                    i, screens[i].getIDstring(), mode.getWidth(), mode.getHeight(), mode.getRefreshRate());
        }

        AtomicInteger selectedScreenIndex = new AtomicInteger(0);
        AtomicReference<byte[]> latestFrame = new AtomicReference<>();

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Captura continua de pantalla
        Thread captureThread = new Thread(() -> {
            try {
                while (true) {
                    GraphicsDevice selectedScreen = screens[selectedScreenIndex.get()];
                    Rectangle bounds = selectedScreen.getDefaultConfiguration().getBounds();
                    Robot robot = new Robot(selectedScreen);
                    BufferedImage image = robot.createScreenCapture(bounds);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
                    ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
                    jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                    jpgWriteParam.setCompressionQuality(0.6f);

                    jpgWriter.setOutput(new MemoryCacheImageOutputStream(baos));
                    jpgWriter.write(null, new javax.imageio.IIOImage(image, null, null), jpgWriteParam);
                    jpgWriter.dispose();

                    latestFrame.set(baos.toByteArray());
                    Thread.sleep(1000 / 30);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        captureThread.setDaemon(true);
        captureThread.start();

        // Página principal
        server.createContext("/", (HttpExchange exchange) -> {
            StringBuilder options = new StringBuilder();
            for (int i = 0; i < screens.length; i++) {
                options.append("<option value='").append(i).append("'>Pantalla ").append(i).append("</option>");
            }

            String html = """
            <html>
            <head>
              <meta charset='UTF-8'>
              <title>Screen Stream</title>
              <style>
                body { margin:0; background:black; overflow:hidden; text-align:center; color:white; font-family:sans-serif; }
                #controls {
                    position:fixed; top:10px; left:50%%; transform:translateX(-50%%);
                    background:rgba(0,0,0,0.6); padding:10px 20px; border-radius:10px;
                    transition:opacity 0.4s; opacity:1; z-index:100;
                }
                #controls.hidden { opacity:0; pointer-events:none; }
                select, button { font-size:16px; padding:5px 10px; border-radius:8px; border:none; margin:0 5px; }
                img { width:100%%; height:100%%; object-fit:contain; display:block; margin:0 auto; }
              </style>
            </head>
            <body>
              <div id="controls">
                <label for="screenSel">Pantalla:</label>
                <select id="screenSel">%s</select>
                <button id="fullscreenBtn">Pantalla completa</button>
              </div>
              <img id='screen' src='/screen' />
              <script>
                const img = document.getElementById('screen');
                const sel = document.getElementById('screenSel');
                const btn = document.getElementById('fullscreenBtn');
                const controls = document.getElementById('controls');

                async function refresh() {
                  try {
                    const response = await fetch('/screen?' + Date.now(), { cache: 'no-store' });
                    const blob = await response.blob();
                    img.src = URL.createObjectURL(blob);
                  } catch (err) { console.error(err); }
                }
                setInterval(refresh, 100);

                sel.addEventListener('change', async () => {
                  await fetch('/switch?index=' + sel.value);
                });

                // ---- Control de pantalla completa y visibilidad ----
                let hideTimeout;

                function showControlsTemporarily() {
                  controls.classList.remove('hidden');
                  clearTimeout(hideTimeout);
                  hideTimeout = setTimeout(() => controls.classList.add('hidden'), 3000);
                }

                btn.addEventListener('click', () => {
                  if (!document.fullscreenElement) {
                    document.documentElement.requestFullscreen().catch(console.error);
                  } else {
                    document.exitFullscreen();
                  }
                });

                document.addEventListener('fullscreenchange', () => {
                  if (document.fullscreenElement) {
                    showControlsTemporarily();
                  } else {
                    controls.classList.remove('hidden');
                  }
                });

                document.addEventListener('click', showControlsTemporarily);
                document.addEventListener('mousemove', showControlsTemporarily);

                // Ocultar controles automáticamente tras unos segundos
                hideTimeout = setTimeout(() => controls.classList.add('hidden'), 4000);
              </script>
            </body>
            </html>
            """.formatted(options);

            byte[] bytes = html.getBytes();
            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.getResponseHeaders().add("Cache-Control", "no-cache, no-store, must-revalidate");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });

        // Endpoint para cambiar pantalla
        server.createContext("/switch", (HttpExchange exchange) -> {
            try {
                String query = exchange.getRequestURI().getQuery();
                if (query != null && query.startsWith("index=")) {
                    int newIndex = Integer.parseInt(query.substring(6));
                    if (newIndex >= 0 && newIndex < screens.length) {
                        selectedScreenIndex.set(newIndex);
                        System.out.println("-️ Cambiada a pantalla " + newIndex);
                    }
                }
                exchange.sendResponseHeaders(200, -1);
            } catch (Exception e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(500, -1);
            } finally {
                exchange.close();
            }
        });

        // Endpoint para enviar la imagen actual
        server.createContext("/screen", (HttpExchange exchange) -> {
            try {
                byte[] frame = latestFrame.get();
                if (frame == null) {
                    exchange.sendResponseHeaders(503, -1);
                    exchange.close();
                    return;
                }
                exchange.getResponseHeaders().add("Content-Type", "image/jpeg");
                exchange.getResponseHeaders().add("Cache-Control", "no-cache, no-store, must-revalidate");
                exchange.sendResponseHeaders(200, frame.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(frame);
                }
            } catch (Exception e) {
                System.err.println("Cliente desconectado o error: " + e.getMessage());
            } finally {
                try { exchange.close(); } catch (Exception ignore) {}
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Servidor en: http://localhost:8080/");
        System.out.println("O en red local: http://" + java.net.InetAddress.getLocalHost().getHostAddress() + ":8080/");
    }
}


//package com.tyrone.pruebas;
//
//import com.sun.net.httpserver.HttpServer;
//import com.sun.net.httpserver.HttpExchange;
//import javax.imageio.*;
//import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
//import javax.imageio.stream.ImageOutputStream; // ✅ <-- AGREGA ESTA LÍNEA
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.InetSocketAddress;
//import java.util.Iterator;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicReference;
//
//
//public class ScreenServer {
//
//    public static void main(String[] args) throws Exception {
//        int port = 8080;
//        int targetWidth = 1280; // ajusta según tu pantalla
//        float jpegQuality = 0.7f; // 0.0 a 1.0, controla la compresión
//        int targetFPS = 30;
//
//        System.out.println("Iniciando servidor en http://localhost:" + port);
//        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
//        ExecutorService executor = Executors.newCachedThreadPool();
//        server.setExecutor(executor);
//
//        // Frame compartido en memoria
//        AtomicReference<byte[]> latestFrame = new AtomicReference<>();
//
//        // Hilo que captura constantemente la pantalla
//        ScheduledExecutorService capturer = Executors.newSingleThreadScheduledExecutor();
//        capturer.scheduleAtFixedRate(() -> {
//            try {
//                Robot robot = new Robot();
//                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
//                BufferedImage screen = robot.createScreenCapture(screenRect);
//
//                // Escalado eficiente (reduce tamaño -> más FPS)
//                int targetHeight = (int) (screen.getHeight() * (targetWidth / (double) screen.getWidth()));
//                Image scaled = screen.getScaledInstance(targetWidth, targetHeight, Image.SCALE_FAST);
//                BufferedImage resized = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
//                Graphics2D g2d = resized.createGraphics();
//                g2d.drawImage(scaled, 0, 0, null);
//                g2d.dispose();
//
//                // Comprimir con calidad controlada
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
//                ImageWriter writer = writers.next();
//                ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
//                writer.setOutput(ios);
//
//                JPEGImageWriteParam jpegParams = new JPEGImageWriteParam(null);
//                jpegParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//                jpegParams.setCompressionQuality(jpegQuality);
//
//                writer.write(null, new IIOImage(resized, null, null), jpegParams);
//                ios.close();
//                writer.dispose();
//
//                latestFrame.set(baos.toByteArray());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }, 0, 1000 / targetFPS, TimeUnit.MILLISECONDS);
//
//        // Página HTML principal
//        server.createContext("/", (HttpExchange exchange) -> {
//            String html = """
//            <html>
//            <body style='margin:0;background:black;overflow:hidden;'>
//              <img id='screen' src='/screen' width='100%%'/>
//              <script>
//                const img = document.getElementById('screen');
//                setInterval(()=>{img.src='/screen?'+Date.now();}, %d);
//              </script>
//            </body>
//            </html>
//            """.formatted(1000 / targetFPS);
//
//            byte[] bytes = html.getBytes();
//            exchange.getResponseHeaders().add("Content-Type", "text/html");
//            exchange.sendResponseHeaders(200, bytes.length);
//            exchange.getResponseBody().write(bytes);
//            exchange.close();
//        });
//
//        // Endpoint que devuelve el último frame en memoria
//        server.createContext("/screen", (HttpExchange exchange) -> {
//            byte[] frame = latestFrame.get();
//            if (frame == null) {
//                exchange.sendResponseHeaders(503, -1);
//                exchange.close();
//                return;
//            }
//
//            exchange.getResponseHeaders().add("Content-Type", "image/jpeg");
//            exchange.sendResponseHeaders(200, frame.length);
//            OutputStream os = exchange.getResponseBody();
//            os.write(frame);
//            os.close();
//        });
//
//        server.start();
//        System.out.println("Servidor listo. Abre: http://localhost:" + port);
//    }
//}
