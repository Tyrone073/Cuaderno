/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea6;

/**
 *
 * @author tyron
 */
public class MainPuntajeMejoresPostulacion {

    public static void main(String[] args) {
        ListaDoble listaDoble = new ListaDoble();

        System.out.println("Procesando registros de datos...");

        for (int i = 1; i <= 75; i++) {
            float puntaje = (float)((Math.round(Math.random() * 8000) / 100.0)+ 20.0);

            String nombres = "Tyrone Joel Juan Gabriel Pedro Luis Carlos Maria Elena Pepa Sofia Alejandra Ana";
            int indice = ((int)(Math.random() * (nombres.length() - 12)) + i) % (nombres.length() - 12);

            String nombre = nombres.substring(indice, indice + 12);

            Estudiante estudiante = new Estudiante(i, nombre.toUpperCase(), puntaje);
            listaDoble.InsertInicio(estudiante);
            System.out.print("=");

            if (i == 75) {
                System.out.println("\n===Datos Cargados con exito===");
            }
        }

  
        System.out.println("Todos los postulantes:");
        listaDoble.Imprimir();
        
        System.out.println("Selección de los 50 cupos:");
        listaDoble.SelecTop50MejAlumnosEnCalif();
    }

}
