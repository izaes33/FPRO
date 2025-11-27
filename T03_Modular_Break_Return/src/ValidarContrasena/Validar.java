package ValidarContrasena;

public class Validar {


    public boolean validar(String password) {
        if (!tieneLongitud(password)) {
            System.out.println("Error: la contraseña debe tener al menos 8 caracteres.");
            return false;
        }
        if (!tieneMayuscula(password)) {
            System.out.println("Error: la contraseña debe contener al menos una letra mayúscula.");
            return false;
        }
        if (!tieneNumero(password)) {
            System.out.println("Error: la contraseña debe contener al menos un número.");
            return false;
        }


        return true;
    }


    private boolean tieneLongitud(String password) {
        return password != null && password.length() >= 8;
    }


    private boolean tieneMayuscula(String password) {
        for (char c : password.toCharArray()) {
/*for (char c : password.toCharArray()) recorre cada carácter de la contraseña uno por uno.
(En cada iteración la variable c recibe el siguiente carácter).
(password.toCharArray():
Convierte la String password en un nuevo array de char. Cada posición
del array contiene un carácter de la cadena, en el mismo orden.) */
            if (Character.isUpperCase(c)) {
//Character.isUpperCase(c) verifica si el carácter actual c es una letra mayúscula.
                return true;
            }
        }
        return false;
    }


    private boolean tieneNumero(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}