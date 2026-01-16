import controller.Registrador;
import model.Equipo;
import model.Partido;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULADOR DE LIGA ASTURIANA ===\n");

        // 1. Crear el registrador (gestor de la liga)
        Registrador registrador = new Registrador();

        // 2. Crear y añadir equipos
        System.out.println("Creando equipos...");
        registrador.agregarEquipo(new Equipo("Real Oviedo"));
        registrador.agregarEquipo(new Equipo("Sporting de Gijón"));
        registrador.agregarEquipo(new Equipo("Unionistas de Salamanca")); // invitado especial :)
        registrador.agregarEquipo(new Equipo("Lealtad de Villaviciosa"));
        registrador.agregarEquipo(new Equipo("Caudal Deportivo"));

        System.out.println("Equipos registrados: " + registrador.getEquipos().size() + "\n");

        // 3. Generar todos los partidos de ida y vuelta
        System.out.println("Generando calendario completo (ida y vuelta)...");
        registrador.generarLigaCompleta();
        System.out.println("Total de partidos generados: " + registrador.getListaPartidos().size());
        System.out.println("   (cada equipo juega " + (registrador.getEquipos().size() - 1) * 2 + " partidos)\n");

        // 4. Mostrar el calendario completo (pendiente de jugar)
        System.out.println("CALENDARIO COMPLETO:");
        registrador.mostrarPartidos();
        System.out.println("----------------------------------------\n");

        // 5. Simular algunos resultados (jugamos solo algunos partidos)
        System.out.println("Simulando resultados de algunos partidos...\n");

        var partidos = registrador.getListaPartidos();

        // Partido 0: Oviedo vs Sporting (ida)
        if (!partidos.isEmpty()) {
            partidos.get(0).registrarResultado(2, 1);
            System.out.println("Resultado simulado: " + partidos.get(0).geteLocal().getNombre() +
                    " " + partidos.get(0).getgLocal() + " - " +
                    partidos.get(0).getgVisitante() + " " + partidos.get(0).geteVisitante().getNombre());
        }

        // Partido 3: Sporting vs Oviedo (vuelta)
        if (partidos.size() > 3) {
            partidos.get(3).registrarResultado(1, 1);
            System.out.println("Resultado simulado: " + partidos.get(3).geteLocal().getNombre() +
                    " " + partidos.get(3).getgLocal() + " - " +
                    partidos.get(3).getgVisitante() + " " + partidos.get(3).geteVisitante().getNombre());
        }

        // Algún partido más...
        if (partidos.size() > 8) {
            partidos.get(8).registrarResultado(0, 3);
            System.out.println("Resultado simulado: " + partidos.get(8).geteLocal().getNombre() +
                    " " + partidos.get(8).getgLocal() + " - " +
                    partidos.get(8).getgVisitante() + " " + partidos.get(8).geteVisitante().getNombre());
        }

        System.out.println("\n----------------------------------------\n");

        // 6. Mostrar estadísticas de varios equipos
        System.out.println("ESTADÍSTICAS DE LOS EQUIPOS:");
        String[] equiposConsultar = {"Real Oviedo", "Sporting de Gijón", "Lealtad de Villaviciosa", "Caudal Deportivo"};

        for (String nombre : equiposConsultar) {
            System.out.println("Buscando estadísticas de: " + nombre);
            registrador.buscarEstadisticas(nombre);
            System.out.println();
        }

        // 7. Mostrar solo los partidos ya jugados (opcional - necesitarías implementar este método)
        // registrador.mostrarPartidosJugados();  // <- Podrías añadirlo si quieres

        System.out.println("=== FIN DE LA SIMULACIÓN ===\n");
    }
}