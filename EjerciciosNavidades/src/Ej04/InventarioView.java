package Ej04;

public class InventarioView {

    public void mostrarCabecera() {
        System.out.println("\n========================== INVENTARIO ACTUAL ==========================");
    }

    public void mostrarInfo(String cod, String nom, double pre, int sto, double valorTotal) {
        System.out.printf("Cód: %-5s | Nombre: %-15s | Precio: %7.2f€ | Stock: %3d | Total: %8.2f€%n",
                cod, nom, pre, sto, valorTotal);
    }

    public void mostrarMensaje(String texto) {
        System.out.println("[SISTEMA] " + texto);
    }

    public void mostrarResultadoVenta(String nombre, boolean exito, int cant) {
        if (exito) {
            System.out.println("✔️ Venta confirmada: " + cant + " unidades de [" + nombre + "].");
        } else {
            System.out.println("❌ Operación cancelada por falta de stock.");
        }
    }
}