package Ej08;

public class ValidadorEdades {
    public static int contarEdadesValidas(int[] edades) {
        int contador = 0;

        for (int edad : edades) {
            if (edad < 0 || edad > 120) {
                continue; // se ignora la edad inválida
            }
            contador++;
        }

        return contador;
    }

    public static void mostrarEdadesValidas(int[] edades) {
        System.out.print("Edades válidas: ");

        for (int edad : edades) {
            if (edad < 0 || edad > 120) {
                continue; // salto de valores inválidos
            }
            System.out.print(edad + " ");
        }

        System.out.println();
    }
}
