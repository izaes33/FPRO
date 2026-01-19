/* Crea un método que genere la secuencia de Fibonacci hasta un límite usando `break`.

**Requisitos:**
1. Crea un método `void generarFibonacci(int limite)`.
2. Genera la secuencia de Fibonacci (0, 1, 1, 2, 3, 5, 8, 13...).
3. Usa un bucle `while(true)` infinito.
4. Cuando el siguiente número supere el límite, usa `break` para salir.
5. Muestra todos los números generados.
6. En el `main`, prueba con diferentes límites como 100, 1000, 10000. */

package Ej07;

public class MainEj07 {
    public static void main(String[] args) {
        Fibonacci fibonacci= new Fibonacci();
        fibonacci.generarFibonacci(100);
        fibonacci.generarFibonacci(1000);
        fibonacci.generarFibonacci(10000);
    }
}
