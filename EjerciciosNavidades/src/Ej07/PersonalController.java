package Ej07;

import java.util.ArrayList;

public class PersonalController {
    private ArrayList<Empleado> empleados;
    private NominaView vista;

    public PersonalController(NominaView vista) {
        this.vista = vista;
        this.empleados = new ArrayList<>();
    }

    // Añadir empleado
    public void add(Empleado e) {
        empleados.add(e);
        vista.mostrarMensaje("Empleado añadido: " + e.getNombre());
    }

    // Registrar horas a un empleado
    public void registrarHoras(Empleado e, int cantidad) {
        e.agregarHorasExtras(cantidad);
        vista.mostrarMensaje("Se han registrado " + cantidad + " horas extras para " + e.getNombre());
    }

    // Subida salarial
    public void gestionarAumento(Empleado e, double porcentaje) {
        e.aplicarAumento(porcentaje);
        vista.mostrarMensaje("Aumento del " + porcentaje + "% aplicado a " + e.getNombre());
    }

    // Generar nómina de un empleado
    public void generarNomina(Empleado e) {
        vista.imprimirInforme(
                e.getNombre(),
                e.getDni(),
                e.getSalarioBase(),
                e.getHorasExtras(),
                e.calcularSalarioTotal()
        );
    }

    public void resetearHorasExtras() {
        for (Empleado e : empleados) {
            e.resetearHorasExtras();
        }
        vista.mostrarMensaje("Todas las horas extras han sido reseteadas.");
    }
}