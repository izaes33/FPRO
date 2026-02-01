import model.Equipo;
import model.Partido;
import controller.Registrador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creamos la liga
        Registrador liga = new Registrador();
        //Creamos un ArrayList de Equipos para poder crear las combinaciones
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        //Preguntamos cuantos equipos tiene la liga
        System.out.println("Cuantos equipos quieres que participen en tu liga");
        int nEquipos = scanner.nextInt();
        //Creamos equipos
        for(int i=0; i<nEquipos; i++){
            System.out.println("Introduce el nombre del equipo numero " + (i+1) + ":");
            String nombre = scanner.next();
            Equipo equipo = new Equipo(nombre);
            listaEquipos.add(equipo);
        }

        //Creamos los partidos
        /* equipo albacete = new Equipo ("Albacete")
           equipo madrid = new Equipo ("Madrid")

        /*Partido partido1 = new Partido(albacete, madrid, 3, 2);
        Partido partido2 = new Partido(barcelona, alcoyano, 5, 0);
        Partido partido3 = new Partido(barcelona, madrid, 5, 0);
        //Regitramos los partidos en la liga, añade en listaPartidos
        liga.registrarPartido(partido1);
        liga.registrarPartido(partido2);
        liga.registrarPartido(partido3);*/

        //partidos de ida
        for (int i=0; i<listaEquipos.size(); i++){
            for (int j=i+1; j<listaEquipos.size();j++){
                liga.registrarPartido(new Partido(listaEquipos.get(i), listaEquipos.get(j),(int)(Math.random()*6),(int)(Math.random()*6)));
            }
        }
        //partidos de vuelta
        for (int i= listaEquipos.size()-1; i>=0; i--){
            for (int j=i-1; j>=0; j--){
                liga.registrarPartido(new Partido(listaEquipos.get(i), listaEquipos.get(j),(int)(Math.random()*6),(int)(Math.random()*6)));
            }
        }

        //desordanamos lista liga
        //Collections.shuffle(liga);

        //Mostramos todos los partidos de la liga
        liga.mostrarPartidos();

        System.out.println("Introduce el nombre del Equipo que quieres saber las estadisticas");
        String estadisticas = scanner.next();
        liga.buscarEstadistica(estadisticas);
    }
}
