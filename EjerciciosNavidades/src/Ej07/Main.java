package Ej07;

public class Main {
    public static void main(String[] args) {

        // Vista
        NominaView vista = new NominaView();

        // Controller único
        PersonalController controller = new PersonalController(vista);

        // Empleados
        Empleado emp1 = new Empleado("Laura Soler", "12345678A", 1800.0);
        Empleado emp2 = new Empleado("Carlos Ruiz", "87654321B", 2100.0);

        // Añadir empleados
        controller.add(emp1);
        controller.add(emp2);

        // Operaciones Laura
        controller.registrarHoras(emp1, 5);
        controller.gestionarAumento(emp1, 10);
        controller.generarNomina(emp1);

        // Operaciones Carlos
        controller.registrarHoras(emp2, 10);
        controller.generarNomina(emp2);

        // Reset de horas
        controller.resetearHorasExtras();
        vista.mostrarMensaje("Las horas extra de todos los empleados han sido reseteadas para el nuevo mes.");
    }
}