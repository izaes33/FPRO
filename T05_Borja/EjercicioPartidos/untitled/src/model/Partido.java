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
     * Muestra los equipos que disputan el partido
     */
    public void mostrarDatos() {
        System.out.println(
                equipoLocal.getNombre() + " vs " + equipoVisitante.getNombre()
        );
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

        equipoLocal.setGolFavor(equipoLocal.getGolFavor() + golLocal);
        equipoLocal.setGolContra(equipoLocal.getGolContra() + golVisitante);

        equipoVisitante.setGolFavor(equipoVisitante.getGolFavor() + golesVisitante);
        equipoVisitante.setGolContra(equipoVisitante.getGolContra() + golesLocal);
    }
}
