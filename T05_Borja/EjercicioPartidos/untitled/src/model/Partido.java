package model;

public class Partido {
    private Equipo eLocal;
    private Equipo eVisitante;
    private int gLocal;
    private int gVisitante;
    private boolean jugado;

    public Partido() {
    }

    public Partido(Equipo eLocal, Equipo eVisitante) {
        this.eLocal = eLocal;
        this.eVisitante = eVisitante;
        this.jugado = false;
    }

    public Partido(Equipo eLocal, Equipo eVisitante, int gLocal, int gVisitante) {
        this.eLocal = eLocal;
        this.eVisitante = eVisitante;
        this.gLocal = gLocal;
        this.gVisitante = gVisitante;
        this.jugado = true;

        // Actualizar estadísticas de ambos equipos
        eLocal.setgFavor(eLocal.getgFavor() + gLocal);
        eLocal.setgContra(eLocal.getgContra() + gVisitante);

        eVisitante.setgFavor(eVisitante.getgFavor() + gVisitante);
        eVisitante.setgContra(eVisitante.getgContra() + gLocal);
    }

    public void registrarResultado(int golesLocal, int golesVisitante) {
        if (jugado) {
            System.out.println("¡Este partido ya fue jugado!");
            return;
        }

        this.gLocal = golesLocal;
        this.gVisitante = golesVisitante;
        this.jugado = true;

        // Actualizar estadísticas
        eLocal.setgFavor(eLocal.getgFavor() + golesLocal);
        eLocal.setgContra(eLocal.getgContra() + golesVisitante);
        eVisitante.setgFavor(eVisitante.getgFavor() + golesVisitante);
        eVisitante.setgContra(eVisitante.getgContra() + golesLocal);
    }

    public void mostrarDatos() {
        System.out.printf("%s %d - %d %s%n",
                eLocal.getNombre(), gLocal, gVisitante, eVisitante.getNombre());
    }

    // Getters y setters
    public Equipo geteLocal() {
        return eLocal;
    }

    public void seteLocal(Equipo eLocal) {
        this.eLocal = eLocal;
    }

    public Equipo geteVisitante() {
        return eVisitante;
    }

    public void seteVisitante(Equipo eVisitante) {
        this.eVisitante = eVisitante;
    }

    public int getgLocal() {
        return gLocal;
    }

    public void setgLocal(int gLocal) {
        this.gLocal = gLocal;
    }

    public int getgVisitante() {
        return gVisitante;
    }

    public void setgVisitante(int gVisitante) {
        this.gVisitante = gVisitante;
    }

    public boolean isJugado() {
        return jugado;
    }
}