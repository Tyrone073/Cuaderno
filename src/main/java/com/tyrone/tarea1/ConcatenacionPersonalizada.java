package com.tyrone.tarea1;
import java.util.Scanner;

/**
 *
 * @author tyron
 */
public class ConcatenacionPersonalizada {
    public static void main(String[] args) {
        //Declaracion de variables
        Scanner capturador = new Scanner(System.in);
        String nombres, apellidos;
        short anioNacimiento;

        //Ingreso de datos
        System.out.println("Ingrese sus dos nombres:");
        nombres = capturador.nextLine();
        System.out.println("Ingrese sus dos apellidos:");
        apellidos = capturador.nextLine();
        System.out.println("Ingrese su año de nacimiento:");
        anioNacimiento = capturador.nextShort();

        //Calculo

        //Muestra resultados
        System.out.println("Hola "+ nombres + " " + apellidos + " usted tiene " + (2025 - anioNacimiento) + " años de edad.\n" + "La UTM da la biencenida.......");
    }
}
