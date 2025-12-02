package com.example;

public class Cliente {
    public int edad;
    public int frecuenciaViajes;
    public boolean esEstudiante;
    public boolean viveConPadres;
    public double ingresos;
    public String clasePreferida;
    public String destinoPreferido;
    public boolean viajaConNinos;

    public Cliente(int edad, int frecuenciaViajes, boolean esEstudiante, boolean viveConPadres,
                   double ingresos, String clasePreferida, String destinoPreferido, boolean viajaConNinos) {
        this.edad = edad;
        this.frecuenciaViajes = frecuenciaViajes;
        this.esEstudiante = esEstudiante;
        this.viveConPadres = viveConPadres;
        this.ingresos = ingresos;
        this.clasePreferida = clasePreferida;
        this.destinoPreferido = destinoPreferido;
        this.viajaConNinos = viajaConNinos;
    }
}
