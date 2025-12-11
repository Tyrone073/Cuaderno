/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea6;

/**
 *
 * @author tyron
 */
public class Estudiante {
    private int id;
    private String nombre;
    private float puntaje;


    public Estudiante() {
    }

    public Estudiante(int id, String nombre, float puntaje) {
//        this.id = id++;
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        String nombreLimpio = (nombre.charAt(0) == ' ') ? nombre.substring(1) : nombre;
        return "{" + "id= " + id + ", nombre= " + nombreLimpio + ", puntaje= " + puntaje + '}';
    }
    
    
}
