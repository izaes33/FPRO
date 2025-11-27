/***Objetivo:** Crear un método que simule un sistema de login usando `break` cuando el login sea exitoso.

 **Requisitos:**

 1. Crea un método `boolean intentarLogin(String usuarioCorrecto, String passwordCorrecta)`.
 2. El usuario tiene 3 intentos máximo.
 3. Usa un bucle `for` para los intentos.
 4. Simula el ingreso de usuario y contraseña (puedes usar valores hardcodeados diferentes en cada intento).
 5. Si las credenciales son correctas, usa `break` y devuelve `true`.
 6. Si se agotan los intentos, devuelve `false`. */

package LoginConIntentos;
import java.util.Scanner;

public class LoginConIntentos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        System.out.println("Sistema de login (3 intentos máximo)");

        boolean exito = login.intentarLogin(sc, "admin", "1234");

        if (exito) {
            System.out.println("¡Login exitoso!");
        } else {
            System.out.println("Se agotaron los intentos. Login fallido.");
        }

        sc.close();
    }
}
