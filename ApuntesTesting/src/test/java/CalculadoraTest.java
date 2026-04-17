import model.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach /*  indica que ANTES DE HACER CUALQUIER TEST, SE HA DE PASAR POR AQUÍ
                    SIRVE PARA HACER INICIALIZACIONES, porque para realizar cualquier test
                    lo primero que necesitamos es EL OBJETO    */
    void setUp() {
        calculadora = new Calculadora();
    }
    /*  La declaración de la variable de tipo Calculadora y la creación del objeto se separan
        rincipalmente por flexibilidad y control:
            -Se puede decidir cuándo crear el objeto -> Ej: en @BeforeEach, no al declarar
            -Se puede reutilizar la variable -> calculadora = new Calculadora();
            -Puede no crearse el objeto
        Piensa:
        Calculadora calculadora; → “reservo un hueco para guardar una calculadora”
                new Calculadora() → “creo una calculadora real”
                = → “meto esa calculadora en el hueco” */

    // @Test indica que este metodo es de prueba
    @Test
    void testSumar() {
        assertEquals(10, calculadora.sumar(4, 6));
    }

    @Test
    void testRestar() {
        assertEquals(10, calculadora.resta(14, 4));
    }

    @Test
    void testMultiplicar() {
        assertEquals(20, calculadora.multi(10, 2));

    }

    @Test
    void testDividir() {
        // assertEquals(5,calculadora.division(10,2));
        // tienes que dar 5, en la division con resultado 5
        assertEquals(5, calculadora.division(10, 2));
        assertThrows(IllegalArgumentException.class, () -> calculadora.division(10, 0));
    }

    /* JUnit - Assertions básicas

        assertEquals(esperado, real)                                    assertThrows(TipoExcepcion.class, () -> { código })
            → Comprueba que el resultado es igual el esperado.              → Comprueba que se lanza una excepción concreta.
            → Si no coincide → falla el test.                               → Usa una lambda (porque pasa código a ejecutar).
                                                                            → Si NO se lanza la excepción → falla el test.

    SIMILITUDES:
        → Ambos son métodos de JUnit (Assertions).                  DIFERENCIAS:
        → Sirven para validar comportamientos en tests.                 → assertEquals → compara valores.
        → Si la condición no se cumple → el test falla.                 → assertThrows → comprueba excepciones.
                                                                        → assertThrows usa lambda; assertEquals no. */


    @ParameterizedTest // Indica que un test se ejecuta varias veces con distintos datos
    @CsvSource({
            "10,100,10", // resultado esperado=10, op1=100, op2=10
            "4,16,4",    // resultado esperado=4,  op1=16,  op2=4
            "1,1,1",     // resultado esperado=1,  op1=1,   op2=1
            "6,1,1",     // resultado esperado=6,  op1=1,   op2=1 (este fallará si 1/1 ≠ 6)
            /* CSV = Comma-Separated Values (valores separados por comas)
                (Es un formato de texto para representar datos en forma de tabla). */
    })
    void testDividirMult(int resultado, int op1, int op2) {
        /* En cada ejecución, JUnit toma una línea del CsvSource y asigna:
                     resultado esperado, op1, op2 */
        assertEquals(resultado, calculadora.division(op1, op2));
    }

}
