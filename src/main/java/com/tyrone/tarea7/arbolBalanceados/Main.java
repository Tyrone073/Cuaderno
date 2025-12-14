///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.tyrone.tarea7.arbolBalanceados;
//
//
//import java.util.Scanner;
//
///**
// *
// * @author tyron
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner cap = new Scanner(System.in);
//        ArbolBalanceado avl = new ArbolBalanceado();
//
//        short opcion;
//
//        do {
//            System.out.println("\n===== MENU =====");
//            System.out.println("1. Agregar nuevo producto");
//            System.out.println("2. Buscar producto");
//            System.out.println("3. Eliminar producto ");
//            System.out.println("4. Mostrar productos (inOrden)");
//            System.out.println("0. Salir");
//
//            System.out.print("Opción: ");
//            opcion = cap.nextShort();
//            cap.nextLine();
//
//            switch (opcion) {
//
//                case 1:
//                    System.out.println("\n=== REGISTRAR PRODUCTO ===");
//                    System.out.print("Nombre: ");
//                    String nombre = cap.nextLine();
//
//                    System.out.print("Stock: ");
//                    int stock = cap.nextInt();
//                    cap.nextLine();
//
//                    int codigo = 0;
//                    
//                    String nombreAux = nombre.toUpperCase().replace(" ", "");
//
//                    for(int i =0; i < nombreAux.length(); i++){
//
//                        char letra = nombreAux.charAt(i);
//                        if (letra >= 'A' && letra <= 'Z') {
//                            int valor = letra - 'A' + 1; // A=1, B=2, ...
//                            codigo = codigo * 10 + valor; 
//                        }
//
//                    }   
//
//                    Producto nuevo = new Producto(codigo, nombre, stock);
//                    avl.insertar(nuevo);
//
//                    System.out.println("Producto registrado con código: " + codigo);
//                    break;
//
//                case 2:
//                    System.out.println("\n=== BUSCAR PRODUCTO ===");
//                    System.out.print("Ingrese código o nombre del producto: ");
//                    String codBuscar = cap.nextLine();
//                    cap.nextLine();
//
//                    NodoDoble encontrado = avl.buscarProducto(avl.getRaiz(),codBuscar);
//
//                    if (encontrado == null) {
//                        System.out.println("Producto no encontrado");
//                    } else {
//                        System.out.println("Producto encontrado:");
//                        System.out.println(encontrado.getDato());
//                    }
//                    break;
//
//                case 3:
//                    System.out.println("\n=== ELIMINAR PRODUCTO ===");
//                    System.out.print("Ingrese el nombre o el codigo del producto a eliminar: ");
//                    String nombre1 = cap.nextLine();
//                    avl.eliminar(nombre1);
//                    break;
//
//                case 4:
//                    System.out.println("\n=== LISTA DE PRODCTOS (inOrden) ===");
//                    avl.inOrden(avl.getRaiz());
//                    break;
//
//                case 0:
//                    System.out.println("Saliendo del sistema...");
//                    break;
//
//                default:
//                    System.out.println("Opción inválida");
//            }
//
//        } while (opcion != 0);
//    }
//    
//}
