package Ej09;

public class AnalizadorTexto {
    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();

        for (char c : texto.toCharArray()) {
            if ("aeiou".indexOf(c) == -1) {
                continue; // salta consonantes y otros caracteres
            }
            contador++;
        }
        return contador;
    }

    public static boolean contienePalabraProhibida(String texto, String[] palabrasProhibidas) {
        texto = texto.toLowerCase();

        for (String palabra : palabrasProhibidas) {
            if (texto.contains(palabra.toLowerCase())) {
                return true; // return anticipado
            }
        }
        return false;
    }

    public static String primeraPalabraLarga(String texto, int longitudMinima) {
        String[] palabras = texto.split("\\s+");

        for (String palabra : palabras) {
            if (palabra.length() > longitudMinima) {
                return palabra; // se devuelve la primera que cumple
            }
        }
        return "No encontrada";
    }

}
