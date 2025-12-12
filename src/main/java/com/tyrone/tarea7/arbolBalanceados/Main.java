/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea7.arbolBalanceados;


import java.util.Scanner;

/**
 *
 * @author tyron
 */
public class Main {
    public static void main(String[] args) {
        ArbolBalanceado abb = new ArbolBalanceado();
        Scanner cap = new Scanner(System.in);
        System.out.println("Registre el producto");
        String nombre = cap.nextLine();
        
        System.out.println("Ingrese la catidad del progucto a guardar");
        int stock = cap.nextInt();
      
        int codigo = 0;
        for(int i =0; i < nombre.length(); i++){
            String nombreAux = nombre.toUpperCase().replace(" ", "");
            char letra = nombreAux.charAt(i);
            if (letra >= 'A' && letra <= 'Z') {
                int valor = letra - 'A' + 1; // A=1, B=2, ...
                codigo = codigo * 10 + valor; 
            }
            
        }
        System.out.println("el producto se guardo con el codigo unico: "+ codigo);
        Producto nuevoProducto = new Producto(codigo, nombre, stock);
//        abb.añadir(nuevoProducto);
        
    }
    
}
