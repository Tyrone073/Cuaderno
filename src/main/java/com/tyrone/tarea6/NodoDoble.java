/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea6;

/**
 *
 * @author tyron
 */
public class NodoDoble {
    private NodoDoble ante;
    private Estudiante dato;
    private NodoDoble sigue;

    public NodoDoble() {
    }

    public NodoDoble(NodoDoble ante, Estudiante dato, NodoDoble sigue) {
        this.ante = ante;
        this.dato = dato;
        this.sigue = sigue;
    }

    public NodoDoble getAnte() {
        return ante;
    }

    public void setAnte(NodoDoble ante) {
        this.ante = ante;
    }

    public Estudiante getDato() {
        return dato;
    }

    public void setDato(Estudiante dato) {
        this.dato = dato;
    }

    public NodoDoble getSigue() {
        return sigue;
    }

    public void setSigue(NodoDoble sigue) {
        this.sigue = sigue;
    }
   
    
}
