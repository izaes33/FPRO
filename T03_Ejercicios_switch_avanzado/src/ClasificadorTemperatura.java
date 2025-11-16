public class ClasificadorTemperatura {

/* **Objetivo:** Crear un programa que clasifique la temperatura en categorías usando rangos.

**Requisitos:**

1. Declara una variable `int temperatura` en grados Celsius.
2. Usa `switch(true)` para clasificar la temperatura en: Helado (<0),
Frío (0-15), Templado (16-25), Calor (26-35), Muy Caliente (>35).
3. Muestra un mensaje descriptivo y una recomendación de vestimenta. */

    public void clasifica (double gradosCelsius) {

        switch (gradosCelsius) {
            case double n when (n < 0) -> {
                System.out.printf("La temperatura es inferior a %.2f%n, te recomiendo que te abrigues considerablemente, valora incluir guantes, bufanda y gorro a tu vestimenta", gradosCelsius);
            }
            case double n when (n >= 0 && n <16) -> {
                System.out.printf("La temperatura es de %.1fºC, te recominendo usar ropa de abrigo que cubra bastante.%n", gradosCelsius);
            }
            case double n when (n >= 16 && n <26) -> {
                System.out.printf("La temperatura es de %.1fºC, te recomiendo usar ropa de abrigo ligera.%n", gradosCelsius);
            }
            case double n when (n >= 26 && n <35) -> {
                System.out.printf("La temperatura es de %.1fºC, te recomiendo vestir ropa ligera, mantenerte hidratado y no exponerte demasido al sol.%n", gradosCelsius);
            }
            case double n when (n >= 35) -> {
                System.out.printf("La temperatura es de %.1fºC, evita exponerte al sol y los lugares donde se acumule calor, bebe mucha agua, y a ser posible no salgas de casa.%n", gradosCelsius);
            }
            default -> throw new IllegalStateException("Unexpected value: " + gradosCelsius);
        }
    }
}
