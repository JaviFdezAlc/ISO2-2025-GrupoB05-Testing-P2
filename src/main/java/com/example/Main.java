package com.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public Tarifa determinarTarifa(Cliente cliente) {

        // Edad < 18
        if (cliente.edad < 18) {
            // Regla 1: Menor de edad y al menos 6 vuelos al año.
            if (cliente.frecuenciaViajes >= 6) {
                return new Tarifa("Pajarillo", 0.10); // 10% descuento
            }
        } // Edad 18-25
        else if (cliente.edad >= 18 && cliente.edad <= 25) {
            // Regla 2: Estudiante, viaja en turista, al menos 12 vuelos (uno al mes)
            if (cliente.esEstudiante
                    && cliente.clasePreferida.equalsIgnoreCase("turista")
                    && cliente.frecuenciaViajes >= 12) {
                return new Tarifa("Gorrión", 0.15); // 15% descuento
            }

            // Regla 3 & 4: Recién incorporados al mundo laboral.
            if (!cliente.esEstudiante
                    && cliente.frecuenciaViajes >= 3
                    && cliente.clasePreferida.equalsIgnoreCase("turista")) {

                // Si vive con sus padres.
                if (cliente.viveConPadres) {
                    return new Tarifa("Viaja ahora que puedes", 0.05); // 5% descuento 
                } // Si ya no vive con sus padres.
                else {
                    return new Tarifa("Atreviéndose a saltar del Nido", 0.25); // 25% descuento 
                }
            }
        } // Edad > 25
        else if (cliente.edad > 25) {

            // 20.000€ < Ingresos <= 35.000€
            if (cliente.ingresos > 20000 && cliente.ingresos <= 35000) {

                // Regla 5: Conoce Europa (Clase Turista, 6+ viajes, destino Europa)
                if (cliente.frecuenciaViajes >= 6
                        && cliente.clasePreferida.equalsIgnoreCase("turista")
                        && cliente.destinoPreferido.equalsIgnoreCase("europa")) {

                    // Con niños: Conoce Europa con tus peques
                    if (cliente.viajaConNinos) {
                        return new Tarifa("Conoce Europa con tus peques", 0.10); // 10% 
                    } // Sin niños: Conoce Europa
                    else {
                        return new Tarifa("Conoce Europa", 0.15); // 15% 
                    }
                }
            } // Rango de ingresos alto (Ingresos > 35.000€)
            else if (cliente.ingresos > 35000) {

                // Regla 6: Conoce el Mundo (Clase Business, 6+ viajes, destino Asia/América)
                if (cliente.frecuenciaViajes >= 6
                        && cliente.clasePreferida.equalsIgnoreCase("business")
                        && (cliente.destinoPreferido.equalsIgnoreCase("asia")
                        || cliente.destinoPreferido.equalsIgnoreCase("america"))) {

                    // Con niños: Conoce el Mundo con tus peques
                    if (cliente.viajaConNinos) {
                        return new Tarifa("Conoce el Mundo con tus peques", 0.10); // 10% 
                    } // Sin niños: Conoce el Mundo
                    else {
                        return new Tarifa("Conoce el Mundo", 0.20); // 20% 
                    }
                }
            }
        }
        throw new IllegalArgumentException("No se encontró una tarifa adecuada para el cliente.");
    }
}
