/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaDoblementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class NodoJugador {
    private Jugador datos;
    private NodoJugador siguiente;
    private NodoJugador anterior;
 
    // Constructor vacio
    public NodoJugador() {}

    // Constructor
    public NodoJugador(Jugador datos) {
        this.datos = datos;
        this.siguiente = null;
        this.anterior = null;
    }

    public Jugador getDatos() {
        return datos;
    }

    public NodoJugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoJugador siguiente) {
        this.siguiente = siguiente;
    }

    public NodoJugador getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoJugador anterior) {
        this.anterior = anterior;
    }
 
}
