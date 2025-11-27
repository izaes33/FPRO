package CalculadoraDePromedioConValidacion;

public class CalculaPromedio {

    public double iniciarCalculo(int[] notas) {
        double[] notasConvertidas = convertirANumerosReales(notas);
        return calcularPromedio(notasConvertidas);
    }

    private double[] convertirANumerosReales(int[] notas) {
        double[] resultado = new double[notas.length];

        for (int i = 0; i < notas.length; i++) {
            resultado[i] = notas[i]; // conversión automática int → double
        }

        return resultado;
    }

    private double calcularPromedio(double[] notas) {
        double suma = 0;
        int contadorValidas = 0;

        for (double nota : notas) {

            if (!esNotaValida(nota)) {
                continue; // saltar notas inválidas
            }

            suma += nota;
            contadorValidas++;
        }

        return contadorValidas > 0 ? suma / contadorValidas : 0;
    }

    private boolean esNotaValida(double nota) {
        return nota >= 0 && nota <= 10;
    }
}

/*Flujo global del programa
-El main genera un array de enteros con notas aleatorias.
-El main llama a iniciarCalculo en CalculaPromedio.
-iniciarCalculo convierte el array de int a double usando convertirANumerosReales.
-Luego llama a calcularPromedio que:
-Recorre todas las notas.
-Descarta las inválidas.
-Suma y cuenta las válidas.
-Calcula el promedio.
-El promedio calculado se devuelve al main.
-El main imprime el resultado en consola. */
