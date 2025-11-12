/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea3.listaSimplementeEnlazadaCircular;

import java.security.Principal;
import java.util.Scanner;

/**
 *
 * @author tyron
 */
public class CanchaMain {
     public static void main(String[] args) {
        Scanner capturador = new Scanner(System.in);
        Principales principal = new Principales();
       
        principal.agregarJugador(new Persona("Messi", 10, "Delantero"));
        principal.agregarJugador(new Persona("Leon", 1, "Portero"));
        principal.agregarJugador(new Persona("Arturo", 4, "Defensa"));

        System.out.println("Plantilla inicial:");
        principal.plantillaCompleta();
        
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
            System.out.print("Ingrese el numero del jugador: ");
            int numero = capturador.nextInt();
            capturador.nextLine();
            System.out.print("Ingrese el rol o posicion del jugador: ");
            String posicion = capturador.nextLine();
            principal.agregarJugador(new Persona(nombre,numero,posicion));
            
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
            System.out.print("Ingrese su nunmero: ");
            int numero = capturador.nextInt();
            capturador.nextLine();
            System.out.print("Ingrese su posicion:");
            String posicion = capturador.nextLine();
            principal.sustitucion(sustituir, new Persona(suplente, numero, posicion));
            
            huboCambio = true;
    
        }

        if(huboCambio){
            System.out.println("\nDespues de sustitucion:");
            principal.plantillaCompleta(); 
        }
        
        int iniciador = principal.cantidad * 53 + 17; //agarror un numero inicial dependiendo de la cantidad de datos q en este caso es jugadores
        int indiceRandom = (iniciador * iniciador + 37) % principal.cantidad;//saco un numero q en sea divisible para la cantidad de datos y ese valor seria un numero "ramdon" por la cantidad de datos ingresados 


        // Busco el jugador a expulsar según posición en la lista con el ciclo q me de el numero "random"
        NodoJugador actual = principal.equipo.inicio;
        for (int i = 0; i < indiceRandom; i++) {
            actual = actual.getSiguiente();
        }

        principal.expulsado(actual.getDatos().getNombre_jugador());
        System.out.println("\nDespues de una hora de juego hubo expulsados, el jugador: "+ actual.getDatos().getNombre_jugador()+ " con la camisa N*: "+ actual.getDatos().getNumero_jugador() +" fue expulsado");
        System.out.println("La plantilla quedo con "+ principal.cantidad +" jugadores: ");
        principal.plantillaCompleta();
    

    }
    
}
