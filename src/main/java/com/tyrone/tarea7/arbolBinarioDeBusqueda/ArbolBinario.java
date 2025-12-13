/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea7.arbolBinarioDeBusqueda;

/**
 *
 * @author tyron
 */
public class ArbolBinario {

    private NodoDoble raiz;

    public ArbolBinario() {
    }

    public ArbolBinario(NodoDoble raiz) {
        this.raiz = raiz;
    }

    public NodoDoble getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoDoble raiz) {
        this.raiz = raiz;
    }

    public boolean esVacia() {
        return raiz == null;
    }

    public void añadir(Producto dato) {
        NodoDoble nuevoNodo = new NodoDoble(null, dato, null);
        insertarNuevoProducto(nuevoNodo, raiz);

    }

    private void insertarNuevoProducto(NodoDoble nuevo, NodoDoble r) {

        if (esVacia()) {
            raiz = nuevo;
        } else if (nuevo.getDato().getCodigo() < r.getDato().getCodigo()) {
            if (r.getIzquierda() == null) {
                r.setIzquierda(nuevo);
            } else {
                insertarNuevoProducto(nuevo, r.getIzquierda());
            }
        } else if (nuevo.getDato().getCodigo() > r.getDato().getCodigo()) {
            if (r.getDerecha() == null) {
                r.setDerecha(nuevo);
            } else {
                insertarNuevoProducto(nuevo, r.getDerecha());
            }
        } else {
            //aqui no agregare la logica para actualizar el stock del producto como lo hizo el profe, voy a hacerlo con logicas separadas
            
            System.out.println("Datos" + nuevo.getDato() + "esta duplicado ...");
        }
    }

    public void preOrden(NodoDoble nd) {
        if (nd == null) {
            return;
        }
        System.out.println(" " + nd.getDato());
        preOrden(nd.getIzquierda());
        preOrden(nd.getDerecha());
    }

    public void inOrden(NodoDoble nd) {

        if(nd != null){
            inOrden(nd.getIzquierda());
            System.out.println(" " + nd.getDato());
            inOrden(nd.getDerecha());
        }
    }
    
    public void posOrden(NodoDoble nd) {

        if(nd != null){
            inOrden(nd.getIzquierda());
            inOrden(nd.getDerecha());
            System.out.println(" " + nd.getDato());
        }
    }
    
    

    public void insertarProductoExistente(String idONombre, int stock) {

        if (esVacia()) {
            System.out.println("Sin productos");
            return;
        } else {
            NodoDoble actual = raiz;
            NodoDoble nodoProducto = buscarProducto(actual, idONombre);
            if (nodoProducto == null) {                
                System.out.println("Nos se encontro producto");
                return;
            }
            ////
            int nuevoStock = nodoProducto.getDato().getStock() + stock;
            nodoProducto.getDato().setStock(nuevoStock);

//            insertarNuevoProducto(nodoProducto, nodoProducto);
            System.out.println("Stock se actualizo");
            System.out.println(nodoProducto.getDato());
        }

    }
    
    public NodoDoble buscarProducto(NodoDoble actual,String idONombre) { // practicando la recursion

//        NodoDoble actual = raiz;  commento y mando el arbol como parametro del metodo a usar por el main por si el profe no quiere q use un apuntador a raiz desde aqui como lo hice arriba
        if (actual == null) {          
            return null;
        }
      
        if (idONombre.matches("\\d+")) {

            int id = Integer.parseInt(idONombre);
            
            if (id == actual.getDato().getCodigo()) {
//                System.out.println("dato encontrado: "+ actual.getDato());   
//                producto = actual;
                return actual;
            }

        }else if(actual.getDato().getNombre().equalsIgnoreCase(idONombre)) {
//            System.out.println("dato encontrado: "+ actual.getDato());
//            producto = actual;
            return actual;
        }
        
        NodoDoble encontrado = buscarProducto(actual.getIzquierda(), idONombre); // si se encuentra por la izquierda retorna
        if (encontrado != null) {
            return encontrado;
        }
 
        return buscarProducto(actual.getDerecha(), idONombre);//si al final no encuantra por la derecha ni por la izquierda entonces retorna un null
        
    }
    
    public void imprimirUnProducto(NodoDoble actual,String idONombre){
        NodoDoble producto = buscarProducto(actual, idONombre);
        if (producto != null) {
            System.out.println("Producto: "+ producto.getDato());
            
        }else{
            System.out.println("Producto no encontrado");
        }
        
    }


    public void eliminarProducto(NodoDoble nodo, String idONombre) {
       
        raiz = borrarNodo(raiz, idONombre);
        if (raiz == null) {
            System.out.println("Producto eliminado o árbol vacío");
        } else {
            System.out.println("Operación de eliminación completada");
        }
    }
    
    public NodoDoble borrarNodo(NodoDoble nodo, String idONombre) {
        if(nodo == null){
            return null;
        }
        else {
        
            int id = 0;
            if (idONombre.matches("\\d+")) {
                id = Integer.parseInt(idONombre);
                
            } else {
                // ya no me da la cabeza para comparar dos lados cuando es por nombre asi q combierto esa palabra q me den a un codigo como lo hice en el main
                String nombreAux = idONombre.toUpperCase().replace(" ", "");
                for(int i =0; i < nombreAux.length(); i++){
                    char letra = nombreAux.charAt(i);
                    if (letra >= 'A' && letra <= 'Z') {
                        int valor = letra - 'A' + 1; // A=1, B=2, ...
                        id = id * 10 + valor; 
                    }
                }
               
            }
            
            // el id es menor que los datos del nodo, busque el id en el subárbol izquierdo
                if(id < nodo.getDato().getCodigo()){
                    nodo.setIzquierda(borrarNodo(nodo.getIzquierda(), idONombre));
                    // el id es mayor que los datos del nodo, busque el id en el subárbol derecho
                }else if(id > nodo.getDato().getCodigo()){
                    nodo.setDerecha(borrarNodo(nodo.getDerecha(), idONombre));
                    // Si el id es igual a los datos del nodo, es decir, hemos encontrado que el nodo debe eliminarse
                }else {
                // Si el nodo que se va a eliminar no tiene un hijo, establezca el nodo en nulo
                    if(nodo.getIzquierda() == null && nodo.getDerecha() == null){
                        nodo = null;
                    // Si el nodo a eliminar tiene solo un hijo a la derecha
                    }else if (nodo.getIzquierda() == null ) {
                        nodo = nodo.getDerecha();
                    }
                    // Si el nodo a eliminar tiene solo un hijo a la izquierda
                    else if (nodo.getDerecha() == null ) {
                        nodo = nodo.getIzquierda();
                    }
                    // Si el nodo a eliminar tiene dos hijos nodo
                    else {
                    // luego encuentra el nodo mínimo del subárbol derecho
                        NodoDoble temp = minNodo(nodo.getDerecha());
                        // Intercambia los datos entre nodo y temp
                        nodo.setDato(temp.getDato());
                        // Elimina el nodo duplicado del subárbol derecho
                        nodo.setDerecha(borrarNodo(nodo.getDerecha(), temp.getDato().getNombre()));
                    }
                }
            
            return nodo;
        }
    }
    
    // minNode () encontrará el nodo mínimo
    public NodoDoble minNodo(NodoDoble raiz) {
        if (raiz.getIzquierda() != null){
            return minNodo(raiz.getIzquierda());
        }else{
            return raiz;
        }
    }

