/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaSimplementeEnlazadaCircular;

/**
 *
 * @author tyron
 */
public class Nomina {
    NodoJugador inicio;

    public Nomina() {
        inicio = null;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    // Ingresa al final
    public void ingresarAlFinal(Persona jugador) {
        NodoJugador nuevo = new NodoJugador(jugador);

        if (esVacia()) {
            inicio = nuevo;
            nuevo.setSiguiente(inicio);
        } else {
            NodoJugador aux = inicio;
            while (aux.getSiguiente() != inicio) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
        }
    }

    // Elimina jugador por su nombre
    public void eliminar(String nombre) {
        if (esVacia()){
            return;
        }

        NodoJugador actual = inicio;
        NodoJugador anterior = null;

        do {
            if (nombre.equals(actual.getDatos().getNombre_jugador())) {
                if (anterior == null) { 
                    NodoJugador temp = inicio;
                    while (temp.getSiguiente() != inicio){
                        temp = temp.getSiguiente();
                    }
                    inicio = inicio.getSiguiente();
                    temp.setSiguiente(inicio); 
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != inicio);
    }

    // Mostrar todo el contnido de la lista
    public void imprimir() {
        if (esVacia()) {
            System.out.println("Lista vacía");
            return;
        }

        NodoJugador aux = inicio;
        System.out.println("Lista tecnica: ");
        do {
            System.out.println(aux.getDatos());
            aux = aux.getSiguiente();
        } while (aux != inicio);
    }

    // Borrar toda la lista
    public void eliminarTodo() {
        inicio = null;
    }
}
