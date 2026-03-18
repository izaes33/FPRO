package Ej08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Coche coche = new Coche("Toyota", "Corolla", 2020);
        CocheView vista = new CocheView();
        CocheController controller = new CocheController(coche, vista);

        int opcion;

        do {
            System.out.println("══════════════════════════════════════");
            System.out.println("        🚗 SIMULADOR DE COCHE");
            System.out.println("══════════════════════════════════════");
            System.out.println("1. Ver estado del vehículo");
            System.out.println("2. Realizar viaje");
            System.out.println("3. Repostar combustible");
            System.out.println("4. Salir");
            System.out.print("👉 Elige una opción: ");

            opcion = sc.nextInt();

            System.out.println();

            switch (opcion) {
                case 1:
                    controller.actualizarCuadroMandos();
                    break;

                case 2:
                    System.out.print("Introduce km a viajar: ");
                    double km = sc.nextDouble();
                    controller.viajar(km);
                    break;

                case 3:
                    System.out.print("Litros a repostar: ");
                    double litros = sc.nextDouble();
                    controller.irAGasolinera(litros);
                    break;

                case 4:
                    System.out.println("👋 Saliendo del simulador...");
                    break;

                default:
                    System.out.println("❌ Opción no válida");
            }

        } while (opcion != 4);

        sc.close();
    }
}