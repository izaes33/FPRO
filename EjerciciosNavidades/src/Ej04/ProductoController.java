package Ej04;

import java.util.ArrayList;

public class ProductoController {
    private ArrayList<Producto> listaProductos; // El controlador ahora maneja la lista
    private InventarioView vista;


    public ProductoController(InventarioView vista) {
        this.listaProductos = new ArrayList<>();
        this.vista = vista;
    }

    public void agregarProducto(Producto p) {
        listaProductos.add(p);
    }

    // Método solicitado: Verifica si hay stock suficiente de un producto concreto
    public boolean verificarDisponibilidad(String codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p == null) {
            vista.mostrarMensaje("Producto con código " + codigo + " no encontrado.");
            return false;
        }

        boolean disponible = p.hayStock(cantidad);
        if (!disponible) {
            vista.mostrarMensaje("Stock insuficiente para " + cantidad + " unidades de "
                    + p.getNombre() + ". Disponible: " + p.getStock());
            return false;
        }

        vista.mostrarMensaje("Las " + cantidad + " unidades del producto "
                + p.getNombre() + " están disponibles. Stock total: " + p.getStock());
        return true;
    }

    public void ejecutarVenta(String codigo, int cantidad) {
        if (verificarDisponibilidad(codigo, cantidad)) {
            Producto p = buscarProducto(codigo);
            p.vender(cantidad);
            vista.mostrarResultadoVenta(p.getNombre(), true, cantidad);
        }
    }

    // Busca un producto por código para operar con él
    private Producto buscarProducto(String codigo) {
        for (Producto p : listaProductos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
        }
        return null;
    }


    public void ejecutarReabastecimiento(String codigo, int cantidad) {
        Producto p = buscarProducto(codigo);
        if (p != null) {
            vista.mostrarMensaje("Reabasteciendo " + cantidad + " unidades de " + p.getNombre() + "...");
            p.reabastecer(cantidad);
        }
    }

    // Actualiza la vista mostrando todos los productos de la lista
    public void actualizarVista() {
        vista.mostrarCabecera();
        for (Producto p : listaProductos) {
            vista.mostrarInfo(
                    p.getCodigo(),
                    p.getNombre(),
                    p.getPrecio(),
                    p.getStock(),
                    p.calcularValorInventario()
            );
        }
        System.out.println("=======================================================================\n");
    }
}