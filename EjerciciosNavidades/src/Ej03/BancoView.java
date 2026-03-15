package Ej03;

/*
 * VISTA (VIEW)
 * Esta clase se encarga exclusivamente de mostrar información.
 *
 * No modifica datos ni toma decisiones.
 * Solo imprime resultados en consola.
 */

public class BancoView {

    /*
     * Muestra toda la información de una cuenta.
     * Se usa para ver el estado actual.
     */
    public void mostrarInfo(CuentaBancaria cuenta) {
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo: " + cuenta.getSaldo() + "€");
        System.out.println("-----------------------");
    }

    /*
     * Método genérico para mostrar mensajes informativos.
     * Permite reutilizar código en lugar de repetir System.out.println.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /*
     * Informa al usuario del resultado de una operación.
     *
     * Se usa después de retirar o transferir dinero.
     */
    public void mostrarResultado(boolean exito) {

        if (exito) {
            System.out.println("Operación realizada correctamente");
        } else {
            System.out.println("Error: saldo insuficiente o cantidad inválida");
        }

    }
}