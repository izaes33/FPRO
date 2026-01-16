// Declaramos el paquete controller
package controller;

// Importamos las clases necesarias
import model.Equipo;
import model.Partido;
import java.util.ArrayList;
import java.util.List;

// Clase encargada de registrar y gestionar equipos y partidos
public class Registrador {

    // Lista donde se almacenan todos los equipos
    private List<Equipo> equipos;
    // Lista donde se almacenan todos los partidos
    private List<Partido> partidos;

    /**
     * Añade un equipo al registro
     */
    public void registrarEquipo(Equipo equipo) {

        // Si la lista no está inicializada, la creamos
        if (equipos == null) {
            equipos = new ArrayList<>();
        }

        // Añadimos el equipo a la lista
        equipos.add(equipo);
    }

    /**
     * Registra un partido en el sistema
     */
    public void registrarPartido(Partido partido) {

        // Si la lista no está inicializada, la creamos
        if (partidos == null) {
            partidos = new ArrayList<>();
        }

        // Añadimos el partido a la lista
        partidos.add(partido);
    }

    /**
     * Muestra todos los partidos registrados
     */
    public void mostrarPartidos() {

        // Comprobamos si hay partidos
        if (partidos == null || partidos.isEmpty()) {
            System.out.println("No hay partidos registrados.");
            return;
        }

        // Recorremos y mostramos cada partido
        for (Partido p : partidos) {
            p.mostrarDatos();
        }
    }

    /**
     * Busca un equipo por nombre y muestra sus estadísticas
     */
    public void buscarEstadisticasEquipo(String nombre) {

        // Indicador de búsqueda
        boolean encontrado = false;

        // Recorremos la lista de equipos
        for (Equipo e : equipos) {

            // Comparamos nombres ignorando mayúsculas
            if (e.getNombre().equalsIgnoreCase(nombre)) {

                // Mostramos estadísticas
                e.mostrarEstadisticas();
                encontrado = true;
                break;
            }
        }

        // Si no se encontró el equipo
        if (!encontrado) {
            System.out.println("Equipo no encontrado: " + nombre);
        }
    }

    // Getters
    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}