package com.example;

public class Tarifa {

    public String nombre;
    public double descuento;

    public Tarifa(String nombre, double descuento) {
        this.nombre = nombre;
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return String.format("%s (con un descuento del %.0f%% sobre el precio del vuelo)",
                nombre, descuento * 100);
    }
}
