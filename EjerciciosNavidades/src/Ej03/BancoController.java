package Ej03;

import java.util.ArrayList;
import java.util.List;

/*
 * CONTROLADOR (CONTROLLER)
 * Esta clase actúa como intermediario entre el modelo y la vista.
 * Su función es:
 * - Recibir acciones del usuario
 * - Ordenar al modelo que ejecute operaciones
 * - Pedir a la vista que muestre resultados
 */

public class BancoController {
    // Lista de cuentas existentes
    private List<CuentaBancaria> cuentas;
    // Referencia a la vista para mostrar resultados
    private BancoView vista;

    /*
     * Constructor
     * Inicializa la lista de cuentas y conecta el controlador con la vista.
     */

    public BancoController() {
    }
    public BancoController(BancoView vista) {
        this.vista = vista;
        cuentas = new ArrayList<>();
    }

    /*
     * Añade una nueva cuenta al sistema.
     */
    public void agregarCuenta(CuentaBancaria cuenta) {

        cuentas.add(cuenta);

        vista.mostrarMensaje("Cuenta creada correctamente");
        vista.mostrarInfo(cuenta);

    }

    /*
     * Realiza un ingreso en una cuenta.
     * El controlador ordena al modelo actualizar el saldo
     * y después pide a la vista mostrar el resultado.
     */
    public void ingresar(CuentaBancaria cuenta, double cantidad) {

        cuenta.ingresar(cantidad);

        vista.mostrarMensaje("Ingreso de " + cantidad + "€ realizado");
        vista.mostrarInfo(cuenta);

    }

    /*
     * Intenta retirar dinero de una cuenta.
     */
    public void retirar(CuentaBancaria cuenta, double cantidad) {
        try {
            cuenta.retirar(cantidad);
            vista.mostrarMensaje("Retiro realizado correctamente");
            vista.mostrarInfo(cuenta);

        } catch (SaldoInsuficienteException e) {
            // Mensaje específico cuando no hay saldo
            vista.mostrarMensaje(e.getMessage());
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    public void transferir(CuentaBancaria origen, CuentaBancaria destino, double cantidad) {

        try {

            origen.transferir(destino, cantidad);

            vista.mostrarMensaje("Transferencia realizada correctamente");

            vista.mostrarMensaje("Cuenta origen:");
            vista.mostrarInfo(origen);

            vista.mostrarMensaje("Cuenta destino:");
            vista.mostrarInfo(destino);

        } catch (SaldoInsuficienteException e) {

            // Mensaje cuando no hay saldo suficiente
            vista.mostrarMensaje(e.getMessage());

        } catch (IllegalArgumentException e) {

            vista.mostrarMensaje(e.getMessage());

        }
    }

    /*
     * Muestra la información de una cuenta concreta.
     */
    public void mostrarCuenta(CuentaBancaria cuenta) {
        vista.mostrarInfo(cuenta);
    }
}