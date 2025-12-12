/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea7.arbolBinarioDeBusqueda;

import com.tyrone.tarea6.*;

/**
 *
 * @author tyron
 */
public class NodoDoble {
    private NodoDoble izquierda;
    private Producto dato;
    private NodoDoble derecha;

    public NodoDoble() {
    }

    public NodoDoble(NodoDoble ante, Producto dato, NodoDoble sigue) {
        this.derecha = ante;
        this.dato = dato;
        this.izquierda = sigue;
    }

    public NodoDoble getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoDoble ante) {
        this.derecha = ante;
    }

    public Producto getDato() {
        return dato;
    }

    public void setDato(Producto dato) {
        this.dato = dato;
    }

    public NodoDoble getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoDoble sigue) {
        this.izquierda = sigue;
    }
   
    
}
