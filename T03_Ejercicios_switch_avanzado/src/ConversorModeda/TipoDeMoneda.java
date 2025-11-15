package ConversorModeda;

public enum TipoDeMoneda {
    // Definimos las constantes y asignamos la tasa de conversión Euro a Moneda
    // (Tasas ficticias para el ejemplo)
    DOLAR(1.08),
    LIBRA(0.85),
    YEN(165.0),
    PESO(18.0); // Asumiendo Peso Mexicano o similar

    /* Constructor del enum:
    El enum en Java es una CLASE ESPECIAL con INSTANCIAS LIMITADAS (constantes).
    predefinidas (como DOLAR, LIBRA, YEN). Para asignar un valor específico (como la tasa de cambio)
    a cada una de estas instancias, necesitamos un CONSTRUCTOR. */

    // Variable para almacenar la tasa
    private final double tasaConversion;
    /* Al ser un campo declarado como final, esta línea solo puede ejecutarse una vez por cada constante
    del enum (una vez para DOLAR, una vez para LIBRA, etc.). */

    TipoDeMoneda(double tasaConversion) {
    /*TipoDeMoneda(double tasaConversion): SE LLAMA IMPLÍCITAMETNE CUANDO SE DEFINEN LAS CONSTANTES DEL ENUM,
    como se ha hecho en DOLAR(1.08). PASANDO EL VALOR COMO ARGUMENTO tasaConversion al constructor. */
        this.tasaConversion = tasaConversion;
        /*Instrucción de asignación:
        Toma el argumento tasaConversion que proviene de la declaración de la constante
        (ej. el 1.08 en DOLAR(1.08)). Y asigna este valor al campo de
        instancia this.tasaConversion (que referencia a la variable para almacenar la tasa). */
    }

    // Método para obtener la tasa de conversión (Método Getter)
    /*Esta es una práctica estándar en Java conocida como Getter o método de acceso.
    Su propósito es proporcionar acceso seguro y controlado a la variable privada
    tasaConversion.
    ENCAPSULACIÓN: Dado que la variable tasaConversion es privada, no se puede acceder
    directamente desde otras clases (como ConversorMoneda o Main). Este método es la única
    forma de obtener el valor de la tasa de cambio. Esto es una buena práctica en POO. */
    public double getTasaConversion() {
        return tasaConversion;
    }
}

/* En resumen, el código permite que cada constante del enum (DOLAR, LIBRA, etc.) se comporte
como un objeto que no solo tiene un nombre, sino también un valor de dato asociado (la tasa)
que puede ser recuperado cuando sea necesario. */