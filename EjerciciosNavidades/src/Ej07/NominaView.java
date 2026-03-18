package Ej07;

public class NominaView {

    // Mostrar mensajes generales (feedback al usuario)
    public void mostrarMensaje(String mensaje) {
        System.out.println("[INFO] " + mensaje);
    }

    // Imprimir informe completo de un empleado
    public void imprimirInforme(String nombre, String dni, double salarioBase, int horasExtras, double salarioTotal) {

        System.out.println("========================================");
        System.out.println("        🧾 NÓMINA DEL EMPLEADO");
        System.out.println("========================================");
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("----------------------------------------");
        System.out.println("Salario base: " + salarioBase + " €");
        System.out.println("Horas extra: " + horasExtras);
        System.out.println("----------------------------------------");
        System.out.println("SALARIO TOTAL: " + salarioTotal + " €");
        System.out.println("========================================\n");
    }
}