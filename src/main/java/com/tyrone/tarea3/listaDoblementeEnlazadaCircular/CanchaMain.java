/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaDoblementeEnlazadaCircular;

import java.util.Scanner;

/**
 *
 * @author tyron
 */
public class CanchaMain {
    public static void main(String[] args) {
        ListaTitular titulares = new ListaTitular();
        Scanner capturador = new Scanner(System.in);

        titulares.agregarJugador(new Jugador("Messi", 10, "Delantero"));
        titulares.agregarJugador(new Jugador("Ter Stegen", 1, "Portero"));
        titulares.agregarJugador(new Jugador("Araujo", 4, "Defensa"));
        titulares.agregarJugador(new Jugador("Joel", 17, "Delantero"));
        titulares.agregarJugador(new Jugador("Leon", 5, "Defensa"));
        titulares.agregarJugador(new Jugador("Arturo", 8, "Defensa"));

        
        System.out.println("Plantilla inicial:");
        titulares.mostrar();
        
        String resp = "S";
        boolean huboCambio = false;
        
        do{
            System.out.println("Desea agregar mas jugadores? Responda con S o N");
            resp = capturador.nextLine();
            
            if(resp.equalsIgnoreCase("N")){
                break;
            }
            
            System.out.print("Ingrese el nombre del jugador: ");
            String nombre = capturador.nextLine();
            System.out.print("Ingrese el numero dorsal del jugador: ");
            int numero = capturador.nextInt();
            capturador.nextLine();
            System.out.print("Ingrese el rol o posicion del jugador: ");
            String posicion = capturador.nextLine();
            titulares.agregarJugador(new Jugador(nombre,numero,posicion));
            
        }
        while(!resp.equalsIgnoreCase("N"));
        
        String resp2 = "S";
        while(!resp2.equalsIgnoreCase("N")){
            System.out.println("Desea sustituir a algun jugador? Responda con S o N");
            resp2 = capturador.nextLine();
            if(resp2.equalsIgnoreCase("N")){
                break;
            }
            
            System.out.print("Ingrese el nombre del jugador a sustituir: ");
            String sustituir = capturador.nextLine();
            System.out.print("Ingrese el nombre del suplente: ");
            String suplente = capturador.nextLine();
            System.out.print("Ingrese su nunmero dorsal: ");
            int numero = capturador.nextInt();
            capturador.nextLine();
            System.out.print("Ingrese su posicion:");
            String posicion = capturador.nextLine();
            titulares.cambio(sustituir, new Jugador(suplente, numero, posicion));
            
            huboCambio = true;
    
        }

        if(huboCambio){
            System.out.println("\nDespues de sustitucion:");
            titulares.mostrar();
        }
        
        int iniciador = titulares.verCantidadJugadores() * 53 + 17; //agarror un numero inicial dependiendo de la cantidad de datos q en este caso es jugadores
        int indiceRandom = (iniciador * iniciador + 37) % titulares.verCantidadJugadores();//saco un numero q en sea divisible para la cantidad de datos y ese valor seria un numero "ramdon" por la cantidad de datos ingresados 


        // Busco el jugador a expulsar según posición en la lista con el ciclo q me de el numero "random"
        NodoJugador actual = titulares.verLista().verInicio();
        for (int i = 0; i < indiceRandom; i++) {
            actual = actual.getSiguiente();
        }

        titulares.expulsado(actual.getDatos().getNombre_jugador());
        System.out.println("\nDespues de una hora de juego hubo expulsados, el jugador: "+ actual.getDatos().getNombre_jugador()+ " con la camisa N*: "+ actual.getDatos().getNumero_dorsal()+" fue expulsado");
        System.out.println("La plantilla quedo con "+ titulares.verCantidadJugadores() +" jugadores: ");
        titulares.mostrar();
    

    }
    
}
