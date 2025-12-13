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
    
    public boolean esVacia(){
        return raiz == null;
    }
    
    public void añadir(Producto dato){
        NodoDoble nuevoNodo = new NodoDoble(null, dato, null);
        insertarNuevoProducto(nuevoNodo, raiz);
                
    }
    
    private void insertarNuevoProducto(NodoDoble nuevo, NodoDoble r){
//        String nombreProducnuevo = nuevo.getDato().getNombre();
//        String nombreProducR= r.getDato().getNombre();
        
        if (esVacia()) {
            raiz = nuevo;
        } else if (nuevo.getDato().getCodigo() < r.getDato().getCodigo()){
            if (r.getIzquierda()== null) {
                r.setIzquierda(nuevo);
            } else {
                insertarNuevoProducto(nuevo, r.getIzquierda());
            }
        }else if (nuevo.getDato().getCodigo() > r.getDato().getCodigo()){
            if (r.getDerecha() == null) {
                r.setDerecha(nuevo);
            } else {
                insertarNuevoProducto(nuevo, r.getDerecha());
            }
        } else{
            System.out.println("Datos" + nuevo.getDato()+ "esta duplicado ...");
        }
    }
    
    public void preOrden(NodoDoble nd){
        if(esVacia()){
            return;
        }
        System.out.println(" " + nd.getDato());
        preOrden(nd.getIzquierda());
        preOrden(nd.getDerecha());
    }
    
//    public NodoDoble inOrden(NodoDoble nd){
//        if (nd == null) {
//            return null;
//        }
//        inOrden(nd.getIzquierda());
//        NodoDoble a = nd;
////        System.out.println(" " + a.getDato());
//        inOrden(nd.getDerecha());
//        return a;
//    }
//    public Producto inOrden(NodoDoble nd){
//        if (nd == null) {
//            return null;
//        }
//        inOrden(nd.getIzquierda());
//        NodoDoble a = nd;
////        System.out.println(" " + a.getDato());
//        inOrden(nd.getDerecha());
//        return a.getDato();
//    }
    
    public void inOrden(NodoDoble nd){
        if (esVacia()){
            return;
        }

        inOrden(nd.getIzquierda());
        System.out.println(" " + nd.getDato());
        inOrden(nd.getDerecha());
    }

    
    public void insertarProductoExistente(String idONombre, int stock){      
        
        if(esVacia()){
            System.out.println("Sin productos");
        }else{
            NodoDoble nodoProducto = buscarProducto(idONombre);////
            int nuevoStock = nodoProducto.getDato().getStock() + stock;
            nodoProducto.getDato().setStock(nuevoStock);
            
            insertarNuevoProducto(nodoProducto, nodoProducto);
            System.out.println("Stock se actualizo");
        }
//        NodoDoble nodoProducto = buscarProducto(idONombre);
//
//    if (nodoProducto == null) {
//        System.out.println("Producto no encontrado");
//        return;
//    }
//
//    int nuevoStock = nodoProducto.getDato().getStock() + stock;
//    nodoProducto.getDato().setStock(nuevoStock);
//
//    System.out.println("Stock actualizado correctamente");
    }
    
    public NodoDoble buscarProducto(String idONombre){

        
    if (esVacia()) {
        System.out.println("Sin productos");
        return null;
    }

    NodoDoble actual = raiz;

    //si se detecta un numero
    if (idONombre.matches("\\d+")) {

        int id = Integer.parseInt(idONombre);

        while (actual != null) {

            if (id == actual.getDato().getCodigo()) {
                return actual;
            }

            if (id < actual.getDato().getCodigo()) {
                actual = actual.getIzquierda();
            } else {
                actual = actual.getDerecha();
            }
        }

        System.out.println("Producto no encontrado");
        return null;
    }

    
    actual = raiz;//vuelvo a meterle los datos de raiz porq en el recorrido anterior ya se vacio

    NodoDoble ultimoVisitado = null;

    while (actual != null) {

        if (actual.getDato().getNombre().equalsIgnoreCase(idONombre)) {
            return actual;
        }

        if (actual.getIzquierda() != null && ultimoVisitado != actual.getIzquierda()) {
            ultimoVisitado = actual;
            actual = actual.getIzquierda();

        } else if (actual.getDerecha() != null && ultimoVisitado != actual.getDerecha()) {
            ultimoVisitado = actual;
            actual = actual.getDerecha();

        } else {
            ultimoVisitado = actual;
            actual = null;
        }
    }

    System.out.println("Producto no encontrado");
    return null;
    
    }
    
//    public NodoDoble buscarProducto(String idONombre){
//        
//        NodoDoble nodoProducto = null;
//        
//        
//        if(esVacia()){
//            System.out.println("Sin productos");
//            return null;
//        }else{
////            Producto producto = inOrden(raiz);
//            NodoDoble producto = inOrden(raiz);
//
//            if(producto.getDato().getNombre().equals(idONombre)){
////            if(producto.getNombre().equals(idONombre)){
////                System.out.println(producto.getDato());
////                nodoProducto = producto;
////                nodoProducto.getDato();
////                nodoProducto = nodoProducto;
//                return producto;
//
//            }else if(idONombre.matches("\\d+")){
//                int id =  Integer.parseInt(idONombre);  
//                
//                if(id == producto.getDato().getCodigo()){
////                if(id == producto.getCodigo()){
////                    System.out.println(producto.getDato());
////                    nodoProducto = producto;
////                    nodoProducto.getDato();
////                    nodoProducto = nodoProducto;
//                    return producto;
//
//                }
//            }
//            else{
//                System.out.println("Nodo producto no encontrado");
////                nodoProducto = null;
//                return nodoProducto;
//            }
//        }
//        return nodoProducto;
//    
//    }
    
    public void eliminarProducto(String idONombre){
        NodoDoble nodoProducto = buscarProducto(idONombre);
        if(esVacia()){
            System.out.println("Sin productos");
        }else{
            
        }
        
    
    }
    
    
}
