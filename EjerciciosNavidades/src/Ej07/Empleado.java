package Ej07;

public class Empleado { // Clase que representa la entidad del trabajador
    private String nombre; // Nombre completo del empleado
    private String dni; // Documento Nacional de Identidad
    private double salarioBase; // Sueldo fijo mensual sin extras
    private int horasExtras; // Contador de horas adicionales trabajadas

    public Empleado() {
    }

    // Constructor: Inicializa los datos básicos. Las horas extras empiezan en 0 por defecto.
    public Empleado(String nombre, String dni, double salarioBase) {
        this.nombre = nombre; // Asignamos el nombre recibido
        this.dni = dni; // Asignamos el DNI recibido
        this.salarioBase = salarioBase; // Asignamos el sueldo base
        this.horasExtras = 0; // Cumplimos el requisito: las horas extras iniciales son cero
    }

    // Getters y Setters: Acceso y modificación de atributos privados
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }

    public int getHorasExtras() { return horasExtras; }
    public void setHorasExtras(int horasExtras) { this.horasExtras = horasExtras; }

    // Lógica: Sumar horas al contador actual
    public void agregarHorasExtras(int horas) {
        if (horas > 0) { // Validación: No tiene sentido añadir horas negativas
            this.horasExtras += horas; // Operador de acumulación
        }
    }

    // Lógica: Cálculo del sueldo final (Base + Bonificación por extras)
    public double calcularSalarioTotal() {
        // Multiplicamos las horas por 20€ (tarifa fija por hora extra) y sumamos la base
        return this.salarioBase + (this.horasExtras * 20.0);
    }

    // Lógica: Incrementar el sueldo base permanentemente
    public void aplicarAumento(double porcentaje) {
        if (porcentaje > 0) { // Validación de seguridad
            double aumento = this.salarioBase * (porcentaje / 100); // Calculamos el montante del aumento
            this.salarioBase += aumento; // Actualizamos el sueldo base de la ficha
        }
    }

    // Lógica: Limpiar el contador de horas (útil tras pagar la nómina del mes)
    public void resetearHorasExtras() {
        this.horasExtras = 0; // Ponemos el atributo de nuevo a cero
    }
}