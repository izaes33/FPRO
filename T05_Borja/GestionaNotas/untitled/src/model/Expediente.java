package model;

import java.util.HashMap;

/*
 * Esta clase cumple dos funciones:
 * 1. Representa a UN alumno (dni, nombre, apellido, nota)
 * 2. Contiene la estructura donde se guardan TODOS los alumnos (HashMap)
 */
public class Expediente {

    // ===== DATOS DE UN ALUMNO =====
    private String dni;        // DNI del alumno (clave única)
    private String nombre;     // Nombre del alumno
    private String apellido;   // Apellido del alumno
    private double nota;       // Nota del alumno

    /*
     * HashMap estático:
     * - La clave es el DNI (String)
     * - El valor es un objeto Expediente (alumno)
     * - static significa que hay UN SOLO mapa para todo el programa
     */
    private static HashMap<String, Expediente> alumnos = new HashMap<>();

    /*
     * Constructor:
     * Se ejecuta cada vez que creamos un nuevo alumno
     */
    public Expediente(String dni, String nombre, String apellido, double nota) {
        this.dni = dni;           // Asignamos el DNI recibido
        this.nombre = nombre;     // Asignamos el nombre
        this.apellido = apellido; // Asignamos el apellido
        this.nota = nota;         // Asignamos la nota
    }

    // ===== GETTERS =====
    // Permiten leer los datos desde fuera de la clase

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getNota() {
        return nota;
    }

    /*
     * Devuelve el HashMap completo de alumnos
     * Se usa desde el controller para gestionar los datos
     */
    public static HashMap<String, Expediente> getAlumnos() {
        return alumnos;
    }

    /*
     * Vacía completamente la lista de alumnos
     */
    public static void vaciar() {
        alumnos.clear();
    }
}