//    public NodoDoble buscarProducto(String idONombre) { // no use un metodo recursivo porq me mareo y se me complica, me falta practica en esa parte
//
//        if (esVacia()) {
//            System.out.println("Sin productos");
//            return null;
//        }
//
//        NodoDoble actual = raiz;
//
//        //si se detecta un numero
//        if (idONombre.matches("\\d+")) {
//
//            int id = Integer.parseInt(idONombre);
//
//            while (actual != null) {
//
//                if (id == actual.getDato().getCodigo()) {
//                    return actual;
//                }
//
//                if (id < actual.getDato().getCodigo()) {
//                    actual = actual.getIzquierda();
//                } else {
//                    actual = actual.getDerecha();
//                }
//            }
//
//            System.out.println("Producto no encontrado");
//            return null;
//        }
//
//        actual = raiz;//vuelvo a meterle los datos de raiz porq en el recorrido anterior ya se vacio
//
//        NodoDoble ultimoVisitado = null;
//
//        while (actual != null) {
//
//            if (actual.getDato().getNombre().equalsIgnoreCase(idONombre)) {
//                return actual;
//            }
//
//            if (actual.getIzquierda() != null && ultimoVisitado != actual.getIzquierda()) {
//                ultimoVisitado = actual;
//                actual = actual.getIzquierda();
//
//            } else if (actual.getDerecha() != null && ultimoVisitado != actual.getDerecha()) {
//                ultimoVisitado = actual;
//                actual = actual.getDerecha();
//
//            } else {
//                ultimoVisitado = actual;
//                actual = null;
//            }
//        }
//
//        System.out.println("Producto no encontrado");
//        return null;
//
//    }
}
