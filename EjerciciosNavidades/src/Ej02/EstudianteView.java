package Ej02;

public class EstudianteView { // Clase para gestionar la interfaz de usuario (consola)
    // Método que recibe los datos ya procesados para imprimirlos con formato
    public void mostrarInforme(String nombre, int edad, double nMat, double nProg, double nIng, double promedio, String calificacion) {
        System.out.println("---------- INFORME DEL ESTUDIANTE ----------"); // Cabecera visual
        System.out.println("Nombre: " + nombre); // Muestra el nombre
        System.out.println("Edad: " + edad + " años"); // Muestra la edad
        System.out.println("Notas -> Mates: " + nMat + " | Progra: " + nProg + " | Inglés: " + nIng); // Lista de notas
        System.out.printf("Promedio: %.2f\n", promedio); // Muestra el promedio con 2 decimales para mayor limpieza
        System.out.println("Calificación: " + calificacion); // Muestra el texto (Sobresaliente, etc.)
        System.out.println("--------------------------------------------\n"); // Separador final
    }
}