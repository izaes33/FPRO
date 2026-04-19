import model.Calculadora;
import controller.Banco;
import exceptions.CuentaNotFoundException;
import exceptions.SaldoException;
import model.CuentaBancaria;

public class Main {

    public static void main(String[] args) {

        Banco banco = new Banco();

        banco.agregarCuenta(new CuentaBancaria(1, 500));
        banco.agregarCuenta(new CuentaBancaria(2, 100));

        try {
            System.out.println("Sacando 200 de cuenta 1...");
            banco.sacarDinero(1, 200);
            System.out.println("Operación correcta");

            System.out.println("Sacando 700 de cuenta 1...");
            banco.sacarDinero(1, 700); // aquí falla

        } catch (SaldoException e) {
            // Se captura la excepción lanzada desde CuentaBancaria
            System.out.println("Error de saldo: " + e.getMessage());

        } catch (CuentaNotFoundException e) {
            // Se captura si la cuenta no existe
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Sacando dinero de cuenta inexistente...");
            banco.sacarDinero(99, 50);

        } catch (Exception e) {
            // Captura general para ver cualquier fallo
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}