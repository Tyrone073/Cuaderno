/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaSimplementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class Persona { //creo q esta clase o entidad deberia ser llamada Jugador o creo q ese fue su propocito pero el profe se le olvido de cambiar el nombre en la tarea
    
    private String nombre_jugador;
    private int numero_jugador;
    private String posicion_de_juego;

    // Constructor vacío
    public Persona() {}

    // Constructor
    public Persona(String nombre, int numero, String posicion) {
        
        this.nombre_jugador = nombre;
        this.numero_jugador = numero;
        this.posicion_de_juego = posicion;
    }

    public String getNombre_jugador() {
        return nombre_jugador;
    }

    public void setNombre_jugador(String nombre_jugador) {
        this.nombre_jugador = nombre_jugador;
    }

    public int getNumero_jugador() {
        return numero_jugador;
    }

    public void setNumero_jugador(short numero_jugador) {
        this.numero_jugador = numero_jugador;
    }

    public String getPosicion_de_juego() {
        return posicion_de_juego;
    }

    public void setPosicion_de_juego(String posicion_de_juego) {
        this.posicion_de_juego = posicion_de_juego;
    }

    // Método toString
    @Override
    public String toString() {
        return  "Jugador: " + nombre_jugador + " || Numero: " + numero_jugador + " || Posicion: " + posicion_de_juego;
    }
}

