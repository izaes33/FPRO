package Ej03;

/*
 * MAINnEs el punto de entrada del programa.
 * Aquí se crean los objetos principales:
 * - Vista
 * - Controlador
 * - Modelos (cuentas)
 * Después se simulan las operaciones del ejercicio.
 */

public class Main {

    public static void main(String[] args) {

        BancoView vista = new BancoView(); // Creamos la vista (salida por consola)

        // Creamos el controlador que conectará modelo y vista
        BancoController controller = new BancoController(vista);

        // Creamos dos cuentas bancarias (modelos)
        CuentaBancaria cuentaAna = new CuentaBancaria("Ana López", "ES1234567890");
        CuentaBancaria cuentaPepe = new CuentaBancaria("Pepe Pérez", "ES0987654321");

        // Registramos las cuentas en el sistema
        controller.agregarCuenta(cuentaAna);
        controller.agregarCuenta(cuentaPepe);

        // Simulación de operaciones
        controller.ingresar(cuentaAna, 1000);
        controller.retirar(cuentaAna, 300);
        controller.retirar(cuentaAna, 1000);

        // Transferencia entre cuentas
        controller.transferir(cuentaAna, cuentaPepe, 200);

    }
}