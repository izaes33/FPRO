package controller;

import model.Equipo;
import model.Partido;
import java.util.ArrayList;
import java.util.List;

public class Registrador {
    private ArrayList<Partido> listaPartidos;
    private List<Equipo> equipos;

    public Registrador() {
        this.listaPartidos = new ArrayList<>();
        this.equipos = new ArrayList<>();
    }

    /**
     * Añade un equipo a la lista de equipos registrados
     */
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    /**
     * Genera todos los partidos de ida y vuelta (todos contra todos)
     * Cada equipo juega contra cada otro equipo exactamente 2 veces:
     * una como local y otra como visitante
     */
    public void generarLigaCompleta() {
        if (equipos.size() < 2) {
            System.out.println("Se necesitan al menos 2 equipos para generar partidos.");
            return;
        }

        listaPartidos.clear(); // Limpiamos partidos anteriores si los hubiera

        // Recorremos cada equipo como LOCAL
        for (int i = 0; i < equipos.size(); i++) {
            Equipo local = equipos.get(i);

            // Contra todos los demás como VISITANTE
            for (int j = 0; j < equipos.size(); j++) {
                if (i != j) {  // No se juega contra sí mismo
                    Equipo visitante = equipos.get(j);

                    // Creamos el partido (sin resultado aún)
                    Partido partido = new Partido(local, visitante);
                    listaPartidos.add(partido);
                }
            }
        }

        System.out.println("Generados " + listaPartidos.size() + " partidos (ida y vuelta).");
    }

    public void registrarPartido(Partido partido) {
        listaPartidos.add(partido);
    }

    public void mostrarPartidos() {
        if (listaPartidos.isEmpty()) {
            System.out.println("No hay partidos registrados.");
            return;
        }
    }

    /**
     * Busca y muestra las estadísticas de un equipo
     */
    public void buscarEstadisticas(String nombre) {
        boolean encontrado = false;

        for (Equipo eq : equipos) {
            if (eq.getNombre().equalsIgnoreCase(nombre)) {
                eq.mostrarEstadisticas();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró el equipo: " + nombre);
        }
    }

    // Getters
    public ArrayList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }
}