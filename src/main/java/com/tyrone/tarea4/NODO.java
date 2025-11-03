/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea4;

/**
 *
 * @author tyron
 */
public class NODO {
    //Atributos
    private char dato;
    private NODO sigue;
    //Constructor vacio
    
    public NODO(){    
    }
    //constructor
    public NODO(char dato, NODO sigue){
        this.dato = dato;
        this.sigue = sigue;
    }

    //Metodos getter y setter
    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NODO getSigue() {
        return sigue;
    }

    public void setSigue(NODO sigue) {
        this.sigue = sigue;
    }
    
    
}
