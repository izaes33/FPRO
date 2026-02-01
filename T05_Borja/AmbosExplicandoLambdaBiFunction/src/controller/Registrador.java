package controller;

import model.Partido;

import java.util.ArrayList;

public class Registrador {
    private ArrayList<Partido> listadoPartidos;

    public Registrador(){
        this.listadoPartidos = new ArrayList<>();
    }

    public void registrarPartido(Partido partido){
        this.listadoPartidos.add(partido);
        System.out.println("Partido añadido correctamente");
    }

    public void mostrarPartidos(){
        for(Partido partido: listadoPartidos){
            partido.mostrarDatos();
        }
    }

    public void buscarEstadistica(String nombre){
        for(Partido partido : listadoPartidos){
            if(partido.geteLocal().getNombre().equals(nombre)){
                System.out.println("Equipo encontrado");
                partido.geteLocal().sacarEstadisticas();
                break;
            } else if (partido.geteVisitante().getNombre().equals(nombre)) {
                System.out.println("Equipo encontrado");
                partido.geteVisitante().sacarEstadisticas();
                break;
            }
        }
        System.out.println("Equipo no encontrado en la liga");


    }

    public ArrayList<Partido> getListadoPartidos() {
        return listadoPartidos;
    }

    public void setListadoPartidos(ArrayList<Partido> listadoPartidos) {
        this.listadoPartidos = listadoPartidos;
    }
}
