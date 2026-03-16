package Ej04;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    /*Este método es un "validador" clásico. Básicamente, se asegura de que
    el pedido sea realista y de que haya suficiente mercancía para cumplirlo.*/
    public boolean hayStock(int cantidadPedida) {
        // Retorna 'true' solo si se cumplen AMBAS condiciones:
        return this.stock >= cantidadPedida && cantidadPedida > 0;
        // 1. El stock actual (this.stock) es mayor o igual a lo que piden.
        // 2. La cantidad solicitada es un número positivo (mayor a 0).
    }

    public boolean vender(int cantidad) {
        if (hayStock(cantidad)) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    public void reabastecer(int cantidad) {
        if (cantidad > 0) this.stock += cantidad;
    }

    public double calcularValorInventario() {
        return this.precio * this.stock;
    }
}