package model;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellido;
    private double nota;

    public Alumno(){}

    public Alumno(String dni, String nombre, String apellido, double nota){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
    }

    public void mostrarDatos(){
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Nota: " + nota);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
