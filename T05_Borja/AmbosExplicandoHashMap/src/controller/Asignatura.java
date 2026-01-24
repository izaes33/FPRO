package controller;

import model.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

public class Asignatura {

    private HashMap<String, Alumno> listaNotas;
    // HashMap donde:
    // - La clave (String) es el DNI del alumno
    // - El valor (Alumno) es el objeto Alumno completo
    // Esto permite buscar alumnos rápidamente por DNI

    public Asignatura(){
        // Constructor de la clase
        listaNotas = new HashMap<>();
        // Inicializa el HashMap vacío cuando se crea una Asignatura
    }

    public void agregarAlumno(Alumno alumno){
        // Método para añadir un alumno a la asignatura

        if(listaNotas.containsKey(alumno.getDni())){
            // Comprueba si ya existe una clave con ese DNI
            System.out.println("El dni ya existe, no se puede agregar");
        } else {
            // Si no existe ese DNI en el HashMap
            listaNotas.put(alumno.getDni(), alumno);
            // Guarda el Alumno usando su DNI como clave
            System.out.println("Alumno agregado correctamente");
        }
    }

    public Alumno buscarAlumno(String dni){
        // Busca un alumno a partir de su DNI

        return listaNotas.get(dni);
        // get(dni) devuelve el VALOR asociado a esa clave
        // Como el valor es un Alumno, devuelve directamente el objeto Alumno
    }

    public ArrayList<Alumno> buscarNMejoresExoedientes(int n){
        // Devuelve una lista con los N alumnos con mejor nota

        ArrayList<Alumno> listadoAuxNotas = new ArrayList<>();
        // Lista auxiliar donde se copiarán los alumnos

        Set<String> keys = listaNotas.keySet();
        // Obtiene todas las claves (DNIs) del HashMap

        for(String item : keys){
            // Recorre cada DNI
            Alumno alumno = listaNotas.get(item);
            // Obtiene el Alumno asociado a ese DNI
            listadoAuxNotas.add(alumno);
            // Lo añade a la lista auxiliar
        }

        listadoAuxNotas.sort(
                Comparator.comparingDouble(Alumno::getNota).reversed()
        );
        // Ordena la lista por nota de mayor a menor

        if(listadoAuxNotas.size() == 0){
            // Si no hay alumnos
            System.out.println("No tenemos expedientes para mostrar");
            return null;
        } else {
            if(n < listadoAuxNotas.size()){
                // Si piden menos alumnos de los que hay
                listadoAuxNotas.subList(n, listadoAuxNotas.size()).clear();
                // Elimina todos los alumnos desde la posición n en adelante
                return listadoAuxNotas;
            } else {
                // Si piden más alumnos de los que existen
                n = listadoAuxNotas.size();
                listadoAuxNotas.subList(n, listadoAuxNotas.size()).clear();
                // En realidad aquí no se borra nada, pero mantiene coherencia
                System.out.println(
                        "Has introducido un numero mayor de la cantidad de notas por lo tanto solo te muestro las que tengo. Disculpa"
                );
                return listadoAuxNotas;
            }
        }
    }

    public void buscarExpedientesSuperioresA(double nota){
        boolean encontrado = false;
        // Indica si hemos encontrado al menos un alumno válido

        Set<String> keys = listaNotas.keySet();
        // Obtenemos todos los DNIs

        for(String item : keys){
            Alumno alumno = listaNotas.get(item);
            // Recuperamos el Alumno asociado al DNI

            if(alumno.getNota() >= nota){
                alumno.mostrarDatos();
                System.out.println("--------------");
                encontrado = true;
                // Marcamos que al menos uno cumple
            }
        }

        if(!encontrado){
            // Solo se ejecuta si NINGÚN alumno cumplió la condición
            System.out.println(
                    "No hemos encontrado ningun alumno con notas superiores a " + nota
            );
        }
    }


    public void vaciarLista(){
        // Elimina todos los alumnos de la asignatura
        listaNotas.clear();
        // Vacía el HashMap
        System.out.println("La asignatura se ha quedado pelada de alumnos");
    }
}
