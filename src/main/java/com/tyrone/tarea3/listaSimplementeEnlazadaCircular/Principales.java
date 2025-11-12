/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaSimplementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class Principales {
    Nomina equipo;
    short cantidad;

    //creo un constructor para asignar valores a las instancias actuales
    public Principales() {
        equipo = new Nomina();
        cantidad = 0;
    }

    // Agregar jugador si no supera 11 como lo indica en la tarea
    public void agregarJugador(Persona p) {
        if (cantidad < 11) {
            equipo.ingresarAlFinal(p);
            cantidad++;
        } else {
            System.out.println("No se pueden agregar mas de 11 jugadores.");
        }
    }

    // metodo de sustoitución XD
    public void sustitucion(String nombreAntiguo, Persona nuevo) {
        equipo.eliminar(nombreAntiguo);
        equipo.ingresarAlFinal(nuevo);
    }
    
    // Muestra la plantilla, lista o por decirlo toda la informacion de jugadores o nodos como indica la tarea
    public void plantillaCompleta() {
        equipo.imprimir();
    }
    
    // Elimina toda la lista
    public void eliminarTodo() {
        equipo.eliminarTodo();
        cantidad = 0;
    }

    // Expulsa o elimina a un jugador mediante su nombre
    public void expulsado(String nombre) {
        equipo.eliminar(nombre);
        cantidad--;
    }
   
}
