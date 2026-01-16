package model;

public class Equipo {
    private String nombre;
    private int gFavor;
    private int gContra;

    public Equipo() {
        this.gFavor = 0;
        this.gContra = 0;
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.gFavor = 0;
        this.gContra = 0;
    }

    public Equipo(String nombre, int gFavor, int gContra) {
        this.nombre = nombre;
        this.gFavor = gFavor;
        this.gContra = gContra;
    }

    public void mostrarEstadisticas() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Goles a favor: " + gFavor);
        System.out.println("Goles en contra: " + gContra);
        System.out.println("Diferencia de goles: " + (gFavor - gContra));
        System.out.println("-------------------");
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getgFavor() {
        return gFavor;
    }

    public void setgFavor(int gFavor) {
        this.gFavor = gFavor;
    }

    public int getgContra() {
        return gContra;
    }

    public void setgContra(int gContra) {
        this.gContra = gContra;
    }
}