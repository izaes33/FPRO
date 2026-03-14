package Ej02;

public class Estudiante { // Definición de la clase que representa la entidad Estudiante
    private String nombre; // Atributo para almacenar el nombre del alumno
    private int edad; // Atributo para la edad
    private double notaMatematicas; // Nota específica de la asignatura de Matemáticas
    private double notaProgramacion; // Nota específica de la asignatura de Programación
    private double notaIngles; // Nota específica de la asignatura de Inglés

    public Estudiante() {
    }

    // Constructor: Inicializa un objeto Estudiante con todos sus valores iniciales
    public Estudiante(String nombre, int edad, double notaMatematicas, double notaProgramacion, double notaIngles) {
        this.nombre = nombre; // Asigna el parámetro nombre al atributo de la clase
        this.edad = edad; // Asigna la edad recibida
        this.notaMatematicas = notaMatematicas; // Inicializa la nota de mates
        this.notaProgramacion = notaProgramacion; // Inicializa la nota de progra
        this.notaIngles = notaIngles; // Inicializa la nota de inglés
    }

    // Getters y Setters: Permiten el acceso controlado a los atributos privados
    public String getNombre() { return nombre; } // Obtiene el nombre
    public void setNombre(String nombre) { this.nombre = nombre; } // Modifica el nombre
    public int getEdad() { return edad; } // Obtiene la edad
    public void setEdad(int edad) { this.edad = edad; } // Modifica la edad
    public double getNotaMatematicas() { return notaMatematicas; } // Obtiene nota de mates
    public void setNotaMatematicas(double notaMatematicas) { this.notaMatematicas = notaMatematicas; } // Modifica nota de mates
    public double getNotaProgramacion() { return notaProgramacion; } // Obtiene nota de progra
    public void setNotaProgramacion(double notaProgramacion) { this.notaProgramacion = notaProgramacion; } // Modifica nota de progra
    public double getNotaIngles() { return notaIngles; } // Obtiene nota de inglés
    public void setNotaIngles(double notaIngles) { this.notaIngles = notaIngles; } // Modifica nota de inglés

    public double calcularPromedio() {
        return (notaMatematicas + notaProgramacion + notaIngles) / 3.0;
    }

    public boolean estaAprobado() {
        return calcularPromedio() >= 5.0; // Devuelve true si el promedio es 5 o más
    }

    public String obtenerCalificacion() {
        double promedio = calcularPromedio();
        int notaEntera = (int) promedio;

        return switch (notaEntera) {
            case 10, 9 -> "Sobresaliente";
            case 8, 7 -> "Notable";
            case 6 -> "Bien";
            case 5 -> "Suficiente";
            default -> "Insuficiente";
        };
    }
}