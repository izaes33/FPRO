import controller.Banco;
import exceptions.CuentaNotFoundException;
import exceptions.SaldoException;
import model.CuentaBancaria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    private Banco banco;

    @BeforeEach
    void setUp() {
        // Inicialización REAL necesaria para los tests
        // Cada test empieza con el mismo estado → aislamiento total
        banco = new Banco();
        banco.agregarCuenta(new CuentaBancaria(1, 500));
        banco.agregarCuenta(new CuentaBancaria(2, 100));
    }

    // ===============================
    // CASOS CORRECTOS (flujo normal)
    // ===============================

    @Test
    void sacarDineroCorrectamente() throws Exception {
        // Se encuentra la cuenta y hay saldo suficiente
        boolean resultado = banco.sacarDinero(1, 200);

        assertTrue(resultado);
    }

    @Test
    void sacarDineroExactoSaldo() throws Exception {
        // Caso límite: sacar todo el saldo
        boolean resultado = banco.sacarDinero(2, 100);

        assertTrue(resultado);
    }

    // ===============================
    // EXCEPCIONES
    // ===============================

    @Test
    void sacarDineroSaldoInsuficiente() {
        // Flujo:
        // Banco encuentra la cuenta →
        // CuentaBancaria lanza SaldoException →
        // Banco NO la captura → se propaga
        assertThrows(SaldoException.class, () -> {
            banco.sacarDinero(1, 1000);
        });
    }

    @Test
    void sacarDineroCuentaNoExiste() {
        // Flujo:
        // No encuentra la cuenta →
        // Banco lanza CuentaNotFoundException
        assertThrows(CuentaNotFoundException.class, () -> {
            banco.sacarDinero(999, 100);
        });
    }

    // ===============================
    // CASOS LÍMITE
    // ===============================

    @Test
    void sacarDineroCero() throws Exception {
        // No hay validación en el código → se permite
        boolean resultado = banco.sacarDinero(1, 0);

        assertTrue(resultado);
    }

    @Test
    void sacarDineroNegativo() throws Exception {
        // ERROR DE DISEÑO:
        // No se controla saldo negativo → esto suma dinero en realidad
        boolean resultado = banco.sacarDinero(1, -100);

        assertTrue(resultado);
    }

    // ===============================
    // COMPORTAMIENTO ACUMULADO
    // ===============================

    @Test
    void multiplesExtraccionesHastaFallar() throws Exception {
        banco.sacarDinero(1, 200); // saldo: 300
        banco.sacarDinero(1, 200); // saldo: 100

        // Esta ya debe fallar
        assertThrows(SaldoException.class, () -> {
            banco.sacarDinero(1, 200);
        });
    }

    // ===============================
    // DISEÑO DEFECTUOSO (documentado)
    // ===============================

    @Test
    void agregarCuentaDuplicadaPermitido() {
        // No hay control de duplicados → comportamiento incorrecto
        banco.agregarCuenta(new CuentaBancaria(1, 999));

        // No hay excepción → el test simplemente documenta el fallo
        assertTrue(true);
    }
}