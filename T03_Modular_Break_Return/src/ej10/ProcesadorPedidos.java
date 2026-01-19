package ej10;

public class ProcesadorPedidos {
    public static boolean verificarStock(int cantidad, int stock) {
        if (cantidad > stock) {
            return false; // salida inmediata
        }
        return true;
    }

    // 2. Cálculo de descuentos por cantidad
    public static double calcularDescuento(double precio, int cantidad) {
        if (cantidad >= 10) {
            return precio * 0.20; // 20% descuento
        }
        if (cantidad >= 5) {
            return precio * 0.10; // 10% descuento
        }
        return 0;
    }

    // 3. Procesamiento de pedidos
    public static void procesarPedidos(String[] productos, int[] cantidades, double[] precios) {
        double total = 0;

        for (int i = 0; i < productos.length; i++) {

            if (cantidades[i] == 0) {
                continue; // se ignoran pedidos sin cantidad
            }

            if (!verificarStock(cantidades[i], 50)) {
                System.out.println("Stock insuficiente para " + productos[i]);
                continue;
            }

            double subtotal = precios[i] * cantidades[i];
            double descuento = calcularDescuento(subtotal, cantidades[i]);
            double totalProducto = subtotal - descuento;

            total += totalProducto;

            System.out.println(productos[i] + " -> Total: " + totalProducto + " €");

            if (total > 1000) {
                System.out.println("Límite de 1000 € superado. Procesamiento detenido.");
                break; // se corta el procesamiento automático
            }
        }

        System.out.println("Total final procesado: " + total + " €");
    }
}
