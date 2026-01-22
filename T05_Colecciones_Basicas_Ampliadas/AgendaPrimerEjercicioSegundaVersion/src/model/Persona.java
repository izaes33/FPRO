package model;

public class Persona {

    private String nombre;
    private String apellido;
    private int telefono;
    private String dni;

    public Persona(String nombre, String apellido, int telefono, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Teléfono: " + telefono;
    }
}
