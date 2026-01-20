package view;

import model.Persona;

import java.util.Scanner;

public class AgendaView {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- MENÚ AGENDA ---");
        System.out.println("1. Agregar persona");
        System.out.println("2. Buscar persona");
        System.out.println("3. Borrar persona");
        System.out.println("4. Listar personas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    public Persona leerPersona() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce el teléfono: ");
        int telefono = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el DNI: ");
        String dni = sc.nextLine();

        return new Persona(nombre, apellido, telefono, dni);
    }

    public String leerDni() {
        System.out.print("Introduce el DNI: ");
        return sc.nextLine();
    }

    public void mostrarPersona(Persona p) {
        System.out.println("Nombre: " + p.getNombre()
                + ", Apellido: " + p.getApellido()
                + ", Teléfono: " + p.getTelefono());
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarLista(Persona[] personas) {
        for (Persona p : personas) {
            mostrarPersona(p);
        }
    }
}
