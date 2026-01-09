/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

import java.util.Scanner;

/**
 *
 * @author tyron
 */
public class Main {
    public static void main(String[] args) {
        Scanner cap = new Scanner(System.in);
        ArbolABB abb = new ArbolABB(); 
        
        
        abb.añadir(new Vehiculo("BRR323", "CHEVROLET", ((short)2016), "AZUL"));
        abb.añadir(new Vehiculo("AJ337", "HONDA", ((short)2016), "AZUL"));
        abb.añadir(new Vehiculo("BRT342", "CHEVROLET", ((short)2016), "AZUL"));
        
        short preguntaMenu = 0;
         
        do{
        System.out.println("\nMenu de opciones:");
        System.out.println("1. Ingreso de vehículo");
        System.out.println("2. Retiro de vehículo");
        System.out.println("3. Imprimir totales de vehículos");
        System.out.println("4. Ver datos de vehiculos ingresados");
        System.out.println("0. Salir");
            
        System.out.print("\nIngrese una de las opciones: ");
        preguntaMenu = cap.nextShort();
        cap.nextLine();       
        
        switch (preguntaMenu) {
            
            case 0:
                System.out.println("Saliendo del sistema...");        
                return;
            case 1:
                System.out.println("===Registrando del ingreso de un vehiculo===");
                System.out.print("Ingrese la placa del vehiculo: ");
                String placa = cap.nextLine();
               

                System.out.print("Ingrese la marca del vehiculo: ");
                String marca = cap.nextLine();
                
                System.out.print("Ingrese el año de fabricacion del vehiculo: ");
                short aFabricacion = cap.nextShort();
                cap.nextLine();
                   
                System.out.print("Ingrese el color del vehiculo: ");
                String color = cap.nextLine();
                
                Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, aFabricacion, color);
                abb.añadir(nuevoVehiculo);
                break;
            
            case 2:
                System.out.println("===Retirar vehiculo===");
                System.out.print("Ingrese la placa del vehiculo: ");
                String nuplaca = cap.nextLine();              
                abb.retirarVehiculo(nuplaca);
                break;
                
            case 3:
                System.out.println("===Reporte total de Vehiculos===");               
                abb.reporte();
                break;

            case 4:
                System.out.println("===Listado de todos los Vehiculos===");                
                abb.inOrden(abb.getRaiz());
                break;
                            
            default:
                System.out.println("Escoja una de las opciones disponibles");;
                break;
        }     
            
        }  while(preguntaMenu != 0);
        
    }
            
}
