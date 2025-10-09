/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea1;

import javax.swing.JOptionPane;

public class VentanaConNumerosOrdenados {
    public static void main(String[] args) {
        //Declaracion de variables
        int nu1=0, nu2=0, nu3=0, nu4=0, nu5=0, nu6=0, nu7=0, nu8=0, nu9=0, nu10=0;
      
        //Ingreso de datos
        for (int i = 1; i <= 10; i++) {
           
            int dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el " + i + "° número:"));
            switch (i) {
                case 1:
                   nu1 = dato;
                   break;
                case 2:
                    nu2 = dato;
                    break;
                case 3:
                    nu3 = dato;
                    break;
                case 4:
                    nu4 = dato;
                    break;
                case 5:
                    nu5 = dato;
                    break;
                case 6:
                    nu6 = dato;
                    break;
                case 7:
                    nu7 = dato;
                    break;
                case 8:
                    nu8 = dato;
                    break;
                case 9:
                    nu9 = dato;
                    break;
                case 10:
                    nu10 = dato;
                    break;
                default:
                    throw new AssertionError();
            }
       
        }

        //Calculos
        
        
        //Muestra resultados
        
        System.out.println("numero 1:"+ nu1);
        JOptionPane.showMessageDialog(null, ordenadDatos(nu1, nu2, nu3, nu4, nu5, nu6, nu7, nu8, nu9, nu10, true));
        JOptionPane.showMessageDialog(null, ordenadDatos(nu1, nu2, nu3, nu4, nu5, nu6, nu7, nu8, nu9, nu10, false));
        
        
    }
    
//    public static short extraerNumeros(String dato) {
//        short numeros = 0;
//        for (int i = 0; i < dato.length(); i++) {
//            char c = dato.charAt(i);
//            if (c >= '0' && c <= '9') {
//                numeros += c;
//            }
//        }
//        return numeros;
//    }
    
    public static String ordenadDatos(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, boolean ascend) {
        int nuTemp1 = a, nuTemp2 = b, nuTemp3 = c, nuTemp4 = d, nuTemp5 = e, nuTemp6 = f, nuTemp7 = g, nuTemp8 = h, nuTemp9 = i, nuTemp10 = j;
        boolean ordenado = false;

        while (!ordenado) {
            ordenado = true;

            if (ascend ? nuTemp1 > nuTemp2 : nuTemp1 < nuTemp2) { 
                int t = nuTemp1;
                nuTemp1 = nuTemp2;
                nuTemp2 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp2 > nuTemp3 : nuTemp2 < nuTemp3) { 
                int t = nuTemp2;
                nuTemp2 = nuTemp3;
                nuTemp3 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp3 > nuTemp4 : nuTemp3 < nuTemp4) { 
                int t = nuTemp3;
                nuTemp3 = nuTemp4;
                nuTemp4 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp4 > nuTemp5 : nuTemp4 < nuTemp5) { 
                int t = nuTemp4;
                nuTemp4 = nuTemp5;
                nuTemp5 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp5 > nuTemp6 : nuTemp5 < nuTemp6) {
                int t = nuTemp5;
                nuTemp5 = nuTemp6;
                nuTemp6 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp6 > nuTemp7 : nuTemp6 < nuTemp7) {
                int t = nuTemp6;
                nuTemp6 = nuTemp7;
                nuTemp7 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp7 > nuTemp8 : nuTemp7 < nuTemp8) {
                int t = nuTemp7;
                nuTemp7 = nuTemp8;
                nuTemp8 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp8 > nuTemp9 : nuTemp8 < nuTemp9) {
                int t = nuTemp8;
                nuTemp8 = nuTemp9;
                nuTemp9 = t;
                ordenado = false;
            }
            
            if (ascend ? nuTemp9 > nuTemp10 : nuTemp9 < nuTemp10) {
                int t = nuTemp9;
                nuTemp9 = nuTemp10;
                nuTemp10 = t;
                ordenado = false;
            }
            
            
        }

        // Mostrar resultados
        System.out.println("Los numeros ordenados son: "+ nuTemp1 + " " + nuTemp2 + " " + nuTemp3 + " " + nuTemp4 + " " + nuTemp5 + " " + nuTemp6 + " " + nuTemp7 + " " + nuTemp8 + " " + nuTemp9 + " " + nuTemp10);
       
        String resul = "Los numeroso son:"+ nuTemp1 + " " + nuTemp2 + " " + nuTemp3 + " " + nuTemp4 + " " + nuTemp5 + " " + nuTemp6 + " " + nuTemp7 + " " + nuTemp8 + " " + nuTemp9 + " " + nuTemp10;
        return resul;
        
    }
}
