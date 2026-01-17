package model;

// Clase que representa un equipo
public class Equipo {

    private String nombre;
    private int golFavor;
    private int golContra;

    // Constructor con nombre
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.golFavor = 0;
        this.golContra = 0;
    }

    /**
     * Muestra estadísticas del equipo
     */
    public void mostrarEstadisticas() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Goles a favor: " + golFavor);
        System.out.println("Goles en contra: " + golContra);
        System.out.println("Diferencia: " + (golFavor - golContra));
        System.out.println("---------------------");
    }

    public String getNombre() {
        return nombre;
    }

    public int getGolFavor() {
        return golFavor;
    }

    public void setGolFavor(int golFavor) {
        this.golFavor = golFavor;
    }

    public int getGolContra() {
        return golContra;
    }

    public void setGolContra(int golContra) {
        this.golContra = golContra;
    }
}
