/* Crea un sistema modular de procesamiento de pedidos que use `return`, `break` y `continue`.

**Requisitos:**
1. Crea un método `boolean verificarStock(int cantidad, int stock)` que devuelva inmediatamente `false` si no hay suficiente stock.
2. Crea un método `double calcularDescuento(double precio, int cantidad)` que aplique descuentos por cantidad.
3. Crea un método `void procesarPedidos(String[] productos, int[] cantidades, double[] precios)`.
4. En el procesamiento, usa `continue` para saltar productos con cantidad 0.
5. Usa `break` si el total del pedido supera los 1000 euros (límite de procesamiento automático).
6. En el `main`, simula el procesamiento de varios pedidos. */

package ej10;

public class MainEj10 {
    public static void main(String[] args) {
        ProcesadorPedidos procesadorPedidos= new ProcesadorPedidos();

        String[] productos = {"Portátil", "Monitor", "Teclado", "Ratón", "Impresora"};
        int[] cantidades = {1, 2, 0, 5, 3};
        double[] precios = {800, 200, 50, 20, 150};

        procesadorPedidos.procesarPedidos(productos, cantidades, precios);
    }

}
