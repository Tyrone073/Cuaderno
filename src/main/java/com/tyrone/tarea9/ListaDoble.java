/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

/**
 *
 * @author tyron
 */
public class ListaDoble {

    //Atributos
    private NodoArbol inicio;
    private NodoArbol fin;
    
    //nota
        //sigue = derecha 
        //ante = izquierda

    //constructores
    public ListaDoble() {
    }

    public ListaDoble(NodoArbol inicio, NodoArbol fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    //Metodos
    //Lista vacia
    public boolean ListaVacia() {
        return inicio == null;
    }

    //Insertar inicio o final
    public void InsertInicio(Vehiculo dato) {
        NodoArbol nuevo = new NodoArbol(null, dato, null);
        if (ListaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setDerecha(inicio);
            inicio.setIzquierda(nuevo);
            inicio = nuevo;
        }
    }

    public void InsertFinal(Vehiculo dato) {
        NodoArbol nuevo = new NodoArbol(null, dato, null);
        if (ListaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setDerecha(nuevo);
            inicio.setIzquierda(fin);
            fin = nuevo;
        }
    }

    // practicando
    public String EliminarFinal() {
        if (ListaVacia()) {
            return "Lista vacia";
        } else {
            String n = fin.getDato().getPlaca();
            fin = fin.getIzquierda();
            fin.setDerecha(null);
            return n;
        }
    }

    public void EliminarInicio() {
        if (ListaVacia()) {
            System.out.println("Lista vacia");
        } else {
            Vehiculo n = inicio.getDato();
            inicio = inicio.getDerecha();
            inicio.setIzquierda(null);
            System.out.println(n);
        }
    }

    //Imprimir sin perder dato
    public void Imprimir() {
        if (ListaVacia()) {
            System.out.println("Lista esta vacia");
        } else {
            NodoArbol aux = inicio;
            while (aux != null) {
                System.out.println(aux.getDato());
                aux = aux.getDerecha();

            }
        }
    }

}
