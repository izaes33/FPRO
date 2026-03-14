package Ej01;

import java.util.ArrayList; // Importamos ArrayList para poder almacenar múltiples libros

// Clase Controller: se encarga de coordinar la lógica entre el modelo (Libro) y la vista (LibroView)
public class LibroController {

    private ArrayList<Libro> libros; // Lista que almacenará todos los libros creados
    private LibroView vista; // Referencia a la vista que se encargará de mostrar la información

    public LibroController() {
    }

    // Constructor del controlador
    // Recibe la vista para poder enviarle la información que se quiera mostrar
    public LibroController(LibroView vista) {
        this.vista = vista; // Se guarda la referencia a la vista
        libros = new ArrayList<>(); // Se inicializa la lista donde se guardarán los libros
    }

    // Método para añadir un libro a la lista
    public void agregarLibro(Libro libro) {
        libros.add(libro); // Añade el libro recibido al ArrayList
    }

    // Método para mostrar todos los libros almacenados
    public void visualizarLibros() {

        // Se recorre la lista de libros utilizando un foreach
        for (Libro libro : libros) {
            // Se obtienen los datos del libro (modelo)
            // y se envían a la vista para que los imprima
            vista.mostrarDetalles(
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getNumPaginas(),
                    libro.getPrecio()
            );
        }
    }

    // Método que comprueba si los libros son largos
    public void chequearSiSonLargos() {
        // Recorremos todos los libros almacenados
        for (Libro libro : libros) {
            // Se ejecuta la lógica del modelo para saber si el libro es largo
            boolean largo = libro.esLibroLargo();
            // La vista muestra el resultado obtenido
            vista.mostrarResultadoLongitud(libro.getTitulo(), largo);
        }
    }

    // Método para aplicar un descuento a todos los libros
    public void ejecutarDescuento(double porcentaje) {

        for (Libro libro : libros) { // Se recorren todos los libros de la lista
            // La vista informa que se va a aplicar el descuento
            vista.mostrarMensajeDescuento(libro.getTitulo(), porcentaje);
            // Se llama al método del modelo que modifica el precio
            libro.aplicarDescuento(porcentaje);
            // La vista muestra el nuevo precio actualizado
            vista.mostrarPrecioActualizado(libro.getTitulo(), libro.getPrecio());
        }
    }
}