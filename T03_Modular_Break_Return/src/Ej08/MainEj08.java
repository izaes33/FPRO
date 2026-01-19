/* Crear un método que valide edades en un array, saltando valores inválidos con `continue`.

**Requisitos:**
1. Crea un método `int contarEdadesValidas(int[] edades)`.
2. Recorre el array de edades.
3. Si la edad es negativa o mayor a 120, usa `continue` para ignorarla.
4. Cuenta las edades válidas.
5. Devuelve el contador de edades válidas.
6. Crea otro método `void mostrarEdadesValidas(int[] edades)` que muestre solo las edades válidas.  */

package Ej08;


public class MainEj08 {
    public static void main(String[] args) {
        ValidadorEdades validadorEdades= new ValidadorEdades();

        int[] edades = {25, -3, 40, 130, 18, 0, 121, 65};

        validadorEdades.mostrarEdadesValidas(edades);
        System.out.println("Total válidas: " + validadorEdades.contarEdadesValidas(edades));
    }
}
