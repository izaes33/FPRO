/***Objetivo:** Crear un método que busque un número en un array y use `break` para salir del bucle cuando lo encuentre.

 **Requisitos:**

 1. Crea un método `int buscarNumero(int[] numeros, int objetivo)`.
 2. El método debe recorrer el array con un `for`.
 3. Cuando encuentre el número objetivo, usa `break` para salir del bucle.
 4. Devuelve el índice donde se encontró el número, o -1 si no se encontró.
 5. En el `main`, crea un array de enteros y prueba el método. */

package BuscaNumeroEnArray;
import java.util.Scanner;
import java.util.Random;


public class BuscaNumeroEnArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Array de 20 números aleatorios entre 1 y 20
        int[] numeros = new int[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = random.nextInt(20) + 1;
        }

        System.out.print("Introduce el número a buscar: ");
        int objetivo = sc.nextInt();

        IniciaBusqueda buscador = new IniciaBusqueda();
        int resultado = buscador.iniciarBusqueda(numeros, objetivo);

        if (resultado != -1) {
            System.out.println("Número encontrado en el índice: " + resultado);
        } else {
            System.out.println("Número no encontrado en el array.");
        }
    }
}
