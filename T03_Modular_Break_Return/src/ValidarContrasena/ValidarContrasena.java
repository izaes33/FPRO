/* **Objetivo:** Crear un método que valide una contraseña y use `return` para salir anticipadamente si no cumple los requisitos.

**Requisitos:**

1. Crea un método `boolean validarContrasena(String password)`.
2. La contraseña debe tener al menos 8 caracteres. Si no cumple, usa `return false` inmediatamente.
3. Debe contener al menos una letra mayúscula. Si no cumple, usa `return false`.
4. Debe contener al menos un número. Si no cumple, usa `return false`.
5. Si pasa todas las validaciones, devuelve `true`. */

package ValidarContrasena;

import java.util.Scanner;

import java.util.Scanner;

public class ValidarContrasena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Validar valida = new Validar();

        System.out.print("Ingresa una contraseña: ");
        String password = scanner.nextLine();
        boolean resultado = valida.validar(password);


        if (resultado) {
            System.out.println("Contraseña válida");
        } else {
            System.out.println("Contraseña inválida");
        }
    }
}