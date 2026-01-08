/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

import java.time.LocalDateTime;

/**
 *
 * @author tyron
 */
public class Vehiculo {
    //Atributos
    private int id;
    private String placa;
    private String marca;
    private short anioDeFabricación; 
    private String color;
    private LocalDateTime horaEntrada;

    //Constructores
    public Vehiculo() {
    }
    
    public Vehiculo(int id, String placa, String marca, short anioDeFabricación, String color) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.anioDeFabricación = anioDeFabricación;
        this.color = color;
        this.horaEntrada = LocalDateTime.now();
    }
    
    //Metodos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnioDeFabricación() {
        return anioDeFabricación;
    }

    public void setAnioDeFabricación(short anioDeFabricación) {
        this.anioDeFabricación = anioDeFabricación;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Override
    public String toString() {
        return "Vehiculo: " + "\nId= " + id + "\nPlaca= " + placa + "\nMarca= " + marca + "\nAño De Fabricacion= " + anioDeFabricación + "\nColor= " + color + "\nHora De Entrada= " + horaEntrada ;
    }
    
    
}
