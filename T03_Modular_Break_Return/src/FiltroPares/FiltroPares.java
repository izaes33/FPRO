/***Objetivo:** Crear un método que muestre solo números pares de un array usando `continue`.

 **Requisitos:**

 1. Crea un método `void mostrarPares(int[] numeros)`.
 2. Recorre el array con un bucle `for`.
 3. Si el número es impar, usa `continue` para saltar a la siguiente iteración.
 4. Si el número es par, muéstralo en pantalla.
 5. En el `main`, crea un array con números del 1 al 20 y llama al método. */
package FiltroPares;

public class FiltroPares {
    public static void main(String[] args) {

        // Array del 1 al 20
        int[] numeros = new int[20];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }

        // Crear objeto de controladora
        Mostrar mostrar = new Mostrar();

        System.out.println("Números pares del array:");
        mostrar.imprimirPares(numeros);
    }
}