/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea4;

/**
 *
 * @author tyron
 */
public class NODOString {
    //Atributos
    private String dato;
    private NODOString sigue;
    //Constructor vacio
    
    public NODOString(){    
    }
    //constructor
    public NODOString(String dato, NODOString sigue){
        this.dato = dato;
        this.sigue = sigue;
    }

    //Metodos getter y setter
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NODOString getSigue() {
        return sigue;
    }

    public void setSigue(NODOString sigue) {
        this.sigue = sigue;
    }
    
    
}
