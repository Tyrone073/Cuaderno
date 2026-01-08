/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

/**
 *
 * @author tyron
 */
public class NodoArbol {
    //Atributos
    private NodoArbol derecha;
    private Vehiculo dato;
    private NodoArbol izquierda;
    
    //Constructores
    public NodoArbol() {
    }

    public NodoArbol(NodoArbol ante, Vehiculo dato, NodoArbol sigue) {
        this.derecha = ante;
        this.dato = dato;
        this.izquierda = sigue;
    }
    
    //Metodos
    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }
     
}
