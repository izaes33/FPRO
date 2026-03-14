package Ej01;

public class Main {

    public static void main(String[] args) {

        // 1. Creamos varios objetos Libro (instanciación con datos de prueba)
        Libro libro1 = new Libro("El Quijote", "Cervantes", 863, 25.50);
        Libro libro2 = new Libro("El Caso Bourne", "Robert Ludlum", 576, 10);

        LibroView vista = new LibroView();// 2. Creamos la vista (interfaz de salida por consola)

        // 3. Creamos el controlador y le pasamos la vista
        // El controlador gestionará los libros y la comunicación con la vista
        LibroController control = new LibroController(vista);

        // 4. Añadimos los libros al ArrayList del controlador
        control.agregarLibro(libro1);
        control.agregarLibro(libro2);

        // 5. Ejecutamos las acciones del programa

        // Mostrar todos los libros almacenados
        control.visualizarLibros();
        // Comprobar si los libros son largos
        control.chequearSiSonLargos();
        // Aplicar un descuento del 10% a todos los libros
        control.ejecutarDescuento(10);
    }
}