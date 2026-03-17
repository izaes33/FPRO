package Ej06;

import java.util.ArrayList; // Importamos para usar listas dinámicas

public class CineController { // El mediador que gestiona la colección de modelos
    private ArrayList<Pelicula> listaPeliculas; // Colección de objetos Pelicula
    private CarteleraView vista; // Referencia a la vista

    public CineController(CarteleraView vista) {
        this.listaPeliculas = new ArrayList<>(); // Inicializamos la lista vacía
        this.vista = vista; // Asignamos la vista
    }

    // Método para añadir películas al sistema
    public void agregarPelicula(Pelicula p) {
        listaPeliculas.add(p); // Insertamos el objeto en el ArrayList
    }

    public void mostrarInfo(Pelicula p) {
        if (p == null) {
            System.out.println("La película es nula.");
            return;
        }
        System.out.println("Información sobre la película -" + p.getTitulo() +"-");
        System.out.println("===========================================");
        vista.imprimirFicha(
                p.getTitulo(),
                p.getDirector(),
                p.obtenerDuracionFormateada(),
                p.getAnio(),
                p.getCalificacion(),
                p.esClasica()
        );
    }

    // Método principal: Filtra y muestra solo las recomendables
    public void mostrarCarteleraRecomendada() {
        vista.mostrarCabeceraRecomendados(); // Imprimimos el título de la sección

        for (Pelicula p : listaPeliculas) { // Bucle 'for-each' para recorrer cada película
            if (p.esRecomendable()) { // Consultamos la lógica del modelo
                // Si es recomendable, pedimos a la vista que la dibuje
                vista.imprimirFicha(
                        p.getTitulo(),
                        p.getDirector(),
                        p.obtenerDuracionFormateada(),
                        p.getAnio(),
                        p.getCalificacion(),
                        p.esClasica()
                );
            }
        }
    }
}