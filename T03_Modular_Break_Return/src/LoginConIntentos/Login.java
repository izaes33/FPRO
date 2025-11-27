package LoginConIntentos;

import java.util.Scanner;

public class Login {

    public boolean intentarLogin(Scanner sc, String usuarioCorrecto, String passwordCorrecta) {
        return realizarLogin(sc, usuarioCorrecto, passwordCorrecta);
    }

    private boolean realizarLogin(Scanner sc, String usuarioCorrecto, String passwordCorrecta) {
        boolean exito = false;
        int maxIntentos = 3;

        for (int i = 1; i <= maxIntentos; i++) {
            System.out.print("Intento " + i + " - Usuario: ");
            String usuarioIngresado = sc.nextLine();

            System.out.print("Intento " + i + " - Contraseña: ");
            String passwordIngresada = sc.nextLine();

            if (usuarioIngresado.equals(usuarioCorrecto) && passwordIngresada.equals(passwordCorrecta)) {
                exito = true;
                break; // login exitoso, salimos del bucle
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        }

        return exito;
    }
}