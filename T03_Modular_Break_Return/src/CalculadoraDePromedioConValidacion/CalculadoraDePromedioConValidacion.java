/***Objetivo:** Crear un método que calcule el promedio de notas, saltando notas inválidas con `continue`.

 **Requisitos:**

 1. Crea un método `double calcularPromedio(double[] notas)`.
 2. Recorre el array de notas.
 3. Si una nota es menor que 0 o mayor que 10, usa `continue` para ignorarla.
 4. Suma las notas válidas y cuenta cuántas hay.
 5. Devuelve el promedio de las notas válidas. */

package CalculadoraDePromedioConValidacion;
import java.util.Random;


public class CalculadoraDePromedioConValidacion {

    public static void main(String[] args) {

        Random random = new Random();

        int[] notas = new int[20];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = random.nextInt(13) + 1;
        }

        CalculaPromedio calculadora = new CalculaPromedio();

        double promedio = calculadora.iniciarCalculo(notas);
        System.out.println("El promedio válido es: " + promedio);
    }
}

