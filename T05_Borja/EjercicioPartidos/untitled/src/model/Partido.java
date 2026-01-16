package model;

// Clase que representa un partido
public class Partido {

    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golLocal;
    private int golVisitante;
    private boolean jugado;

    // Constructor con equipos
    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jugado = false;
    }

    /**
     * Registra el resultado del partido
     */
    public void registrarResultado(int golesLocal, int golesVisitante) {

        if (jugado) {
            return;
        }

        golLocal = golesLocal;
        golVisitante = golesVisitante;
        jugado = true;

        equipoLocal.setgFavor(equipoLocal.getgFavor() + golesLocal);
        equipoLocal.setGolContra(equipoLocal.getGolContra() + golesVisitante);

        equipoVisitante.setgFavor(equipoVisitante.getgFavor() + golesVisitante);
        equipoVisitante.setGolContra(equipoVisitante.getGolContra() + golesLocal);
    }

    /**
     * Muestra los equipos que disputan el partido
     */
    public void mostrarDatos() {
        System.out.println(
                equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre()
        );
    }
}
