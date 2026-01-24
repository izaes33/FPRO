package model;

public class Equipo {
    private String nombre;
    private int gFavor;
    private int gContra;

    public Equipo(){}

    public Equipo(String nombre){
        this.nombre = nombre;
    }

    public void sacarEstadisticas(){
        System.out.println("El nombre del equipo: " + nombre);
        System.out.println("Los goles a favor: " + gFavor);
        System.out.println("Los goles encontra: " + gContra);
    }

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
