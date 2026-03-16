package Ej04;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos la vista
        InventarioView vistaGeneral = new InventarioView();

        // 2. Instanciamos el controlador ÚNICO
        ProductoController controlador = new ProductoController(vistaGeneral);

        // 3. Creamos productos y los añadimos al controlador
        controlador.agregarProducto(new Producto("P001", "Portátil Gaming", 1200.50, 5));
        controlador.agregarProducto(new Producto("M002", "Monitor 4K", 350.00, 2));
        controlador.agregarProducto(new Producto("T003", "Teclado Mecánico", 85.00, 10));

        // --- Simulación ---
        controlador.actualizarVista(); // Estado inicial de todos los productos

        // Operaciones usando el código del producto
        controlador.verificarDisponibilidad("P003", 3);
        controlador.verificarDisponibilidad("T003", 1);
        controlador.verificarDisponibilidad("T003", 11);


        controlador.ejecutarVenta("P001", 3);  // Venta exitosa
        controlador.ejecutarVenta("M002", 5);  // Venta fallida (falta stock)

        controlador.ejecutarReabastecimiento("M002", 10); // Reabastecemos el monitor

        // Verificamos el estado final de todo el inventario
        controlador.actualizarVista();
    }
}