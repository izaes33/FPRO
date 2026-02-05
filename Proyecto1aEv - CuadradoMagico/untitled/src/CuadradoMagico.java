import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CuadradoMagico {
    private int[][] matriz;      // Matriz cuadrada que contendrá el cuadrado mágico
    private int n;               // Tamaño de la matriz (n x n)
    private int intentos = 0;    // Contador de intentos realizados
    Scanner sc = new Scanner(System.in);                             // Objeto para leer datos desde el teclado


    public void iniciar() {
        System.out.print("Introduce el tamaño de la matriz (n): ");      // Solicita al usuario el tamaño de la matriz
        n = sc.nextInt();     //Guarda el entero introducido por el usuario en una variable llamada n
        matriz = new int[n][n];          // Inicializa la matriz con el tamaño indicado
        boolean esMagico = false;        // Variable de control para saber cuándo se ha encontrado el cuadrado mágico
        while (!esMagico) {        // Bucle de intentos sucesivos (fuerza bruta)
            intentos++;            // Incrementa el número de intentos
            rellenarMatrizAleatoria();            // Rellena la matriz con números aleatorios sin repetir (versión optimizada)
            esMagico = comprobarCuadradoMagico();            // Comprueba si la matriz generada es un cuadrado mágico
        }
        mostrarMatriz();        // Muestra la matriz final encontrada
        System.out.println("Constante mágica: " + constanteMagica());        // Muestra la constante mágica
        System.out.println("Intentos realizados: " + intentos);        // Muestra el número de intentos realizados

    }


    private void rellenarMatrizAleatoria() {
        ArrayList<Integer> numeros = new ArrayList<>();        // Crea un Arraylist que contendrá los números del 1 al n*n
        for (int i = 1; i <= n * n; i++) {                     // Recorre desde i=1, hasta filas*columnas y suma 1
            numeros.add(i);                                    // Se añaden a la lista los números encontrados
        }
        Collections.shuffle(numeros);        // Desordena la lista numeros al azar.
        int indice = 0;                      /* Crea un contador para recorrer la lista desde el primer elemento.
        (indice apunta a la posición actual de la lista y empieza en el primer número). */
        for (int i = 0; i < n; i++) {        // Recorre las filas de la matriz
            for (int j = 0; j < n; j++) {            // Recorre las columnas de la matriz
                matriz[i][j] = numeros.get(indice);                /* Toma el número que está en la posición indice de la lista
                (indice es un número entero que empieza en 0 y va aumentando en cada iteración) y lo coloca en la posición
                [i][j] de la matriz */
                indice++;                // Avanza al siguiente número de la lista

            }
        }
    }


    private boolean comprobarCuadradoMagico() {
        int sumaObjetivo = constanteMagica();        // Calcula la suma objetivo (constante mágica) sumando los elementos de la primera fila
        for (int i = 0; i < n; i++) {        // Bucle que recorre todas las filas de la matriz
            int sumaFila = 0;            // Variable acumuladora para guardar la suma de la fila actual
            for (int j = 0; j < n; j++) {            // Bucle que recorre todas las columnas de la fila i
                sumaFila += matriz[i][j];                // Se suma el valor de cada elemento de la fila i
            }
            if (sumaFila != sumaObjetivo) {            /* Se compara la suma de la fila actual con la suma objetivo
Si alguna fila no suma lo mismo, no es un cuadrado mágico y se sale del método inmediatamente devolviendo false */
                return false;
            }
        }
        // Si todas las filas han pasado la comprobación, el método continúa con las siguientes validaciones

        for (int j = 0; j < n; j++) {// Bucle que recorre todas las columnas de la matriz
            int sumaColumna = 0;            // Variable acumuladora para guardar la suma de la columna actual
            for (int i = 0; i < n; i++) {            // Bucle que recorre todas las filas de la columna j
                sumaColumna += matriz[i][j];                // Se suma el valor del elemento situado en la fila i y columna j
            }
            if (sumaColumna != sumaObjetivo) {            /* Se compara la suma de la columna actual con la suma objetivo.
Si alguna columna no suma lo mismo, no es un cuadrado mágico, se sale del método inmediatamente devolviendo false */
                return false;
            }
        }

        /**
         * Comprobación de la diagonal principal:
         * La diagonal principal está formada por los elementos cuya fila y columna
         * tienen el mismo índice: [0][0], [1][1], [2][2], ...
         */
        int sumaDiagonalPrincipal = 0;     // Variable acumuladora para la suma de la diagonal principal
        for (int i = 0; i < n; i++) {      // Bucle que recorre los índices de la diagonal principal
            sumaDiagonalPrincipal += matriz[i][i];               // Se suma el elemento situado en la posición [i][i] de la matriz
        }
        if (sumaDiagonalPrincipal != sumaObjetivo) {/* Se compara la suma de la diagonal principal con la suma objetivo.
Si la diagonal principal no suma lo mismo, no es un cuadrado mágico y se sale del método devolviendo false */
            return false;
        }

        /**
         * Comprobación de la diagonal secundaria.
         * ( Es la diagonal que va desde la esquina superior derecha hasta la esquina inferior izquierda ).
         * La diagonal secundaria está formada por los elementos cuya columna se calcula como (n - 1 - i):
         * [0][n-1] -> pos 3 -1 -0 =2 ; [1][n-2] -> pos 3 -1 -1 =1 ; [2][n-3] -> pos 3 -1 -2 =0 ...
         */
        int sumaDiagonalSecundaria = 0; // Variable acumuladora para la suma de la diagonal secundaria
        for (int i = 0; i < n; i++) {   // Bucle que recorre los índices de la diagonal secundaria
            sumaDiagonalSecundaria += matriz[i][n - 1 - i];              // Se suma el elemento situado en la posición [i][n - 1 - i] de la matriz
        }
        if (sumaDiagonalSecundaria != sumaObjetivo) {   /* Se compara la suma de la diagonal secundaria con la suma objetivo.
Si la diagonal secundaria no suma lo mismo, no es un cuadrado mágico y se sale del método devolviendo false  */
            return false;
        }

        return true;          // Si todas las comprobaciones son correctas, es un cuadrado mágico
    }


    private int constanteMagica() {       // Calcula la constante mágica sumando los elementos de la primera fila.
        int suma = 0;                     // Crea una variable llamada suma y la inicializa a cero.
        for (int j = 0; j < n; j++) {        // Recorre la primera fila [0], en todas las posiciones de [j].
            suma += matriz[0][j];            // Suma todos los elementos de la primera fila.
        }
        return suma;                 //Devuelve el valor de la suma
    }


    private void mostrarMatriz() {
        System.out.println("=== CUADRADO MÁGICO ENCONTRADO ===");        // Muestra un título indicando que se ha encontrado un cuadrado mágico
        for (int[] fila : matriz) {        /* Bucle for-each que recorre cada fila completa de la matriz (matriz es un array de arrays).
Cada elemento de matriz es una fila (int[]). Significa literalmente “Para cada fila dentro de la matriz…”.
En cada vuelta, fila apunta a una fila completa, y fila es un int[] */
            for (int item : fila) {            /* Bucle for-each que recorre cada elemento de la fila actual y muestra el valor del elemento
seguido de un tabulador para mantener la alineación de las columnas. significa “Para cada elemento dentro de esta fila…
item es un int y recorre los valores uno a uno*/
                System.out.print(item + "\t");
            }
            System.out.println();            // Salto de línea al terminar de mostrar una fila completa
        }
    }   /* Equivalente con fori:
        for (int i = 0; i < matriz.length; i++) {          // i = fila
        for (int j = 0; j < matriz[i].length; j++) {   // j = columna
            System.out.print(matriz[i][j] + "\t");
        }
        System.out.println();
        } */
}
