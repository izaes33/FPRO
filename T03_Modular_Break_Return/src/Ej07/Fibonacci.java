package Ej07;

public class Fibonacci {

    public static void generarFibonacci(int limite) {
        int a = 0;
        int b = 1;

        System.out.print("Fibonacci hasta " + limite + ": ");

        while (true) {
            if (a > limite) {
                break; // salida cuando se supera el límite
            }

            System.out.print(a + " ");

            int siguiente = a + b;
            a = b;
            b = siguiente;
        }

        System.out.println();
    }
}
