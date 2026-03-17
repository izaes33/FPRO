package Ej06;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializamos la vista y el controlador
        CarteleraView vista = new CarteleraView();
        CineController miCine = new CineController(vista);

        // 2. Creamos varios objetos Pelicula (Modelos)
        Pelicula p1 = new Pelicula("Pulp Fiction", "Quentin Tarantino", 154, 1994, 8.9);
        Pelicula p2 = new Pelicula("Cats", "Tom Hooper", 110, 2019, 2.8);
        Pelicula p3 = new Pelicula("Inception", "Christopher Nolan", 148, 2010, 8.8);
        Pelicula p4 = new Pelicula("El Padrino", "F.F. Coppola", 175, 1972, 9.2);

        // 3. Agregamos las películas al controlador
        miCine.agregarPelicula(p1);
        miCine.agregarPelicula(p2);
        miCine.agregarPelicula(p3);
        miCine.agregarPelicula(p4);

        miCine.mostrarInfo(p1);

        // 4. Ejecutamos la lógica de negocio requerida
        miCine.mostrarCarteleraRecomendada();
    }
}