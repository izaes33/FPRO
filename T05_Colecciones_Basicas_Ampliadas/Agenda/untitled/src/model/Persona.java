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

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getTelefono() { return telefono; }
    public String getDni() { return dni; }
}
