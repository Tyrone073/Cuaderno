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
public class MuestraPilaDeNumerosConSusNombres {
    public static void main(String[] args) {
        Scanner capturador = new Scanner(System.in);
        PILAShort pila = new PILAShort();
        PILAString pilaNombreNu = new PILAString();
        
        System.out.println("Ingrese 10 numeros entre el 1 y el 15");
        
        for (short i = 1; i <= 10; i++) {
            System.out.print("Ingrese el "+ i +"* numero: ");
            short num = capturador.nextShort();
            capturador.nextLine();

            if(num > 0 && num <= 15){
               pila.Apilar(num); 
            }else{
                System.out.println("Solo se permite mumeros ente el 1 y 15");
                i--;
            }  
            
        }
        //aqui iba a invertir la pila para q muestre los resultados conforme se ingresaron los datos pero al ver la imagen de la tarea me da a entender q 
        //muestre los datos con forme se guardaron osea iniciando desde el top y la estructura LIFO nos saca como primer elemento al ultimo dato ingresado 
        //y segun la imagen saca al cuatro como primero y supngo q ese fue el ultimo en ser ingresado segun el orden jerarquico de los numeros, igualmente si estoy mal solo descomente esta parte del codigo.
//        PILAShort restaurador = new PILAShort();
//         
//        while (!pila.Pvacio()) {
//            restaurador.Apilar(pila.Desapilar());
//        }
//
//        pila=restaurador;
        
        System.out.println("Numeros ingresados:");
        System.out.println("TOP     Nombre");
        while(!pila.Pvacio()){
            short numPila = pila.Desapilar();

            pilaNombreNu.Apilar("quince");
            pilaNombreNu.Apilar("catorce");
            pilaNombreNu.Apilar("trece");
            pilaNombreNu.Apilar("doce");
            pilaNombreNu.Apilar("once");
            pilaNombreNu.Apilar("diez");
            pilaNombreNu.Apilar("nueve"); 
            pilaNombreNu.Apilar("ocho");
            pilaNombreNu.Apilar("siete");
            pilaNombreNu.Apilar("seis");
            pilaNombreNu.Apilar("cinco");
            pilaNombreNu.Apilar("cuatro");
            pilaNombreNu.Apilar("tres");
            pilaNombreNu.Apilar("dos");
            pilaNombreNu.Apilar("uno");
            for(short x = 1; x <= numPila; x++){
               String a = pilaNombreNu.Desapilar();
                if(x == numPila){
                    System.out.println(numPila+"      "+a);
                } 
            }

        }
       
    }
    
}
