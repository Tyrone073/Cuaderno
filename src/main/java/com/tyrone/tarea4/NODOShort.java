/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea4;

/**
 *
 * @author tyron
 */
public class NODOShort {
    //Atributos
    private short dato;
    private NODOShort sigue;
    //Constructor vacio
    
    public NODOShort(){    
    }
    //constructor
    public NODOShort(short dato, NODOShort sigue){
        this.dato = dato;
        this.sigue = sigue;
    }

    //Metodos getter y setter
    public short getDato() {
        return dato;
    }

    public void setDato(short dato) {
        this.dato = dato;
    }

    public NODOShort getSigue() {
        return sigue;
    }

    public void setSigue(NODOShort sigue) {
        this.sigue = sigue;
    }
    
    
}
