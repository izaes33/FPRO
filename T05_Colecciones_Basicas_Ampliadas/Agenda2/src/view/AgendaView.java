package view;

import model.Contacto;

import java.util.Scanner;

public class AgendaView {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- MENÚ AGENDA ---");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto por DNI");
        System.out.println("3. Borrar contacto por DNI");
        System.out.println("4. Listar contactos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    public Contacto leerContacto() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el apellido: ");
        String apellido = sc.nextLine();

        System.out.print("Introduce el teléfono: ");
        int telefono = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el DNI: ");
        String dni = sc.nextLine();

        System.out.print("Introduce el email: ");
        String email = sc.nextLine();

        return new Contacto(nombre, apellido, telefono, dni, email);
    }

    public String leerDni() {
        System.out.print("Introduce el DNI: ");
        return sc.nextLine();
    }

    public void mostrarContacto(Contacto c) {
        System.out.println(c.toString());
    }

    public void mostrarLista(Contacto[] contactos) {
        for (Contacto c : contactos) {
            mostrarContacto(c);
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
