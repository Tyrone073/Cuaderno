/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaDoblementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class Jugador {
    private String nombre_jugador;
    private int numero_dorsal;
    private String posicion;

    // Constructor con argumentos
    public Jugador(String nombre_jugador, int numero_dorsal, String posicion) {
        this.nombre_jugador = nombre_jugador;
        this.numero_dorsal = numero_dorsal;
        this.posicion = posicion;
    }

    // usare solo metodos getters ya q en el ejercicio anterior no use los setters
    public String getNombre_jugador() { 
        return nombre_jugador; 
    }
    
    public int getNumero_dorsal() { 
        return numero_dorsal; 
    }
    
    public String getPosicion() { 
        return posicion; 
    }

    @Override
    public String toString() {
        return  "Jugador: " + nombre_jugador + " || Numero: " + numero_dorsal + " || Posicion: " + posicion;
    }
    
}
