/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea7.arbolBinarioDeBusqueda;

import java.util.Scanner;

/**
 *
 * @author tyron
 */
public class Main {
    public static void main(String[] args) {
        Scanner cap = new Scanner(System.in);
        ArbolBinario abb = new ArbolBinario(); 
        
        short preguntaMenu = 0;
         
        do{
        System.out.println("\nMenu de opciones:");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Actualizar Stock de un producto");
        System.out.println("3. Buscar un producto");
        System.out.println("4. Eliminar un producto");
        System.out.println("5. Ver todos los productos");
        System.out.println("0. Salir");
            
        System.out.print("\nIngrese una de las opciones: ");
        preguntaMenu = cap.nextShort();
        cap.nextLine();
        int codigo = 0;
        String nombre;
        int stock;
        
        switch (preguntaMenu) {
            
            case 0:
                System.out.println("Saliendo del sistema...");        
                return;
            case 1:
                System.out.println("===Registrando el producto===");
                System.out.print("Ingrese el nombre del producto: ");
                nombre = cap.nextLine();

                System.out.print("Ingrese la catidad del producto a guardar: ");
                stock = cap.nextInt();
                cap.nextLine();
                   
                //Generando codigo unico mediante la concatenacion del orden de las letras mediaante numeros
                
                String nombreAux = nombre.toUpperCase().replace(" ", "");

                for(int i =0; i < nombreAux.length(); i++){

                    char letra = nombreAux.charAt(i);
                    if (letra >= 'A' && letra <= 'Z') {
                        int valor = letra - 'A' + 1; // A=1, B=2, ...
                        codigo = codigo * 10 + valor; 
                    }

                }
                System.out.println("El producto se registro con el codigo unico: "+ codigo);
                Producto nuevoProducto = new Producto(codigo, nombre, stock);
                abb.añadir(nuevoProducto);
                break;
            
            case 2:
                System.out.println("===Actualizando Stock de un producto===");
                System.out.print("Ingrese el codigo unico o el nombre del producto: ");
                nombre = cap.nextLine();
                System.out.print("Ingrese la cantidad de producto: ");
                stock = cap.nextInt();
                abb.insertarProductoExistente(nombre, stock);
                break;
                
            case 3:
                System.out.println("===Buscando un producto===");
                System.out.print("Ingrese el codigo unico o el nombre del producto: ");
                nombre = cap.nextLine();
                abb.imprimirBusquedaDeUnProducto(abb.getRaiz(), nombre);
                break;

            case 4:
                System.out.println("===Eliminando un producto===");
                System.out.print("Ingrese el codigo unico o el nombre del producto: ");
                nombre = cap.nextLine();
                abb.eliminarProducto(abb.getRaiz(),nombre);
                break;
                
            case 5:
                System.out.println("===Arbol completo de los productos existentes====");
                System.out.println("===Metodo preOrden===");
                abb.preOrden(abb.getRaiz());
                System.out.println("");
                
                System.out.println("===Metodo inOrden===");
                abb.inOrden(abb.getRaiz());
                System.out.println("");
                
                System.out.println("===Metodo posOrden===");
                abb.posOrden(abb.getRaiz());
                
                break;
            default:
                System.out.println("Escoja una de las opciones disponibles");;
                break;
        }     
            
        }  while(preguntaMenu != 0);
        
    }
    
}
