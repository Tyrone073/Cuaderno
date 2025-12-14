///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.tyrone.tarea7.arbolBalanceados;
//
////Este codigo esta en proceso, en el ejercicio me parece q solo indica el uso de Arbol binario de Busqueda aunq el titulo y el objetivo dice lo contrario 
////pero igualmente esta comentado este codigo por si acaso y no se como  q aun hace falta la explicacion en su clase
///**
// *
// * @author tyron
// */
//public class ArbolBalanceado {
//
//    private NodoDoble raiz;
//
//    public ArbolBalanceado() {
//    }
//
//    public ArbolBalanceado(NodoDoble raiz) {
//        this.raiz = raiz;
//    }
//
//    public NodoDoble getRaiz() {
//        return raiz;
//    }
//
//    public void setRaiz(NodoDoble raiz) {
//        this.raiz = raiz;
//    }
//
//    private int altura(NodoDoble n) {
//        return (n == null) ? 0 : n.getAltura(); //condicion ternaria donde pone 0 cuando es un valor nulo o la actura q se le pase por el objeto del parametro
//    }
//
//    private int balance(NodoDoble n) {
//        if (n == null) {
//            return 0;
//        }
//        return altura(n.getIzquierda()) - altura(n.getDerecha());
//    }
//
//    public void insertar(Producto dato) {
//        raiz = insertarAVL(raiz, dato);
//    }
//
//    private NodoDoble insertarAVL(NodoDoble nodo, Producto dato) {
//
//        if (nodo == null) {
//            return new NodoDoble(null, dato, null, 1);
//        }
//
//        if (dato.getCodigo() < nodo.getDato().getCodigo()) {
//            nodo.setIzquierda(insertarAVL(nodo.getIzquierda(), dato));
//        } else if (dato.getCodigo() > nodo.getDato().getCodigo()) {
//            nodo.setDerecha(insertarAVL(nodo.getDerecha(), dato));
//        } else {
//            return nodo;
//        }
//
//        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierda()), altura(nodo.getDerecha())));
//
//        int balance = balance(nodo);
//
//        // Caso izquierda - izquierda
//        if (balance > 1 && dato.getCodigo() < nodo.getIzquierda().getDato().getCodigo()) {
//            return rotacionDerecha(nodo);
//        }
//
//        // Caso derecha - derecha
//        if (balance < -1 && dato.getCodigo() > nodo.getDerecha().getDato().getCodigo()) {
//            return rotacionIzquierda(nodo);
//        }
//
//        // Caso izquierda - derecha
//        if (balance > 1 && dato.getCodigo() > nodo.getIzquierda().getDato().getCodigo()) {
//            nodo.setIzquierda(rotacionIzquierda(nodo.getIzquierda()));
//            return rotacionDerecha(nodo);
//        }
//
//        // Caso derecha - izquierda
//        if (balance < -1 && dato.getCodigo() < nodo.getDerecha().getDato().getCodigo()) {
//            nodo.setDerecha(rotacionDerecha(nodo.getDerecha()));
//            return rotacionIzquierda(nodo);
//        }
//
//        return nodo;
//    }
//
//    private NodoDoble rotacionDerecha(NodoDoble y) {
//        NodoDoble x = y.getIzquierda();
//        NodoDoble aux = x.getDerecha();
//
//        x.setDerecha(y);
//        y.setIzquierda(aux);
//
//        y.setAltura(Math.max(altura(y.getIzquierda()), altura(y.getDerecha())) + 1);
//        x.setAltura(Math.max(altura(x.getIzquierda()), altura(x.getDerecha())) + 1);
//
//        return x;
//    }
//
//    private NodoDoble rotacionIzquierda(NodoDoble x) {
//        NodoDoble y = x.getDerecha();
//        NodoDoble aux = y.getIzquierda();
//
//        y.setIzquierda(x);
//        x.setDerecha(aux);
//
//        x.setAltura(Math.max(altura(x.getIzquierda()), altura(x.getDerecha())) + 1);
//        y.setAltura(Math.max(altura(y.getIzquierda()), altura(y.getDerecha())) + 1);
//
//        return y;
//    }
//
//    public NodoDoble buscarProducto(NodoDoble actual, String idONombre) {
//
//        if (actual == null) {
//            return null;
//        }
//
//        if (idONombre.matches("\\d+")) {
//            int id = Integer.parseInt(idONombre);
//
//            if (id == actual.getDato().getCodigo()) {
//                return actual;
//            }
//            if (id < actual.getDato().getCodigo()) {
//                return buscarProducto(actual.getIzquierda(), idONombre);
//            } else {
//                return buscarProducto(actual.getDerecha(), idONombre);
//            }
//        }
//
//        if (actual.getDato().getNombre().equalsIgnoreCase(idONombre)) {
//            return actual;
//        }
//
//        NodoDoble izq = buscarProducto(actual.getIzquierda(), idONombre);
//        if (izq != null) {
//            return izq;
//        }
//
//        return buscarProducto(actual.getDerecha(), idONombre);
//    }
//
//    public void eliminar(String idONombre) {
//        raiz = borrarAVL(raiz, idONombre);
//    }
//
//    private NodoDoble borrarAVL(NodoDoble nodo, String idONombre) {
//
//        if (nodo == null) {
//            return null;
//        }
//
//        int id = convertirAId(idONombre);
//
//        if (id < nodo.getDato().getCodigo()) {
//            nodo.setIzquierda(borrarAVL(nodo.getIzquierda(), idONombre));
//        } else if (id > nodo.getDato().getCodigo()) {
//            nodo.setDerecha(borrarAVL(nodo.getDerecha(), idONombre));
//        } else {
//
//            // Nodo encontrado
//            if (nodo.getIzquierda() == null || nodo.getDerecha() == null) {
//                nodo = (nodo.getIzquierda() != null) ? nodo.getIzquierda() : nodo.getDerecha();
//            } else {
//                NodoDoble temp = minNodo(nodo.getDerecha());
//                nodo.setDato(temp.getDato());
//                nodo.setDerecha(borrarAVL(nodo.getDerecha(), String.valueOf(temp.getDato().getCodigo())));
//            }
//        }
//
//        if (nodo == null) {
//            return null;
//        }
//
//        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierda()), altura(nodo.getDerecha())));
//        int balance = balance(nodo);
//
//        if (balance > 1 && balance(nodo.getIzquierda()) >= 0) {
//            return rotacionDerecha(nodo);
//        }
//
//        if (balance > 1 && balance(nodo.getIzquierda()) < 0) {
//            nodo.setIzquierda(rotacionIzquierda(nodo.getIzquierda()));
//            return rotacionDerecha(nodo);
//        }
//
//        if (balance < -1 && balance(nodo.getDerecha()) <= 0) {
//            return rotacionIzquierda(nodo);
//        }
//
//        if (balance < -1 && balance(nodo.getDerecha()) > 0) {
//            nodo.setDerecha(rotacionDerecha(nodo.getDerecha()));
//            return rotacionIzquierda(nodo);
//        }
//
//        return nodo;
//    }
//
//    private NodoDoble minNodo(NodoDoble nodo) {
//        while (nodo.getIzquierda() != null) {
//            nodo = nodo.getIzquierda();
//        }
//        return nodo;
//    }
//
//    //aisle en un metodo la forma para convertir el texto de entrada a un numero cancatenando el orden del abecedario es la misma logica q el otro codigo pero mas "profecional"
//    private int convertirAId(String texto) {
//        
//        if (texto.matches("\\d+")) {
//            return Integer.parseInt(texto);
//        }
//
//        int id = 0;
//        texto = texto.toUpperCase().replace(" ", "");
//        for (char c : texto.toCharArray()) {
//            id = id * 10 + (c - 'A' + 1);
//        }
//        return id;
//    }
//
//    //desconosco si estos metodos existen en el arbo balanceado pero igua lo agrego
//    public void inOrden(NodoDoble n) {
//        if (n != null) {
//            inOrden(n.getIzquierda());
//            System.out.println(n.getDato());
//            inOrden(n.getDerecha());
//        }
//    }
//
//    public void preOrden(NodoDoble n) {
//        if (n != null) {
//            System.out.println(n.getDato());
//            preOrden(n.getIzquierda());
//            preOrden(n.getDerecha());
//        }
//    }
//
//    public void posOrden(NodoDoble n) {
//        if (n != null) {
//            posOrden(n.getIzquierda());
//            posOrden(n.getDerecha());
//            System.out.println(n.getDato());
//        }
//    }
//
//}
