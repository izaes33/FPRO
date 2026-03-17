package Ej06;

import java.util.Calendar; // Importamos para obtener el año actual dinámicamente

public class Pelicula { // Clase que representa la entidad de una película
    private String titulo; // Nombre de la obra
    private String director; // Nombre del cineasta
    private int duracion; // Duración total en minutos (ej: 135)
    private int anio; // Año de estreno (ej: 1994)
    private double calificacion; // Puntuación de 0.0 a 10.0

    public Pelicula() {
    }

    // Constructor: Inicializa todos los atributos al crear el objeto
    public Pelicula(String titulo, String director, int duracion, int anio, double calificacion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.anio = anio;
        setCalificacion(calificacion); // Usamos el setter para validar el rango desde el inicio
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getCalificacion() { return calificacion; }

    // Setter con Validación: Asegura que la nota esté en el rango permitido
    public void setCalificacion(double calificacion) {
        if (calificacion >= 0 && calificacion <= 10) { // Comprobamos el rango 0-10
            this.calificacion = calificacion; // Si es válido, se asigna
        } else {
            this.calificacion = 5.0; // Si es inválido, asignamos un 5 por defecto (aprobado raspado)
        }
    }

    // Lógica: Convierte minutos totales a formato "Xh Ymin"
    public String obtenerDuracionFormateada() {
        int horas = duracion / 60; // División entera para obtener las horas completas
        int mins = duracion % 60;  // Operador módulo para obtener los minutos restantes
        return horas + "h " + mins + "min"; // Concatenamos el resultado
    }

    // Lógica: Comprobar antigüedad (> 25 años)
    public boolean esClasica() {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR); // Obtenemos el año del sistema (2026)
        return (anioActual - this.anio) > 25; // Restamos y comparamos con el umbral de 25 años
    }

    // Lógica: Criterio de recomendación
    public boolean esRecomendable() {
        return this.calificacion >= 7.0; // Devuelve true si la nota es notable o superior
    }
}