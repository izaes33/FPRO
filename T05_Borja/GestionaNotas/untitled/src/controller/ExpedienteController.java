package controller;

import model.Expediente;
import java.util.Comparator;

/*
 * Esta clase contiene TODA la lógica del programa.
 * El Main solo llama a estos métodos.
 */
public class ExpedienteController {

    /*
     * Inserta un alumno en el HashMap
     * Devuelve true si todo va bien
     * Devuelve false si hay error (nota incorrecta o DNI duplicado)
     */
    public boolean insertarAlumno(String dni, String nombre, String apellido, double nota) {

        // Comprobamos que la nota sea válida y que el DNI no exista
        if (nota < 0 || nota > 10 || Expediente.getAlumnos().containsKey(dni)) {
            return false; // Error
        }

        // Creamos el objeto alumno
        Expediente alumno = new Expediente(dni, nombre, apellido, nota);

        // Lo guardamos en el HashMap usando el DNI como clave
        Expediente.getAlumnos().put(dni, alumno);

        return true; // Inserción correcta
    }

    /*
     * Busca un alumno por DNI
     * Devuelve el alumno si existe
     * Devuelve null si no existe
     */
    public Expediente buscarAlumno(String dni) {
        return Expediente.getAlumnos().get(dni);
    }

    /*
     * Muestra las N mejores notas
     */
    public void mostrarMejores(int limite) {

        Expediente.getAlumnos().values()   // Obtenemos todos los alumnos
                .stream()                  // Convertimos a stream
                .sorted(                  // Ordenamos
                        Comparator.comparingDouble(Expediente::getNota)
                                .reversed() // De mayor a menor nota
                )
                .limit(limite)             // Mostramos solo los N primeros
                .forEach(a ->              // Recorremos el resultado
                        System.out.println(
                                a.getNombre() + " " +
                                        a.getApellido() + " → " +
                                        a.getNota()
                        )
                );
    }

    /*
     * Muestra los alumnos con nota igual o superior a la indicada
     */
    public void mostrarSuperiores(double notaMin) {

        Expediente.getAlumnos().values()
                .stream()
                .filter(a -> a.getNota() >= notaMin) // Filtramos por nota
                .forEach(a ->
                        System.out.println(
                                a.getNombre() + " " +
                                        a.getApellido() + " → " +
                                        a.getNota()
                        )
                );
    }

    /*
     * Vacía la lista de alumnos
     */
    public void vaciarExpediente() {
        Expediente.vaciar();
    }
}
