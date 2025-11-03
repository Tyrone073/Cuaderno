/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea4;

/**
 *
 * @author tyron
 */
public class PILA {
    //Atributos
    private NODO cima;
    
    //Constructor vacio
    public PILA(){    
    }
    
    //constructor
    public PILA( NODO cima){
        this.cima = cima;
    }

    //Metodos apilar y desapilar

    public boolean Pvacio(){
        return cima == null;
    }
    
    public void Apilar(char valor){
        NODO nuevoNodo = new NODO(valor, null); 
        if(Pvacio()){
            cima = nuevoNodo;
        } else{
            nuevoNodo.setSigue(cima);
            cima = nuevoNodo;
        }
    }
    
    public char Desapilar(){
        if(Pvacio()){
            return 'N';
        } else{
            char nu = cima.getDato();
            cima = cima.getSigue();
            return nu;
        }
    }
    
}
