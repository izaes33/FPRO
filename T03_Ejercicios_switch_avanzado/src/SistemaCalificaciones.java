public class SistemaCalificaciones {

    /*Objetivo:** Crear un programa que convierta una calificación
      numérica (0-10) en su equivalente alfabético usando un switch.

 **Requisitos:**
 1. Declara una variable `double calificacion` con un valor entre 0 y 10.
 2. Usa un `switch` para convertir la calificación a una letra (A, B, C, D, F).
 3. Considera: 9-10 = A, 7-8.9 = B, 5-6.9 = C, 4-4.9 = D, 0-3.9 = F
 4. Muestra un mensaje apropiado para cada calificación. */

    public void convertirEnLetra(double nota) {

        switch (nota) {
            case double n when (n >= 0 && n <= 3.9) -> {
                System.out.printf("Tu nota es de %.2f = F%n", nota);
            }
            case double n when (n >= 4 && n <= 4.9) -> {
                System.out.printf("Tu nota es de %.2f = D%n", nota);
            }
            case double n when (n >= 5 && n <= 6.9) -> {
                System.out.printf("Tu nota es de %.2f = C%n", nota);
            }
            case double n when (n >= 7 && n <= 8.9) -> {
                System.out.printf("Tu nota es de %.2f = B%n", nota);
            }
            case double n when (n >= 9 && n <= 10) -> {
                System.out.printf("Tu nota es de %.2f = A%n", nota);
            }
            default -> System.out.print("El valor introducido debe estar entre 0 y 10");
        }
    }
}