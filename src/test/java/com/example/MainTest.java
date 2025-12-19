package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class MainTest {
    
    private Main main;
    private Cliente cliente;

    @Before
    public void setUp() {
        main = new Main();
        cliente = new Cliente(17, 5, false, false, 20000, "Economica", "Nacional", false);
    }

    /*
    * A continuación se realizarán pruebas unitarias para el método determinarTarifa
    * de la clase Main, con casos definidos para realizar cobertura MCDC.
    */

    // TESTS PARA LA CONDICIÓN DE "PAJARILLO"
    // test case 1: Menor de edad con 7 vuelos al año
    @Test
    public void testCase1_MenorDeEdadCon7Vuelos() {
        cliente.edad = 17;
        cliente.frecuenciaViajes = 7;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertEquals("Pajarillo", tarifa.nombre);
        assertEquals(0.10, tarifa.descuento, 0.001);
    }

    // test case 2: Menor de edad con 5 vuelos al año
    @Test
    public void testCase2_MenorDeEdadCon5Vuelos() {
        cliente.edad = 17;
        cliente.frecuenciaViajes = 5;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 3: Menor de edad estudiante
    @Test
    public void testCase3_MenorDeEdadEstudiante() {
        cliente.edad = 17;
        cliente.esEstudiante = true;
        cliente.frecuenciaViajes = 10;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertNotEquals("Gorrión", tarifa.nombre);
    }

    // test case 4: Edad 26, estudiante, turista, 13 vuelos
    @Test
    public void testCase4_Edad26EstudianteTurista13Vuelos() {
        cliente.edad = 26;
        cliente.esEstudiante = true;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 13;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // TESTS PARA LA CONDICIÓN DE "GORRIÓN"
    // test case 5: Edad 20, no estudiante, turista, 13 vuelos no es gorrión
    @Test
    public void testCase5_Edad20NoEstudianteTurista13Vuelos() {
        cliente.edad = 20;
        cliente.esEstudiante = false;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 13;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertNotEquals("Gorrión", tarifa.nombre);
    }

    // test case 6: Edad 20, estudiante, bussiness, 13 vuelos no es gorrión
    @Test
    public void testCase6_Edad20EstudianteBusiness13Vuelos() {
        cliente.edad = 20;
        cliente.esEstudiante = true;
        cliente.clasePreferida = "bussiness";
        cliente.frecuenciaViajes = 13;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 7: Edad 20, estudiante, turista, 11 vuelos no es gorrión
    @Test
    public void testCase7_Edad20EstudianteTurista11Vuelos() {
        cliente.edad = 20;
        cliente.esEstudiante = true;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 11;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 8: Edad 20, estudiante, turista, 13 vuelos es gorrión
    @Test
    public void testCase8_Edad20EstudianteTurista13VuelosGorrion() {
        cliente.edad = 20;
        cliente.esEstudiante = true;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 13;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertEquals("Gorrión", tarifa.nombre);
    }

    // TESTS PARA LA CONDICIÓN DE "VIAJA AHORA QUE PUEDES"
    // test case 9: Edad 17, estudiante, turista, 4 vuelos, vive con padres no es viaja ahora que puedes
    @Test
    public void testCase9_Edad17EstudianteTurista4VuelosConPadres() {
        cliente.edad = 17;
        cliente.esEstudiante = true;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 4;
        cliente.viveConPadres = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 10: Edad 26, no estudiante, turista, 4 vuelos, vive con padres no es viaja ahora que puedes
    @Test
    public void testCase10_Edad26NoEstudianteTurista4VuelosConPadres() {
        cliente.edad = 26;
        cliente.esEstudiante = false;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 4;
        cliente.viveConPadres = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 11: Edad 20, estudiante, turista, 4 vuelos, vive con padres no es viaja ahora que puedes
    @Test
    public void testCase11_Edad20EstudianteTurista4VuelosConPadres() {
        cliente.edad = 20;
        cliente.esEstudiante = true;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 4;
        cliente.viveConPadres = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }   

    // test case 12: Edad 20, no estudiante, turista, 2 vuelos, no vive con padres no es viaja ahora que puedes
    @Test
    public void testCase12_Edad20NoEstudianteTurista2VuelosNoConPadres() {
        cliente.edad = 20;
        cliente.esEstudiante = false;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 2;
        cliente.viveConPadres = false;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 13: Edad 20, no estudiante, bussiness, 4 vuelos, vive con padres no es viaja ahora que puedes
    @Test
    public void testCase13_Edad20NoEstudianteBusiness4VuelosConPadres() {
        cliente.edad = 20;
        cliente.esEstudiante = false;
        cliente.clasePreferida = "bussiness";
        cliente.frecuenciaViajes = 4;
        cliente.viveConPadres = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 14: Edad 20, no estudiante, turista, 4 vuelos, no vive con padres no es viaja ahora que puedes
    @Test
    public void testCase14_Edad20NoEstudianteTurista4VuelosNoConPadres() {
        cliente.edad = 20;
        cliente.esEstudiante = false;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 4;
        cliente.viveConPadres = false;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertNotEquals("Viaje ahora que puedes", tarifa.nombre);
    }

    // test case 15: Edad 20, no estudiante, turista, 4 vuelos, vive con padres es viaja ahora que puedes
    @Test
    public void testCase15_Edad20NoEstudianteTurista4VuelosConPadresGorrion(){
        cliente.edad = 20;
        cliente.esEstudiante = false;
        cliente.clasePreferida = "turista";
        cliente.frecuenciaViajes = 4;
        cliente.viveConPadres = true;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertEquals("Viaja ahora que puedes", tarifa.nombre);
    }

    // TESTS PARA LA CONDICIÓN DE "CONOCE EUROPA CON TUS PEQUES"
    // test case 16: Edad 24, ingresos 24000, frecuencia 7, turista, destino Europa con niños no es conoce Europa con tus peques
    @Test
    public void testCase16_Edad24Ingresos24000Frecuencia7TuristaDestinoEuropaConNinos() {
        cliente.edad = 24;
        cliente.ingresos = 24000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = true;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertNotEquals("Conoce Europa con tus peques", tarifa.nombre);
    }

    // test case 17: Edad 26, ingresos 19000, frecuencia 7, turista, destino Europa con niños no es conoce Europa con tus peques
    @Test
    public void testCase17_Edad26Ingresos19000Frecuencia7TuristaDestinoEuropaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 19000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 18: Edad 26, ingresos 36000, frecuencia 7, turista, destino Europa con niños no es conoce Europa con tus peques
    @Test
    public void testCase18_Edad26Ingresos36000Frecuencia7TuristaDestinoEuropaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 36000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 19: Edad 26, ingresos 24000, frecuencia 5, turista, destino Europa con niños no es conoce Europa con tus peques
    @Test
    public void testCase19_Edad26Ingresos24000Frecuencia5TuristaDestinoEuropaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 24000;
        cliente.frecuenciaViajes = 5;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 20: Edad 26, ingresos 24000, frecuencia 7, business, destino Europa con niños no es conoce Europa con tus peques
    @Test
    public void testCase20_Edad26Ingresos24000Frecuencia7BusinessDestinoEuropaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 24000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "business";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 21: Edad 26, ingresos 24000, frecuencia 7, turista, destino Asia con niños no es conoce Europa con tus peques
    @Test
    public void testCase21_Edad26Ingresos24000Frecuencia7TuristaDestinoAsiaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 24000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "asia";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 22: Edad 26, ingresos 24000, frecuencia 7, turista, destino Europa sin niños no es conoce Europa con tus peques
    @Test
    public void testCase22_Edad26Ingresos24000Frecuencia7TuristaDestinoEuropaSinNinos() {
        cliente.edad = 26;
        cliente.ingresos = 24000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = false;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertNotEquals("Conoce Europa con tus peques", tarifa.nombre);
    }

    // test case 23: Edad 26, ingresos 24000, frecuencia 7, turista, destino Europa con niños es conoce Europa con tus peques
    @Test
    public void testCase23_Edad26Ingresos24000Frecuencia7TuristaDestinoEuropaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 24000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = true;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertEquals("Conoce Europa con tus peques", tarifa.nombre);
    }

    // TESTS PARA LA CONDICIÓN DE "CONOCE EL MUNDO CON TUS PEQUES"
    // test case 24: Edad 20, ingresos 36000, frecuencia 7, business, destino Asia con niños no es conoce el mundo con tus peques
    @Test
    public void testCase24_Edad20Ingresos36000Frecuencia7BusinessDestinoAsiaConNinos() {
        cliente.edad = 20;
        cliente.ingresos = 36000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "business";
        cliente.destinoPreferido = "asia";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 25: Edad 26, ingresos 24000, frecuencia 7, business, destino Asia con niños no es conoce el mundo con tus peques
    @Test
    public void testCase25_Edad26Ingresos24000Frecuencia7BusinessDestinoAsiaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 24000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "business";
        cliente.destinoPreferido = "asia";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 26: Edad 26, ingresos 36000, frecuencia 5, business, destino Asia con niños no es conoce el mundo con tus peques
    @Test
    public void testCase26_Edad26Ingresos36000Frecuencia5BusinessDestinoAsiaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 36000;
        cliente.frecuenciaViajes = 5;
        cliente.clasePreferida = "business";
        cliente.destinoPreferido = "asia";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 27: Edad 26, ingresos 36000, frecuencia 7, turista, destino Asia con niños no es conoce el mundo con tus peques
    @Test
    public void testCase27_Edad26Ingresos36000Frecuencia7TuristaDestinoAsiaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 36000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "turista";
        cliente.destinoPreferido = "asia";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 28: Edad 26, ingresos 36000, frecuencia 7, business, destino Europa con niños no es conoce el mundo con tus peques
    @Test
    public void testCase28_Edad26Ingresos36000Frecuencia7BusinessDestinoEuropaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 36000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "business";
        cliente.destinoPreferido = "europa";
        cliente.viajaConNinos = true;
        assertThrows(IllegalArgumentException.class, () -> {
            main.determinarTarifa(cliente);
        });
    }

    // test case 29: Edad 26, ingresos 36000, frecuencia 7, business, destino Asia sin niños no es conoce el mundo con tus peques
    @Test
    public void testCase29_Edad26Ingresos36000Frecuencia7BusinessDestinoAsiaSinNinos() {
        cliente.edad = 26;
        cliente.ingresos = 36000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "business";
        cliente.destinoPreferido = "asia";
        cliente.viajaConNinos = false;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertNotEquals("Conoce el Mundo con tus peques", tarifa.nombre);
    }

    // test case 30: Edad 26, ingresos 36000, frecuencia 7, business, destino Asia con niños es conoce el mundo con tus peques
    @Test
    public void testCase30_Edad26Ingresos36000Frecuencia7BusinessDestinoAsiaConNinos() {
        cliente.edad = 26;
        cliente.ingresos = 36000;
        cliente.frecuenciaViajes = 7;
        cliente.clasePreferida = "business";
        cliente.destinoPreferido = "asia";
        cliente.viajaConNinos = true;
        Tarifa tarifa = main.determinarTarifa(cliente);
        assertEquals("Conoce el Mundo con tus peques", tarifa.nombre);
    }
}