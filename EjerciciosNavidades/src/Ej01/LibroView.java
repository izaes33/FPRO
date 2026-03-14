package Ej01;

// Clase View: se encarga exclusivamente de mostrar información por pantalla
// No contiene lógica del programa, solo salida de datos
public class LibroView {

    // Método para mostrar los detalles de un libro
    public void mostrarDetalles(String titulo, String autor, int paginas, double precio) {
        // Se imprime la información recibida desde el controlador
        System.out.println("Libro: " + titulo +
                ", Autor: " + autor +
                ", Páginas: " + paginas +
                ", Precio: " + precio + "€");
    }

    // Método para mostrar si un libro es largo o no
    public void mostrarResultadoLongitud(String titulo, boolean esLargo) {
        // Muestra el resultado de la comprobación realizada en el modelo
        System.out.println("El libro '" + titulo + "' es largo: " + esLargo);
    }

    // Método que informa de que se va a aplicar un descuento
    public void mostrarMensajeDescuento(String titulo, double porcentaje) {
        // Mensaje informativo antes de modificar el precio
        System.out.println("Aplicando descuento del " + porcentaje +
                "% al libro: " + titulo);
    }

    // Método que muestra el precio final tras aplicar el descuento
    public void mostrarPrecioActualizado(String titulo, double nuevoPrecio) {
        // Se imprime el precio actualizado que llega desde el controlador
        System.out.println("Nuevo precio de '" + titulo + "': " +
                nuevoPrecio + "€");
    }
}