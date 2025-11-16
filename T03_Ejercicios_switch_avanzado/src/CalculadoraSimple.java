/***Objetivo:** Crear una calculadora simple que realice operaciones según un operador.
 **Requisitos:**
 1. Declara dos variables `double num1` y `double num2`.
 2. Declara una variable `char operador` con valores posibles: '+', '-', '*', '/'.
 3. Usa un `switch` para realizar la operación correspondiente.
 4. Maneja el caso especial de división por cero. */

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraSimple {

    // Lista de operadores válidos para validar la entrada
    private static final String OPERADORES_VALIDOS = "+-*/";

    public void ejecutar() {

        Scanner scanner = new Scanner(System.in);

        double num1 = 0.0;
        double num2 = 0.0;
        char operador = ' ';
        double resultado = 0.0;
        boolean operacionValida = true;

        System.out.println("=========================================");
        System.out.println("           CALCULADORA SIMPLE       ");
        System.out.println("=========================================");

        // --- 1. VALIDAR num1 (Bucle While para forzar entrada numérica) ---
        while (true) {
            System.out.print("Ingrese el primer número (num1): ");
            try {
                num1 = scanner.nextDouble();
                break; // Salimos del bucle si la lectura fue exitosa (es un número)
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Entrada no válida. Debe ingresar un valor numérico (ej: 10 o 5.5).");
                scanner.next(); // Limpiamos la entrada no válida
            }
        }

        // --- 2. VALIDAR operador (Bucle While para forzar un operador válido) ---
        while (true) {
            System.out.print("Ingrese el operador (+, -, *, /): ");
            String operadorStr = scanner.next();

            if (operadorStr.length() == 1 && OPERADORES_VALIDOS.contains(operadorStr)) {
                operador = operadorStr.charAt(0);
                break; // Salimos del bucle si el operador es válido
            } else {
                System.out.println("❌ Error: Operador no reconocido. Por favor, ingrese un solo carácter (+, -, *, /).");
            }
        }

        // --- 3. VALIDAR num2 (Bucle While para forzar entrada numérica) ---
        while (true) {
            System.out.print("Ingrese el segundo número (num2): ");
            try {
                num2 = scanner.nextDouble();
                break; // Salimos del bucle si la lectura fue exitosa (es un número)
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Entrada no válida. Debe ingresar un valor numérico.");
                scanner.next(); // Limpiamos la entrada no válida
            }
        }

        scanner.close();

        // --- 4. Realizar Operación con SWITCH ---

        System.out.printf("\nOperación a realizar: %.2f %c %.2f\n", num1, operador, num2);
        System.out.println("-----------------------------------------");

        switch (operador) {
            case '+':
            case '-':
            case '*':
                // Las operaciones básicas se realizan directamente
                resultado = (operador == '+') ? num1 + num2 :
                        (operador == '-') ? num1 - num2 : num1 * num2;
                break;

            case '/':
                // Manejar la división por cero
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("❌ Error: División por cero no permitida. El resultado es indefinido.");
                    operacionValida = false;
                }
                break;

            default:
                // Este caso 'default' nunca debería alcanzarse gracias al while de validación
                operacionValida = false;
                break;
        }

        // --- 5. Mostrar Resultado ---
        if (operacionValida) {
            System.out.printf("✅ Resultado: %.2f\n", resultado);
        }
        System.out.println("=========================================");
    }
}
