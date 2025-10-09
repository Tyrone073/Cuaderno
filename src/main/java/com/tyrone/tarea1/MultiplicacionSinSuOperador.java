package com.tyrone.tarea1;
import java.util.Scanner;

public class MultiplicacionSinSuOperador {
    public static void main(String[] args) {
        //Declaracion de variables
        Scanner capturador = new Scanner(System.in);
        short nu1, nu2;
        int multi=0, nu2Abso=0, nu1Abso;

        //Ingreso de datos
        System.out.println("Ingrese el primer numero:");
        nu1 = capturador.nextShort();
        System.out.println("Ingrese el segundo numero:");
        nu2 = capturador.nextShort();

        //Calculo
        if (nu1 < 0){
            nu1Abso = -nu1;
        }else {
            nu1Abso = nu1;
        }

        if (nu2 < 0){
            nu2Abso = -nu2;
        }else {
            nu2Abso = nu2;
        }

        for (int i = 0; i < nu2Abso; i++) {
            multi = multi + nu1Abso;
        }

        if ((nu1 < 0 && nu2 > 0) || (nu1 > 0 && nu2 < 0)) {
            multi = -multi;
        }

        
        System.out.println("La multiplicacion entre " + nu1 + " x " + nu2 + " es: " + multi);
    }
}

