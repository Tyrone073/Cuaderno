/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea4;

import java.util.Scanner;

/**
 *
 * @author tyron
 */
public class OrdenarColaValorInderteminado {
    public static void main(String[] args) {
        Scanner capturador = new Scanner(System.in);
        boolean resp = true;
        PILAShort pilaNueva = new PILAShort();
        
        while (resp) {            
           System.out.print("Ingrese un numero: ");
           short num = capturador.nextShort();
           capturador.nextLine();
           
           pilaNueva.Apilar(num);

           System.out.println("Desea ingresar otro numero?");
           resp = capturador.nextBoolean();
           
           
        }
        System.out.println("Cola Ordenada Ascendente:");

        PILAShort pilaOrd = new PILAShort();

        while (!pilaNueva.Pvacio()) {
            short nuDesapilado = pilaNueva.Desapilar();

            while (!pilaOrd.Pvacio()) {
                short ordNuDesapilado = pilaOrd.Desapilar();

                if (ordNuDesapilado > nuDesapilado) {
                    pilaNueva.Apilar(ordNuDesapilado);
                    
                } else {
                    pilaOrd.Apilar(ordNuDesapilado);
                    break;
                    
                }
            }

            
            pilaOrd.Apilar(nuDesapilado);
          
        }

       
        while (!pilaOrd.Pvacio()) {
            pilaNueva.Apilar(pilaOrd.Desapilar());
//            System.out.println(pilaOrd.Desapilar());
         
        }

        //aprovehor la caracteristica de la pila y lo invierto
        while (!pilaNueva.Pvacio()) {
            System.out.println(pilaNueva.Desapilar());
        }
    } 
}
