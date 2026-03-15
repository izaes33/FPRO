package Ej03;

/*
 * Excepción personalizada para indicar que
 * una cuenta no tiene saldo suficiente.
 */
public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensaje) {
        super(mensaje);
    }

}