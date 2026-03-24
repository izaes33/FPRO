package Ej09;

import java.util.ArrayList;

public class TiendaController {

    private Tienda modelo;
    private TiendaView vista;

    public TiendaController() {
    }

    public TiendaController(Tienda modelo, TiendaView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }


    public void listarTodo() {

        vista.mostrarCabecera(modelo.getNombre());

        for (Producto p : modelo.getProductos()) {
            vista.mostrarProducto(p);
        }
    }


    public void listarSinStock() {

        vista.mostrarMensaje("Productos agotados:");

        ArrayList<Producto> lista = modelo.getProductosSinStock();

        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay productos agotados.");
            return;
        }

        for (Producto p : lista) {
            vista.mostrarProducto(p);
        }
    }

    /*
     * Muestra el valor total del inventario
     */
    public void verFinanzas() {

        double total = modelo.calcularValorTotalInventario();
        vista.mostrarValorTotal(total);
    }
}