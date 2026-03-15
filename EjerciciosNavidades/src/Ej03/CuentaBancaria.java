package Ej03;

/*
 * MODELO (MODEL)
 * Esta clase representa una cuenta bancaria real.
 * Aquí se guardan los datos y se implementan las operaciones
 * que afectan al dinero.
 *
 * El modelo NO sabe nada de la interfaz ni del controlador.
 * Solo gestiona información y lógica.
 */

public class CuentaBancaria {

    // Datos privados: solo pueden modificarse mediante métodos controlados
    private String titular;
    private String numeroCuenta;
    private double saldo;

    /*
     * Constructor
     * Se usa para crear una nueva cuenta bancaria.
     * Solo pedimos titular y número de cuenta porque el saldo inicial
     * siempre empieza en 0.
     */
    public CuentaBancaria(String titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0;
    }

    // Getters: permiten leer los datos sin poder modificarlos directamente

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    /*
     * Método ingresar
     * Añade dinero a la cuenta.
     *
     * Validamos que la cantidad sea positiva para evitar
     * errores como ingresar valores negativos.
     */
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }

    /*
     * Método retirar
     * Intenta sacar dinero de la cuenta.
     *
     * Condiciones necesarias:
     * - La cantidad debe ser positiva
     * - Debe haber saldo suficiente
     *
     * Devuelve true si la operación se pudo realizar.
     */
    public void retirar(double cantidad) throws SaldoInsuficienteException {

        // Validamos que la cantidad sea positiva
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }

        // Si no hay saldo suficiente lanzamos la excepción
        if (saldo < cantidad) {
            throw new SaldoInsuficienteException("Saldo insuficiente para retirar " + cantidad + "€");
        }

        // Si todo es correcto retiramos el dinero
        saldo -= cantidad;
    }

    /*
     * Método transferir
     * Envía dinero a otra cuenta bancaria.
     *
     * Si el saldo no es suficiente, el método retirar()
     * lanzará una excepción que se propagará al controller.
     */
    public void transferir(CuentaBancaria destino, double cantidad) throws SaldoInsuficienteException {

        // Primero intentamos retirar el dinero de la cuenta origen
        retirar(cantidad);

        // Si el retiro fue exitoso, ingresamos el dinero en la cuenta destino
        destino.ingresar(cantidad);
    }
}