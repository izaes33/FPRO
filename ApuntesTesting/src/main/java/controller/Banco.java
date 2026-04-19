package controller;

import exceptions.CuentaNotFoundException;
import exceptions.SaldoException;
import model.CuentaBancaria;

import java.util.ArrayList;

public class Banco {

    private ArrayList<CuentaBancaria> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuentaBancaria) {
        // No se valida duplicidad → posible bug
        this.cuentas.add(cuentaBancaria);
    }


    public boolean sacarDinero(int id, int saldo)
            throws CuentaNotFoundException, SaldoException {

        // Stream busca la cuenta
        CuentaBancaria cuentaBancaria =
                cuentas.stream()
                        .filter(cuenta -> cuenta.getId() == id)
                        .findFirst()
                        .orElse(null);

        if (cuentaBancaria != null) {

            // Aquí puede lanzar SaldoException
            // Banco NO la controla → se propaga al test
            cuentaBancaria.sacarDinero(saldo);

            return true;

        } else {
            // Cuenta no encontrada → excepción propia
            throw new CuentaNotFoundException("Cuenta no encontrada");
        }
    }

    public CuentaBancaria getCuenta(int id) throws CuentaNotFoundException {
        return cuentas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta no encontrada"));
    }
}