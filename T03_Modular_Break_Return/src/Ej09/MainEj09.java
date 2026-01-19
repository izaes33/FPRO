/* Crea varios métodos modulares que analicen un texto y usen `return`, `break` y `continue`.

**Requisitos:**

1. Crea un método `int contarVocales(String texto)` que cuente vocales, usando `continue` para consonantes.
2. Crea un método `boolean contienePalabraProhibida(String texto, String[] palabrasProhibidas)` que use `return true` en cuanto encuentre una palabra prohibida.
3. Crea un método `String primeraPalabraLarga(String texto, int longitudMinima)` que busque y devuelva la primera palabra que supere la longitud mínima usando `return`.
4. En el `main`, prueba todos los métodos con diferentes textos. */

package Ej09;

public class MainEj09 {
    public static void main(String[] args) {
        AnalizadorTexto analizadorTexto = new AnalizadorTexto();

        String texto1 = "Este es un texto de prueba sencillo";
        String texto2 = "Contenido sensible con palabra prohibida";
        String texto3 = "Java es potente y extremadamente flexible";

        String[] prohibidas = {"prohibida", "ilegal", "censurada"};

        System.out.println("Vocales: " + analizadorTexto.contarVocales(texto1));
        System.out.println("¿Contiene prohibida?: " + analizadorTexto.contienePalabraProhibida(texto2, prohibidas));
        System.out.println("Primera palabra larga: " + analizadorTexto.primeraPalabraLarga(texto3, 7));
    }
}
