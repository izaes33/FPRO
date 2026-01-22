package view;

import controller.AgendaController;
import model.Persona;

import java.util.Scanner;

public class AgendaView {

    private AgendaController controller;
    private Scanner sc;

    public AgendaView() {
        controller = new AgendaController();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> agregarPersona();
                case 2 -> buscarPersona();
                case 3 -> borrarPersona();
                case 4 -> listarPersonas();
                case 5 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    private void mostrarMenu() {
        System.out.println("\n--- MENÚ AGENDA ---");
        System.out.println("1. Agregar persona");
        System.out.println("2. Buscar persona");
        System.out.println("3. Borrar persona");
        System.out.println("4. Listar personas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarPersona() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce el teléfono: ");
        int telefono = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el DNI: ");
        String dni = sc.nextLine();

        controller.agregarPersona(new Persona(nombre, apellido, telefono, dni));
        System.out.println("Persona agregada correctamente.");
    }

    private void buscarPersona() {
        if (controller.estaVacia()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.print("Introduce el DNI a buscar: ");
        String dni = sc.nextLine();

        Persona p = controller.buscarPersona(dni);

        if (p != null) {
            System.out.println("Persona encontrada:");
            System.out.println(p);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    private void borrarPersona() {
        if (controller.estaVacia()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        System.out.print("Introduce el DNI a borrar: ");
        String dni = sc.nextLine();

        if (controller.borrarPersona(dni)) {
            System.out.println("Persona eliminada correctamente.");
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    private void listarPersonas() {
        if (controller.estaVacia()) {
            System.out.println("No hay personas en la agenda.");
            return;
        }

        System.out.println("Lista de personas:");
        for (Persona p : controller.listarPersonas()) {
            System.out.println(p);
        }
    }
}
