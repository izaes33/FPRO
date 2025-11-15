package ConversorModeda;

public class ConversorMoneda {

    /*Objetivo:** Crear un programa que convierta una cantidad en euros
    a otras monedas según la opción seleccionada.

     **Requisitos:**
     1. Crea un enum `Moneda` con: `DOLAR`, `LIBRA`, `YEN`, `PESO`.
     2. Declara una variable `double euros` con una cantidad.
     3. Usa un `switch` con el enum para aplicar la tasa de conversión correspondiente.
     4. Muestra el resultado de la conversión. */

    public void convertirA(String tipo, double cantidad) {

        // Convertimos el String 'tipo' a mayúsculas para que coincida con el enum
        String tipoUpper = tipo.toUpperCase();

        System.out.println("Intentando convertir " + cantidad + " EUR a " + tipo);
        System.out.println("---------------------------------");

        // Usaremos el enum para manejar la lógica de conversión
        TipoDeMoneda monedaObjetivo;
        // Se declara una variable llamada monedaObjetivo de tipo TipoDeMoneda (el enum)

        // 1. Usamos el switch para asociar el String con el objeto Enum
        switch (tipoUpper) {
            case "DOLAR":
                monedaObjetivo = TipoDeMoneda.DOLAR; /* Si hay una coincidencia, esta es la
                línea clave: asigna a la variable monedaObjetivo el objeto enum real
                (TipoDeMoneda.DOLAR). */
                break;
            case "LIBRA":
                monedaObjetivo = TipoDeMoneda.LIBRA;
                break;
            case "YEN":
                monedaObjetivo = TipoDeMoneda.YEN;
                break;
            case "PESO":
                monedaObjetivo = TipoDeMoneda.PESO;
                break;
            default:
                System.out.println("❌ Error: Moneda '" + tipo + "' no reconocida. Opciones: DOLAR, LIBRA, YEN, PESO.");
                return; // Salimos del método si la moneda no es válida
        }

        // 2. Realizamos el cálculo usando la tasa del enum
        /* Este bloque utiliza la variable monedaObjetivo, que ya tiene asignado un objeto
        enum válido, para acceder a la tasa de conversión y realizar la operación matemática. */
        double tasa = monedaObjetivo.getTasaConversion();
        double resultado = cantidad * tasa;

        // 3. Mostramos el resultado
        System.out.printf("Conversión realizada: %.2f EUR es igual a %.2f %s%n",
                cantidad, resultado, monedaObjetivo.name());
        System.out.printf("Tasa aplicada (1 EUR = %.2f %s)%n", tasa, monedaObjetivo.name());
        System.out.println("---------------------------------");
    }
}
