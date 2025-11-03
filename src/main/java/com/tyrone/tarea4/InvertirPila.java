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
public class InvertirPila {
    public static void main(String[] args) {
        Scanner capturador = new Scanner(System.in);
        System.out.print("Ingrese una palabra: ");
        String palabra = capturador.nextLine();
        
        PILA nuevaPila = new PILA();
        for (int nu=1; nu <= palabra.length(); nu++) {
           
            nuevaPila.Apilar(palabra.charAt(-(-palabra.length()+nu)));
            System.out.print(nuevaPila.Desapilar());
            
            if(nu < palabra.length()){
                System.out.print("-");
            }
        }
        
//Logica de -(-palabra.length()+nu)use la misma logica de la tarea anterior para invertir un numero(Reflejo logico), la logica es: 
//como bien se sabe el signo '-' transforma el signo al opuesto
//dentro del parentesis transforma el tamaño total de la palabra a el signo opuesto y lo sumamos a la variabel del for 'nu', en este caso la inicie en 1 para no sumarselos en la operacion ni restarlo en el if
//ejemp = -9+1=-8 al quedar en signo negativo asi q por eso encierro todo eso en parentesis e invierto el signo para q sea un valor permitodo para el incidice del metodo charArt de String
//tambien al ponerle el signo menor-igual en el for(>=), me aseguro de q la variable 'nu' contenga el mismo numero del tamaño de la letra para q la operacion al tener el valor maximo me de 0 ya q es el primer indice de lectura

    }
    
}
