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
    
    public void inOrden(NodoDoble nd){
        if(esVacia()){
            return;
        }
        System.out.println(" " + nd.getDato());
        inOrden(nd.getIzquierda());
        inOrden(nd.getDerecha());
    }
    
    public void insertarProductoExistente(NodoDoble producto){
        
    }
    
    public void buscarProducto(String algo){
    
    }
    
    public void eliminarProducto(String algo){
    
    }
    
    
}
