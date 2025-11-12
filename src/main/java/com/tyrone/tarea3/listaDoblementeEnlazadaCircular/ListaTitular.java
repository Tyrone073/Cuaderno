/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaDoblementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class ListaTitular {
    private ListaNomina lista = new ListaNomina();
    private int cantidad = 0;

    // Agregar jugador si no supera 11 como lo indica en la tarea
    public void agregarJugador(Jugador j) {
        if (cantidad < 11) {
            lista.ingresarAlFinal(j);
            cantidad++;
        } else {
            System.out.println("No se pueden agregar mas de 11 jugadores.");
        }
    }

    // metodo Cambio permite reemplazar un jugador por otro
    public void cambio(String nombreViejo, Jugador nuevo) {
        lista.eliminar(nombreViejo);
        lista.ingresarAlFinal(nuevo);
        System.out.println("Cambio realizado: " + nombreViejo + " por == " + nuevo.getNombre_jugador());
    }

   

    //Mostra todos los jugadores
    public void mostrar() {
        lista.mostrar();
    }

    //Elimina todos los jugadores
    public void eliminar() {
        lista.eliminarTodo();
        cantidad = 0;
    }
     
    // Expulsa o elimina a un jugador mediante su nombre
    public void expulsado(String nombre) {
        lista.expulsado(nombre);
        cantidad--;
    }  

    public ListaNomina verLista() {
        return lista;
    }
    
    public int verCantidadJugadores(){
        return cantidad;
    }
}
