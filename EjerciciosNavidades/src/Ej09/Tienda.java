package Ej09;

import java.util.ArrayList;

public class Tienda {

    private String nombre;
    private ArrayList<Producto> productos;


    public Tienda() {
    }

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }


    public boolean agregarProducto(Producto nuevoProducto) {

        // Validación: evitar duplicados por código
        if (buscarProducto(nuevoProducto.getCodigo()) != null) {
            return false; // ya existe
        }

        productos.add(nuevoProducto);
        return true;
    }


    public Producto buscarProducto(String codigo) {

        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }


    /*
     * Calcula el valor total del inventario
     * Suma el valor de cada producto
     */
    public double calcularValorTotalInventario() {

        double total = 0;

        for (Producto p : productos) {
            total += p.calcularValorInventario();
        }

        return total;
    }


    /*
     * Devuelve solo productos sin stock
     * (se usa en el controlador)
     */
    public ArrayList<Producto> getProductosSinStock() {

        ArrayList<Producto> sinStock = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getStock() == 0) {
                sinStock.add(p);
            }
        }

        return sinStock;
    }


    public String getNombre() { return nombre; }
    public ArrayList<Producto> getProductos() { return productos; }
}