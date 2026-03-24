package Ej09;

public class TiendaView {

    public void mostrarCabecera(String nombreTienda) {
        System.out.println("\n--- INVENTARIO DE: " + nombreTienda.toUpperCase() + " ---");
    }

    public void mostrarProducto(Producto p) {
        System.out.printf(
                "Cód: %-6s | Nombre: %-15s | Stock: %-4d | PVP: %.2f€\n",
                p.getCodigo(),
                p.getNombre(),
                p.getStock(),
                p.getPrecio()
        );
    }

    public void mostrarMensaje(String msg) {
        System.out.println("[INFO] " + msg);
    }

    public void mostrarValorTotal(double total) {
        System.out.println("-------------------------------------------------");
        System.out.println("VALOR TOTAL DEL INVENTARIO: " + total + "€");
        System.out.println("-------------------------------------------------");
    }
}