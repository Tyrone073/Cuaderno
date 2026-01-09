/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tyrone.tarea9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tyron
 */
public class Vehiculo {
    //Atributos
    private static int contadorId = 0;
    private int id;
    private String placa;
    private String marca;
    private short anioDeFabricación; 
    private String color;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaRetirado;

    //Constructores
    public Vehiculo() {
    }
    
    public Vehiculo(String placa, String marca, short anioDeFabricación, String color) {
        this.id = ++contadorId; //pre-incremento con el valor statico contadorId
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

    public LocalDateTime getHoraRetirado() {
        return horaRetirado;
    }

    public void setHoraRetirado(LocalDateTime horaRetirado) {
        this.horaRetirado = horaRetirado;
    }    

    @Override
    public String toString() {
        return "\nVehiculo: " + 
                "\n Id = " + id + 
                "\n Placa = " + placa + 
                "\n Marca = " + marca + 
                "\n Año De Fabricacion = " + anioDeFabricación + 
                "\n Color = " + color + 
                "\n Hora De Entrada = " + horaEntrada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + 
                "\n Hora de Salida = " + (horaRetirado == null ?"Vehículo sin retirarse" :horaRetirado.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
        
}
