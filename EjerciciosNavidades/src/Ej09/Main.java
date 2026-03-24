package Ej09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Tienda tienda = new Tienda("TecnoShop DAW");
        TiendaView vista = new TiendaView();
        TiendaController control = new TiendaController(tienda, vista);

        int opcion;

        do {
            // MENÚ
            System.out.println("\n========= MENÚ =========");
            System.out.println("1. Añadir producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Listar sin stock");
            System.out.println("4. Ver valor inventario");
            System.out.println("5. Buscar producto");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Código: ");
                    String cod = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine();

                    boolean añadido = tienda.agregarProducto(
                            new Producto(cod, nom, precio, stock)
                    );

                    if (añadido) {
                        vista.mostrarMensaje("Producto añadido correctamente.");
                    } else {
                        vista.mostrarMensaje("Error: producto duplicado.");
                    }
                    break;

                case 2:
                    control.listarTodo();
                    break;

                case 3:
                    control.listarSinStock();
                    break;

                case 4:
                    control.verFinanzas();
                    break;

                case 5:
                    System.out.print("Introduce código: ");
                    String codigoBuscar = sc.nextLine();

                    Producto p = tienda.buscarProducto(codigoBuscar);

                    if (p != null) {
                        vista.mostrarMensaje("Producto encontrado:");
                        vista.mostrarProducto(p);
                    } else {
                        vista.mostrarMensaje("No existe ese producto.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}