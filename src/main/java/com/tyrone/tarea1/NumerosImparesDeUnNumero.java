package com.tyrone.tarea1;

import java.util.Scanner;


public class NumerosImparesDeUnNumero {
    public static void main(String[] args) {
        //Declaracion de variables
        short nu1;
        int nu1Abso;
        Scanner capt = new Scanner(System.in);
        
        //Ingreso de datos
        System.out.print("Ingrese un numero:");
        nu1 = capt.nextShort();
        //Calculo
        if (nu1 < 0){
            nu1Abso = -nu1;
        }else {
            nu1Abso = nu1;
        }
        System.out.println("Numeros impares entre el 1 y "+nu1+" : ");
        for (int i = 1; i < nu1Abso; i++) {
            if (i % 3 == 0) {
                
                if (nu1 < 0 ) {
                    //efecto reflejo(Numero mayor+numero, es este caso numero menor negativo +  numero mayor negativo) 
                    System.out.print(-nu1Abso+i + " ");
                }else   {
                    System.out.print(i+" ");
                }
            }
        }
        //Muestra resultados
    
    }
    
}
