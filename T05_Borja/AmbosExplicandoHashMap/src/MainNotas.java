import controller.Asignatura;
import model.Alumno;

import java.util.ArrayList;
import java.util.Scanner;

public class MainNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Asignatura asignatura = new Asignatura();
        int opcion;

        do{
            System.out.println("Las opciones del menu son ");
            System.out.println("1 - Agregar alumno");
            System.out.println("2 - Buscar alumno-nota");
            System.out.println("3 - Ver mejores expediente");
            System.out.println("4 - Ver expedientes superiores a una nota");
            System.out.println("5 - Vaciar lista");
            System.out.println("6 - Salir");
            System.out.println("Que opcion quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Vamos a agregar un Alumno en la asignatura");
                    System.out.println("Introduce el dni del alumno");
                    String dni = scanner.next();
                    System.out.println("Introduce el nombre del alumno");
                    String nombre = scanner.next();
                    System.out.println("Introduce el apellido del alumno");
                    String apellido = scanner.next();
                    double nota=-11;
                    while(nota<0 || nota>10){
                        System.out.println("Introduce la nota que ha sacado el alumno en la asignatura");
                        nota = scanner.nextDouble();
                        if(nota<0 || nota>10){
                            System.out.println("Nota incorrecta vuelve a introducir una nota entre 0-10");
                        }
                    }
                    Alumno alumno = new Alumno(dni, nombre, apellido, nota);
                    asignatura.agregarAlumno(alumno);
                }
                case 2 -> {
                    System.out.println("Vamos a buscar la nota de un Alumno");
                    System.out.println("Introduce el dni del alumno que quieres saber su nota");
                    String dni = scanner.next();
                    Alumno alumno = asignatura.buscarAlumno(dni); /* S está creando una variable temporal instanciando un objeto
                    que iguala obtiene todos sus parámetros del que encuentra el método buscarAlumno
                    (al que se le pasa como argumento en dni) */
                    System.out.println("La nota de " + alumno.getNombre() + " es " + alumno.getNota() );
                }
                case 3 -> {
                    System.out.println("Vamos a ver los mejores expedientes");
                    System.out.println("Introduce cuantas de las mejores notas quieres saber");
                    int nNotas = scanner.nextInt();
                    ArrayList<Alumno> listadoMejores = new ArrayList<>();
                    listadoMejores = asignatura.buscarNMejoresExoedientes(nNotas);
                    System.out.println("==== Los " + nNotas + " mejores alumnos son: ======");
                    for(Alumno alumno : listadoMejores){
                        System.out.println(alumno.getNombre() + " " + alumno.getApellido() + " con una nota de " + alumno.getNota());
                    }
                }
                case 4 -> {
                    System.out.println("Vamos a ver expedientes superiores a una nota");
                    System.out.print("Introduce la nota para obtener los ezpedientes superiores a esa nota: ");
                    double nota = scanner.nextDouble();
                    asignatura.buscarExpedientesSuperioresA(nota);
                }
                case 5 -> {
                    System.out.println("Vamos a vaciar la lista");
                    asignatura.vaciarLista();
                }
                case 6 -> {
                    System.out.println("Saliendo......");
                }
                default -> {
                    System.out.println("Opción invalida");
                }
            }
        } while(opcion != 6);
    }
}
