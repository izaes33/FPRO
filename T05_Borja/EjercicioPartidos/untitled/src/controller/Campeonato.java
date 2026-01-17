// Declaramos el paquete controller
package controller;

// Importamos clases necesarias
import model.Equipo;
import model.Partido;
import java.util.ArrayList;
import java.util.List;

// Clase que controla automáticamente el campeonato
public class Campeonato {

    // Lista de equipos
    private List<Equipo> equipos = new ArrayList<>();
    // Lista de partidos
    private List<Partido> partidos = new ArrayList<>();

    /**
     * Ejecuta todas las fases del campeonato en orden
     */
    public void ejecutarCampeonato() {

        // Mostramos mensaje inicial
        System.out.println("=== INICIO DEL CAMPEONATO ===\n");
        // Creamos los equipos
        crearEquipos();
        // Generamos el calendario
        generarCalendario();
        // Mostramos los partidos
        mostrarPartidos();
        // Simulamos los resultados y los registramos
        simularResultados();
        // Mostramos estadísticas finales
        mostrarEstadisticas();
        // Mostramos mensaje final
        System.out.println("\n=== FIN DEL CAMPEONATO ===");
    }

    /**
     * Crea los equipos participantes
     */
    private void crearEquipos() {

        // Añadimos equipos a la lista
        equipos.add(new Equipo("Real Oviedo"));
        equipos.add(new Equipo("Sporting de Gijón"));
        equipos.add(new Equipo("Lealtad de Villaviciosa"));
        equipos.add(new Equipo("Caudal Deportivo"));
        equipos.add(new Equipo("Unionistas de Salamanca"));

        // Informamos del número de equipos
        System.out.println("Equipos creados: " + equipos.size() + "\n");
    }

    /**
     * Genera el calendario de partidos ida y vuelta
     */
    private void generarCalendario() {

        // Recorremos los equipos como locales
        for (int i = 0; i < equipos.size(); i++) {
            // Equipo local
            Equipo local = equipos.get(i);
            // Recorremos los equipos como visitantes
            for (int j = 0; j < equipos.size(); j++) {
                // Evitamos que un equipo juegue contra sí mismo
                if (i != j) {
                    // Equipo visitante
                    Equipo visitante = equipos.get(j);
                    // Creamos el partido
                    Partido partido = new Partido(local, visitante);
                    // Añadimos el partido a la lista
                    partidos.add(partido);
                }
            }
        }
        // Informamos del número de partidos
        System.out.println("Partidos generados (ida y vuelta): " + partidos.size() + "\n");
    }

    /**
     * Muestra el calendario completo
     */
    private void mostrarPartidos() {
        // Mostramos cabecera
        System.out.println("CALENDARIO COMPLETO:\n");
        // Recorremos los partidos
        for (Partido p : partidos) {
            p.mostrarDatos();
        }
        // Separador visual
        System.out.println();
    }

    /**
     * Simula los resultados de todos los partidos
     */
    private void simularResultados() {

        // Mostramos mensaje
        System.out.println("SIMULANDO RESULTADOS...\n");

        // Recorremos todos los partidos
        for (Partido p : partidos) {

            // Generamos goles aleatorios
            int golesLocal = (int) (Math.random() * 5);
            int golesVisitante = (int) (Math.random() * 5);

            // Registramos el resultado
            p.registrarResultado(golesLocal, golesVisitante);
        }
    }

    /**
     * Muestra las estadísticas finales de los equipos
     */
    private void mostrarEstadisticas() {

        // Mostramos cabecera
        System.out.println("ESTADÍSTICAS FINALES:\n");

        // Recorremos los equipos
        for (Equipo e : equipos) {
            e.mostrarEstadisticas();
        }
    }
}
