/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

/**
 *
 * @author tyron
 */
public class Cola {

    //Atributos
    private Nodo inicio;
    private Nodo fin;
    
     //Atributo aparte de una cola, se ocupa para ver cuantas veces hubo redundancia en el metodo preOrdenConteo y asi tener un conteo de objetos en este caso motos
    private int nuTotal;
    

//Constructores
    public Cola() {
    }

    public Cola(Nodo inicio, Nodo fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    //Metodos
    public boolean esVacia() {
        return inicio == null;
    }

    public void encolar(Vehiculo valor) {
        Nodo nuevo = new Nodo(valor, null);

        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSigue(nuevo);
            fin = nuevo;
        }
    }

    public Vehiculo desencolar() {

        if (!esVacia()) {
            Vehiculo dato = inicio.getDato();

            if (inicio == fin) {
                inicio = null;
                fin = null;
            } else {
                inicio = inicio.getSigue();
            }
            return dato;
        } else {
            return null;
        }
    }

    public void Imprimir() {

        if (esVacia()) {           
            System.out.println("Cola sin datos");
        } else {
            Cola aux = new Cola();

            while (inicio != null) {
                Vehiculo n = desencolar(); 
                System.out.println(n);
                aux.encolar(n);                
            }

            while (aux.inicio != null) {
                encolar(aux.desencolar());
            }
        }

    }

    
    private void preOrdenConteo(Nodo nd) {
        if (nd == null) {
            return;
        }        
        nuTotal++;
        preOrdenConteo(nd.getSigue());              
    }
    
    public int conteo(){
        nuTotal=0;
        preOrdenConteo(inicio);
        return nuTotal;
    }
     
}
