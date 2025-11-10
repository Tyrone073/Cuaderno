/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea4;

/**
 *
 * @author tyron
 */
public class PILAString {
    //Atributos
    private NODOString cima;
    
    //Constructor vacio
    public PILAString(){    
    }
    
    //constructor
    public PILAString( NODOString cima){
        this.cima = cima;
    }

    //Metodos apilar y desapilar

    public boolean Pvacio(){
        return cima == null;
    }
    
    public void Apilar(String valor){
        NODOString nuevoNodo = new NODOString(valor, null); 
        if(Pvacio()){
            cima = nuevoNodo;
        } else{
            nuevoNodo.setSigue(cima);
            cima = nuevoNodo;
        }
    }
    
    public String Desapilar(){
        if(Pvacio()){
            return "N";
        } else{
            String nu = cima.getDato();
            cima = cima.getSigue();
            return nu;
        }
    }
    
}
