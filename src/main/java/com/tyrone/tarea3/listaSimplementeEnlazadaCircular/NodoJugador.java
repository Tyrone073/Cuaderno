/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaSimplementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class NodoJugador {
    private Persona datos; //Creo q jugador se refiere a persona
    private NodoJugador siguiente;
 
    // Constructor vacio
    public NodoJugador() {}

    // Constructor
    public NodoJugador(Persona datos) {
        this.datos = datos;
        this.siguiente = null;
    }

    public Persona getDatos() {
        return datos;
    }

    public NodoJugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoJugador siguiente) {
        this.siguiente = siguiente;
    }
    
}

