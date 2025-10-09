package com.tyrone.tarea1;

import java.util.Scanner;

public class ConteoDigitoNumero {
    public static void main(String[] args) {
     
    //Declaracion de variables
    
        long nu1, nu1Abso; 
        short canti=0;
        Scanner capt = new Scanner(System.in);
        
        //Ingreso de datos
        System.out.print("Ingrese un numero: ");
        nu1 = capt.nextLong();
        
        //Calculo
        if (nu1 < 0){
            nu1Abso = -nu1;
        }else {
            nu1Abso = nu1;
        }
        
        if (nu1Abso == 0) {
            canti=1;
        }else{
            while (nu1Abso > 0) {
                nu1Abso /= 10;
                canti++;
            
            }
        }
       //Muestra resultados
        System.out.println("El numero " + nu1 + " tiene " + canti + " digito"+(canti>1?"s":""));
       
    } 
}
