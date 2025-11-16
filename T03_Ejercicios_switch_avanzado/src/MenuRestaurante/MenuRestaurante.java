package MenuRestaurante;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuRestaurante {

    public void iniciarSistema() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================================");
        System.out.println("             🍽️  SISTEMA DE PEDIDOS DE RESTAURANTE 🍽️     ");
        System.out.println("=========================================================");

        // Iteramos sobre todos los valores (constantes) definidos en el enum asegurando
        // que el proceso de selección se repita una vez por cada categoría de menú
        for (CategoriaPlato categoria : CategoriaPlato.values()) {
        /* Utiliza la función interna de los enum en Java: CategoriaPlato.values()
        (un metodo estatico que está implicito en todos los enum de Java) que
        devuelve un array de todos los objetos enum definidos (ENTRADA, PRINCIPAL, POSTRE, BEBIDA).
        (La variable categoria es declarada dentro del paréntesis del for de la siguiente manera:
        (TIPO_DE_DATO NOMBRE_DE_LA_VARIABLE : COLECCIÓN) ). En cada iteración, la variable categoria
        se convierte en el objeto enum actual, lo que le da acceso instantáneo a sus datos.
        Esto significa que, en cada iteración del bucle, categoria será una variable que podrá
        almacenar un objeto del tipo CategoriaPlato.*/

            int numeroOpcion = 0;
            String[] opciones = categoria.getOpciones(); // Obtenemos las opciones del enum
            /* extrae los platos que residen en la constante del enum (gracias al constructor
            y al getter). */

            // --- BUCLE PRINCIPAL DE VALIDACIÓN ---
            /* Obliga al usuario a ingresar una entrada que sea válida
               (un número entero y que esté dentro del rango de opciones [1, 3]). */
            while (numeroOpcion < 1 || numeroOpcion > opciones.length) {
            /* Al comienzo de cada categoría, la variable numeroOpcion se inicializa a 0.
            La condición se evalúa: (0 < 1) es verdadero.
            Dado que hay un true en la condición O, el resultado es true.
            Resultado: El bucle comienza y le muestra al usuario el menú y el prompt
            (👉 Ingrese el número de opción...). */

                // Usamos un switch para decidir cómo mostrar la categoría actual.
                // Aunque la lógica de las opciones es la misma para todas,
                // el switch puede ser útil si en el futuro queremos manejar casos especiales
                // (ej: si las BEBIDA tienen una lógica diferente, como preguntar por tamaño).
                switch (categoria) {
                    case ENTRANTE:
                    case PRINCIPAL:
                    case POSTRE:
                    case BEBIDA:

                        // Lógica de visualización y solicitud de entrada común para todas las categorías

                        /* 1. Mostrar Opciones Formateadas: Ese trozo de código tiene como objetivo
                           crear una única cadena de texto bien presentada que contenga todas las opciones
                           de un menú, enumeradas y separadas por un símbolo. */
                        StringBuilder opcionesFormateadas = new StringBuilder();
                        /* Se crea un objeto StringBuilder. Su razón de ser es construir o modificar grandes
                        cadenas de texto. A diferencia de concatenar strings con el operador +, el StringBuilder
                        es mucho más rápido y eficiente en Java porque no crea un nuevo objeto en memoria en
                        cada adición. (opcionesFormateadas será el contenedor donde se ensamblará la cadena final
                        (ej: "1. Ensalada César | 2. Crema de calabaza | 3. Tostas de jamón ibérico"). */
                        for (int i = 0; i < opciones.length; i++) {
                            opcionesFormateadas.append((i + 1)).append(". ").append(opciones[i]); //Construcción del Elemento (La Opción)
                            /* append((i + 1))	(0 + 1) = 1	Añade el número de la opción (para el usuario).
                               append(". ")	"."	Añade el punto y el espacio.
                            //append(opciones[i])	opciones[0] = "Ensalada César"	Añade el nombre real del plato */
                            if (i < opciones.length - 1) { //Lógica de Separación
                                /*Este bloque if se asegura de que el separador (" | ") se añada solo entre las opciones,
                                y no después de la última. */
                                opcionesFormateadas.append(" | ");
                            }
                        }

                        System.out.printf("\n--- CATEGORÍA: %s ---\n", categoria.name());
                        System.out.printf("Opciones de la categoría %s: %s\n", categoria.name(), opcionesFormateadas);
                        System.out.printf("👉 Ingrese el número de opción (1 a %d): ", opciones.length);

                        // Salimos del switch para manejar la lectura del Scanner fuera
                        break;
                }

                // --- INTENTO DE LECTURA Y MANEJO DE ERROR DE TIPO (InputMismatchException) ---
                try {
                    numeroOpcion = scanner.nextInt();
                    /* INTENTA leer el siguiente entero del teclado y asignarlo a numeroOpcion.
                    El programa se detiene aquí hasta que el usuario teclee algo. */

                    if (numeroOpcion < 1 || numeroOpcion > opciones.length) {
                        /* El código llega al if (numeroOpcion < 1 || numeroOpcion > opciones.length) y
                        muestra el mensaje de error de rango. (El bucle llega al final, y while vuelve a
                        evaluar la condición: (9 < 1) es falso, pero (9 > 3) es verdadero. */
                        System.out.printf("⚠️ Número de opción inválido. Por favor, ingrese un número entre 1 y %d.\n", opciones.length);
                    }

                } catch (InputMismatchException e) {
                    /* El Scanner no puede leer "hola" como un int, lo que lanza una InputMismatchException.
                    El programa salta inmediatamente al bloque catch y muestra el mensaje de error de tipo.
                    scanner.next(): Limpia el texto ("hola") que se quedó atascado en el buffer de entrada.
                    numeroOpcion = 0;: Reinicia la variable a 0. (Esto es crucial para que la condición while (0 < 1 || ...)
                    siga siendo verdadera y el bucle se repita). Resultado: El bucle se repite. */
                    System.out.println("⚠️ Error: Entrada no válida. Por favor, ingrese un número entero.");
                    scanner.next();
                    numeroOpcion = 0;
                }
            } // Fin del while (número de opción ya es válido)
            /* Vuelve a evaluar el while: ¿Es 2 < 1 (Falso) O 2 > 3 (Falso)? Resultado: FALSO.
            Condición while = FALSE. El flujo sale del bucle while). */

            // --- Confirmación y Siguiente Iteración ---
            // Esta sección solo se ejecuta una vez después de que el bucle while termina.
            String opcionSeleccionada = opciones[numeroOpcion - 1];
            System.out.printf("✅ Confirmación: Como %s, has seleccionado: '%s'.\n", categoria.name(), opcionSeleccionada);

            System.out.println("\n---------------------------------------------------------");
        }//El flujo vuelve al inicio del bucle for

        scanner.close();
        System.out.println("\n--- 🛑 PEDIDO REGISTRADO. Gracias por su selección. 🛑 ---");
    }

}