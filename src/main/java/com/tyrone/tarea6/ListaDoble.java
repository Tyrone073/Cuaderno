/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea6;

/**
 *
 * @author tyron
 */
public class ListaDoble {
    //atributos
    private NodoDoble inicio;
    private NodoDoble fin;
    
    //constructor

    public ListaDoble() {
    }

    public ListaDoble(NodoDoble inicio, NodoDoble fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    //Metodos
    //Lista vacia
    public boolean ListaVacia(){
        return inicio == null;
    }
    
    //Insertar inicio o final
    public void InsertInicio(Estudiante dato){
        NodoDoble nuevo = new NodoDoble(null, dato, null);
        if (ListaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            nuevo.setDato(dato);
            nuevo.setSigue(inicio);
            inicio.setAnte(nuevo);
            // a mi parecer el codigo mas entendible era nuevo.setAnte(inicio); e inicio.setSigue(nuevo); pero como no debemos cambiar la estructura no hago este cambio
            inicio = nuevo;
        }
    }
    
    public void InsertFinal(Estudiante dato){
        NodoDoble nuevo = new NodoDoble(null, dato, null);
        if (ListaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSigue(nuevo);
            nuevo.setAnte(fin);
            fin = nuevo;
        }
    }
    
    // Eliminar inicio o final
    public String EliminarFinal(){
        if (ListaVacia()) {
            return "Lista vacia";
        } else {
            String n = fin.getDato().getNombre();
            fin = fin.getAnte();
            fin.setSigue(null);
            return n;
        }
    }
    
       public Estudiante EliminarInicio(){
        if (ListaVacia()) {
            System.out.println("Lista vacia");
            return null;
        } else {
            Estudiante n = inicio.getDato();
            inicio = inicio.getSigue();
            inicio.setAnte(null);
            return n;
        }
    }
    
    //Imprimir sin perder dato
       public void Imprimir(){
           if (ListaVacia()) {
               System.out.println("Lista esta vacia");
           } else {
//               while(inicio != null){
//                   System.out.println("el valor  es " + n);
//                   Estudiante n = EliminarInicio();

            NodoDoble aux = inicio;
                while(aux != null){
                    System.out.println("Postulante " + aux.getDato());  
                    aux = aux.getSigue();
                   
               }
                   
           }
       }
       
        public ListaDoble ListaPuntajeAscendente() {

            ListaDoble copia = new ListaDoble();
            
            if (ListaVacia()) {
                System.out.println("Lista vacía");
                
            }else{
                
                NodoDoble aux = inicio;

                while (aux != null) {
                    copia.InsertFinal(aux.getDato());  
                    aux = aux.getSigue();
                }


                NodoDoble nodoComparacion1 = copia.inicio;

                while (nodoComparacion1 != null) {
                    NodoDoble nodoComparacion2 = nodoComparacion1.getSigue();

                    while (nodoComparacion2 != null) {
                        if (nodoComparacion2.getDato().getPuntaje() > nodoComparacion1.getDato().getPuntaje()) {
                            Estudiante temp = nodoComparacion1.getDato();
                            nodoComparacion1.setDato(nodoComparacion2.getDato());
                            nodoComparacion2.setDato(temp);
                        }
                        nodoComparacion2 = nodoComparacion2.getSigue();
                    }

                    nodoComparacion1 = nodoComparacion1.getSigue();
                }
            }
            return copia;
        }

        public void SelecTop50MejAlumnosEnCalif(){
            
            if (ListaVacia()) {
                System.out.println("Lista vacía");
                
            }else{
                ListaDoble seleccionados = new ListaDoble(); 
                ListaDoble ordenada = ListaPuntajeAscendente();
                NodoDoble aux = ordenada.inicio;
                
                int cupos = 50, cuposActuales=0;
               
                
                
                for (int i = 1; i <= cupos; i++) {
                    if (aux.getDato().getPuntaje()>=75) {
                        
                        seleccionados.InsertFinal(aux.getDato()); 
                        cuposActuales = cupos-1 ;
                        System.out.println(i+"~ Estudiante "+ aux.getDato());

                    } else if (aux.getDato().getPuntaje()<75) {
                        seleccionados.InsertFinal(aux.getDato()); 
                        cuposActuales = cupos-1 ;
                        System.out.println(i+"~ Estudiante "+ aux.getDato());
                       
                    } else{
                        System.out.println("sobraron"+ cuposActuales + "  cupos");
                    }
                    aux = aux.getSigue();

                }

            }

            
        }
    
}
