/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

/**
 *
 * @author tyron
 */
public class Nodo {
    //Atributos
    private Vehiculo dato;
    private Nodo sigue;
     
    //Constructores
    public Nodo() {
    }

    public Nodo(Vehiculo dato, Nodo sigue) {
        this.dato = dato;
        this.sigue = sigue;
    }

    //Metodos

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public Nodo getSigue() {
        return sigue;
    }

    public void setSigue(Nodo sigue) {
        this.sigue = sigue;
    }
    
}
