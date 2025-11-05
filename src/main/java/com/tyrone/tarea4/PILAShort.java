/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea4;

/**
 *
 * @author tyron
 */
public class PILAShort {
    //Atributos
    private NODOShort cima;
    
    //Constructor vacio
    public PILAShort(){    
    }
    
    //constructor
    public PILAShort( NODOShort cima){
        this.cima = cima;
    }

    //Metodos apilar y desapilar

    public boolean Pvacio(){
        return cima == null;
    }
    
    public void Apilar(short valor){
        NODOShort nuevoNODOShort = new NODOShort(valor, null); 
        if(Pvacio()){
            cima = nuevoNODOShort;
        } else{
            nuevoNODOShort.setSigue(cima);
            cima = nuevoNODOShort;
        }
    }
    
    public short Desapilar(){
        if(Pvacio()){
            return 'N';
        } else{
            short nu = cima.getDato();
            cima = cima.getSigue();
            return nu;
        }
    }
    
}
