/*## Ejercicio 7: Sistema de Niveles de Juego
**Objetivo:** Crear un sistema que determine el nivel del jugador según su puntuación.
**Requisitos:**
1. Declara una variable `int puntuacion`.
2. Usa `switch(true)` para clasificar en niveles: Principiante (0-100), Intermedio (101-500), Avanzado (501-1000), Experto (1001-5000), Maestro (>5000).
3. Muestra el nivel alcanzado y un mensaje motivacional.
4. Otorga una recompensa virtual diferente para cada nivel. */

public class NivelesDeJuego {

    public void lanzaMensaje(int puntuacion){

        String nivel = niveles(puntuacion);
        /* String nivel = niveles(puntuacion);
        Llama al método niveles(puntuacion)
        Ese método analiza la puntuación que le pasas.
        Devuelve una cadena de texto como "principiante", "intermedio", "avanzado", etc.
        Esa cadena se guarda en la variable nivel. */
        /* Ejemplo real
Si puntuacion = 320:
Llamas a:
String nivel = niveles(320);
Dentro del método se cumple:
if (puntuacion >= 101 && puntuacion <= 500)
    return "intermedio";
Por tanto:
nivel == "intermedio" */
        String mensaje;
        String recompensa;

        switch (nivel) {

            case "principiante" -> {
                mensaje = "¡Buen inicio! Cada paso cuenta.";
                recompensa = "⭐ 10 monedas virtuales";
                System.out.println("Nivel: Principiante");
                System.out.println("Mensaje: " + mensaje);
                System.out.println("Recompensa: " + recompensa);
            }

            case "intermedio" -> {
                mensaje = "¡Muy bien! Estás progresando rápido.";
                recompensa = "🎁 50 monedas virtuales";
                System.out.println("Nivel: Intermedio");
                System.out.println("Mensaje: " + mensaje);
                System.out.println("Recompensa: " + recompensa);
            }

            case "avanzado" -> {
                mensaje = "¡Impresionante desempeño!";
                recompensa = "💎 200 monedas virtuales";
                System.out.println("Nivel: Avanzado");
                System.out.println("Mensaje: " + mensaje);
                System.out.println("Recompensa: " + recompensa);
            }

            case "experto" -> {
                mensaje = "¡Eres una bestia del juego!";
                recompensa = "🏆 500 monedas virtuales";
                System.out.println("Nivel: Experto");
                System.out.println("Mensaje: " + mensaje);
                System.out.println("Recompensa: " + recompensa);
            }

            case "maestro" -> {
                mensaje = "¡Leyenda absoluta!";
                recompensa = "👑 2000 monedas virtuales";
                System.out.println("Nivel: Maestro");
                System.out.println("Mensaje: " + mensaje);
                System.out.println("Recompensa: " + recompensa);
            }

            default -> {
                System.out.println("Puntuación fuera de rango.");
            }
        }
    }

    public String niveles(int puntuacion){

        if (puntuacion >= 0 && puntuacion <= 100)
            return "principiante";

        if (puntuacion >= 101 && puntuacion <= 500)
            return "intermedio";

        if (puntuacion >= 501 && puntuacion <= 1000)
            return "avanzado";

        if (puntuacion >= 1001 && puntuacion <= 5000)
            return "experto";

        if (puntuacion > 5000)
            return "maestro";

        return "desconocido";
    }
}