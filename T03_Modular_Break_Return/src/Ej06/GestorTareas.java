package Ej06;

public class GestorTareas {

    public static String procesarTareas(String[] tareas) {
        for (String tarea : tareas) {
            if (tarea.contains("URGENTE")) {
                return tarea; // return anticipado
            }
        }
        return "No hay tareas urgentes";
    }
}