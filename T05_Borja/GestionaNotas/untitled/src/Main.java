import controller.ExpedienteController;
import model.Expediente;
import java.util.Scanner;

/*
 * Clase principal:
 * - Muestra el menú
 * - Lee datos por teclado
 * - Llama al controller
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);           // Para leer por teclado
        ExpedienteController controller = new ExpedienteController(); // Lógica
        int opcion;                                    // Opción del menú

        // Bucle principal del programa
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Introducir alumno");
            System.out.println("2. Buscar alumno por DNI");
            System.out.println("3. Ver mejores expedientes");
            System.out.println("4. Ver expedientes superiores a una nota");
            System.out.println("5. Vaciar lista");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();  // Leemos la opción
            sc.nextLine();          // Limpiamos el buffer

            switch (opcion) {

                case 1 -> { // Introducir alumno
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = sc.nextLine();

                    System.out.print("Nota: ");
                    double nota = sc.nextDouble();

                    // Llamamos al controller
                    if (controller.insertarAlumno(dni, nombre, apellido, nota)) {
                        System.out.println("Alumno añadido");
                    } else {
                        System.out.println("Datos incorrectos o DNI duplicado");
                    }
                }

                case 2 -> { // Buscar alumno
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();

                    Expediente a = controller.buscarAlumno(dni);

                    if (a == null) {
                        System.out.println("Alumno no encontrado");
                    } else {
                        System.out.println(
                                a.getNombre() + " " +
                                        a.getApellido() + " → " +
                                        a.getNota()
                        );
                    }
                }

                case 3 -> { // Mejores notas
                    System.out.print("Número de mejores notas: ");
                    int n = sc.nextInt();
                    controller.mostrarMejores(n);
                }

                case 4 -> { // Superiores a una nota
                    System.out.print("Nota mínima: ");
                    double notaMin = sc.nextDouble();
                    controller.mostrarSuperiores(notaMin);
                }

                case 5 -> { // Vaciar lista
                    controller.vaciarExpediente();
                    System.out.println("Lista vaciada");
                }

                case 0 -> System.out.println("Programa finalizado");

                default -> System.out.println("Opción incorrecta");
            }

        } while (opcion != 0); // El programa termina cuando se elige 0
    }
}
