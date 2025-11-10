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
public class OrdenarDosColasValoresIndeterminados {
    public static void main(String[] args) {
       
       
        PILAShort pila1 = new PILAShort();
        PILAShort pila2 = new PILAShort();
        PILAShort pilaConjunta = new PILAShort();
        System.out.println("Ingrese los datos de la primera Pila");
        iteraAgregaNum(pila1);
        System.out.println("Ingrese los datos de la segunda Pila");
        iteraAgregaNum(pila2);
        System.out.print("Ingreso: ");
        System.out.print("Cola1= ");
        muestraDatosPila(pila1);
        System.out.print("      Cola2= ");
        muestraDatosPila(pila2);
        System.out.print("\nOrdenadas: ");
        System.out.print("Cola1= ");
        ordenarPila(pila1);
        System.out.print("      Cola2= ");
        ordenarPila(pila2);

        System.out.print("\nColaFinal: ");
        while(!pila1.Pvacio() || !pila2.Pvacio()){
            if(!pila1.Pvacio()){
                short nuPila1 = pila1.Desapilar();
                pilaConjunta.Apilar(nuPila1);
            }
             if(!pila2.Pvacio()){
                short nuPila2 = pila2.Desapilar();
                pilaConjunta.Apilar(nuPila2);
            }
            
           
        }
        ordenarPila(pilaConjunta);

    }
    private static void iteraAgregaNum (PILAShort pila){
        Scanner capturador = new Scanner(System.in);
        boolean resp = true;
        
        while (resp) {  
            System.out.print("Ingrese un numero: ");
            short num = capturador.nextShort();
            capturador.nextLine();

            pila.Apilar(num);

            System.out.println("Desea ingresar otro numero?");
            resp = capturador.nextBoolean();
        }
           
    }
    private static void ordenarPila(PILAShort pila){
        PILAShort pilaOrd = new PILAShort();
        PILAShort restaurador = new PILAShort();
        
        while (!pila.Pvacio()) {
            short nuDesapilado = pila.Desapilar();

            while (!pilaOrd.Pvacio()) {
                short ordNuDesapilado = pilaOrd.Desapilar();

                if (ordNuDesapilado > nuDesapilado) {
                    pila.Apilar(ordNuDesapilado);
                    
                } else {
                    pilaOrd.Apilar(ordNuDesapilado);
                    break;
                    
                }
            }

            pilaOrd.Apilar(nuDesapilado);
          
        }

        while (!pilaOrd.Pvacio()) {
            short valor = pilaOrd.Desapilar();
            pila.Apilar(valor);
            restaurador.Apilar(valor);
         
        }

        while (!pila.Pvacio()) {
            System.out.print(pila.Desapilar()+ " ");
            
        }
        while(!restaurador.Pvacio()){
            //tratando de recuperar los datos
            pila.Apilar(restaurador.Desapilar());
        }
    }
    
    private static void muestraDatosPila(PILAShort pila){
        PILAShort restaurador = new PILAShort();

        while (!pila.Pvacio()) {
            short num = pila.Desapilar();
//            System.out.print(num + " ");
            restaurador.Apilar(num);
        }

        while (!restaurador.Pvacio()) {
            short num = restaurador.Desapilar();
            System.out.print(num + " ");
            pila.Apilar(num);
        }
    }
    
}
