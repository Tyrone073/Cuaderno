/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaDoblementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class ListaNomina {
    private NodoJugador inicio;

    public ListaNomina() {
        inicio = null;
    }

    public boolean esVacia() {
        return inicio == null;
    }

   
    public void ingresarAlFinal(Jugador jugador) {
        NodoJugador nuevo = new NodoJugador(jugador);
        if (esVacia()) {
            inicio = nuevo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
        } else {
            NodoJugador ultimo = inicio.getAnterior();

            nuevo.setSiguiente(inicio);
            nuevo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevo);
            inicio.setAnterior(nuevo);
        }
    }

    //Elimina jugador por su nombre
    public void eliminar(String nombre) {
        if (esVacia()){ 
            return;    
        }

        NodoJugador actual = inicio;
        do {
            if (actual.getDatos().getNombre_jugador().equalsIgnoreCase(nombre)) {
                if (actual.getSiguiente() == actual) {
                    inicio = null;
                } else {
                    actual.setAnterior(actual.getSiguiente());
                    actual.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(actual.getAnterior());
                    actual.setAnterior(actual.getAnterior());
                    if (actual == inicio){ 
                        inicio = actual.getSiguiente();     
                    }
                }
                return;
            }
            actual = actual.getSiguiente();
        } while (actual != inicio);
    }


    public void mostrar() {
        if (esVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        NodoJugador actual = inicio;
        System.out.println("Lista tecnica: ");
        do {
            System.out.println(actual.getDatos());
            actual = actual.getSiguiente();
        } while (actual != inicio);
    }

    
    public void eliminarTodo() {
        inicio = null;
    }

    public void expulsado(String nombre) { // creo q este metodo tambien lo pide pero solo veo la palabra expulsado
        eliminar(nombre);
        System.out.println("Jugador expulsado: " + nombre);
    }
    
    public NodoJugador verInicio(){
        return inicio;
    }
    
}
