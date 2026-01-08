/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

/**
 *
 * @author tyron
 */
public class ArbolABB {
    //Atributos
    private NodoArbol raiz;
    
    //Atributos apartes de un ABB
    private ListaDoble listaDoble = new ListaDoble();
    private Cola cola = new Cola();
    private int nuTotal = 0;
    private int nuMotos = 0;
    private int nuCarros = 0;
    private int nuMotosRetiradas = 0;
    private int nuCarrosRetirados = 0;

    public ArbolABB() {
    }

    public ArbolABB(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public boolean esVacia() {
        return raiz == null;
    }

    public void añadir(Vehiculo dato) {
        NodoArbol nuevoNodo = new NodoArbol(null, dato, null);
        insertarNuevoCarro(nuevoNodo, raiz);

    }

    private void insertarNuevoCarro(NodoArbol nuevo, NodoArbol r) {
        
         

        if (esVacia()) {
            raiz = nuevo;
        } else if (nuevo.getDato().getId()< r.getDato().getId()) {//se ordena por id ya q se guardan los carros por orden de llegada y el id aumenta conforme ese orden
            if (r.getIzquierda() == null) {
                r.setIzquierda(nuevo);
            } else {
                insertarNuevoCarro(nuevo, r.getIzquierda());
            }
        } else if (nuevo.getDato().getId() > r.getDato().getId()) {
            if (r.getDerecha() == null) {
                r.setDerecha(nuevo);
            } else {
                insertarNuevoCarro(nuevo, r.getDerecha());
            }
        } else {
           //nunca se lanzara ya q el id va a cambiar pero por si acaso lo dejo
            System.out.println("Datos" + nuevo.getDato() + "esta duplicado ...");
        }
    }

    public void preOrden(NodoArbol nd) {
        if (nd == null) {
            return;
        }
        System.out.println(" " + nd.getDato());
        preOrden(nd.getIzquierda());
        preOrden(nd.getDerecha());
    }

    public void inOrden(NodoArbol nd) {

        if(nd != null){
            inOrden(raiz.getIzquierda());
            System.out.println(" " + nd.getDato());
            inOrden(nd.getDerecha());
        }
    }
    
    public void posOrden(NodoArbol nd) {

        if(nd != null){
            inOrden(raiz.getIzquierda());
            inOrden(nd.getDerecha());
            System.out.println(" " + nd.getDato());
        }
    }
    
    private void preOrdenConteo(NodoArbol nd) {
        if (nd == null) {
            return;
        }
        if(nd.getDato().getPlaca().toLowerCase().charAt(2) >= 'a' && nd.getDato().getPlaca().toLowerCase().charAt(2) <= 'z'){
            nuCarros++ ;            
        }else{           
            nuMotos++;
        }
        nuTotal++;

        preOrdenConteo(nd.getIzquierda());
        preOrdenConteo(nd.getDerecha());
       
    }
    
    
    public void retirarVehiculo(String nuPlaca) {
   
        NodoArbol vehiculoActual = buscarUnVehiculo(raiz, nuPlaca);
        if(vehiculoActual != null){

            String placa = vehiculoActual.getDato().getPlaca().toLowerCase();
            if(placa.charAt(2) >= 'a' && placa.charAt(2) <= 'z'){
                listaDoble.InsertInicio(vehiculoActual.getDato());
                nuCarrosRetirados++;
            }else{
                listaDoble.InsertInicio(vehiculoActual.getDato());
                nuMotosRetiradas++;
            }
         
        }else{
            System.out.println("Vehiculo no encontrado");
        }
        
        
    }
    
    private NodoArbol buscarUnVehiculo(NodoArbol actual,String nuPlaca){
         if (actual == null) {          
            return null;
        }
        if (actual.getDato().getPlaca().equalsIgnoreCase(nuPlaca)) {
            return actual;            
        }
        
        NodoArbol encontradoEnIzquierda = buscarUnVehiculo(actual.getIzquierda(), nuPlaca); 
        if (encontradoEnIzquierda != null) {
            return encontradoEnIzquierda;
        }
 
        return buscarUnVehiculo(actual.getDerecha(), nuPlaca);
              
    }


    public void eliminarVehiculo(String nuPlaca) {
       
        raiz = borrarNodo(raiz, nuPlaca);
        if (raiz == null) {
            System.out.println("Producto eliminado o árbol vacío");
        } else {
            System.out.println("Operación de eliminación completada");
        }
    }
    
    private NodoArbol borrarNodo(NodoArbol nodo, String nuPlaca) {
        if(nodo == null){
            return null;
        }
        else {
            NodoArbol vehiculoEncontrado = buscarUnVehiculo(nodo, nuPlaca);
            if(vehiculoEncontrado == null){
                return null;
            }
            
            int id = vehiculoEncontrado.getDato().getId();
            
            // codigo de la guia
                if(id < nodo.getDato().getId()){
                    nodo.setIzquierda(borrarNodo(nodo.getIzquierda(), nuPlaca));
                    // el id es mayor que los datos del nodo, busque el id en el subárbol derecho
                }else if(id > nodo.getDato().getId()){
                    nodo.setDerecha(borrarNodo(nodo.getDerecha(), nuPlaca));
                    // Si el id es igual a los datos del nodo, es decir, hemos encontrado que el nodo debe eliminarse
                }else {
                // Si el nodo que se va a eliminar no tiene un hijo, establezca el nodo en nulo
                    if(nodo.getIzquierda() == null && nodo.getDerecha() == null){
                        nodo = null;
                    // Si el nodo a eliminar tiene solo un hijo a la derecha
                    }else if (nodo.getIzquierda() == null ) {
                        nodo = nodo.getDerecha();
                    }
                    // Si el nodo a eliminar tiene solo un hijo a la izquierda
                    else if (nodo.getDerecha() == null ) {
                        nodo = nodo.getIzquierda();
                    }
                    // Si el nodo a eliminar tiene dos hijos nodo
                    else {
                    // luego encuentra el nodo mínimo del subárbol derecho
                        NodoArbol temp = minNodo(nodo.getDerecha());
                        // Intercambia los datos entre nodo y temp
                        nodo.setDato(temp.getDato());
                        // Elimina el nodo duplicado del subárbol derecho
                        nodo.setDerecha(borrarNodo(nodo.getDerecha(), temp.getDato().getPlaca()));
                    }
                }
            
            return nodo;
        }
    }
       
    public NodoArbol minNodo(NodoArbol raiz) {
        if (raiz.getIzquierda() != null){
            return minNodo(raiz.getIzquierda());
        }else{
            return raiz;
        }
    }
    
    public void reporte(){
        preOrdenConteo(raiz);
        
        System.out.println("Total de Vehiculos en el garaje: "+nuTotal);
        System.out.println("Total de Motos en el garaje: "+nuMotos);
        System.out.println("Total de Carros en el garaje: "+nuCarros);
        System.out.println("Total de Motos retiradas: "+nuMotosRetiradas);
        System.out.println("Total de Carros retiradas: "+nuCarrosRetirados);
        
    }
}
