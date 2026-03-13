package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import modeljson.Producto;
import modeljson.ProductosRespuesta;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class GestorFicherosJSON_Jackson {

    // Guardamos la dirección de internet donde está el archivo JSON.
    private static final String URL_BASE = "https://dummyjson.com/products";

    public void lecturaJSON() {
        // 1. Instanciamos el ObjectMapper. Es la herramienta principal de Jackson.
        // Es el "traductor" entre el texto JSON y nuestros objetos Java.
        ObjectMapper mapper = new ObjectMapper();

        try {
            // 2. Convertimos el texto de la URL en un objeto URL real que Java pueda usar para conectarse a internet.
            URL url = URI.create(URL_BASE).toURL();

            // 3. ¡LA MAGIA OCURRE AQUÍ! Le decimos a Jackson:
            // "Usa el ObjectMapper, conéctate a esta URL, descarga el texto JSON y transfórmalo
            // directamente en un objeto Java de tipo ProductosRespuesta.class".
            // Si las propiedades coinciden, Jackson lo hace automáticamente.
            ProductosRespuesta respuesta = mapper.readValue(url, ProductosRespuesta.class);

            // 4. Verificamos que la respuesta no haya llegado vacía y que tenga productos dentro.
            if (respuesta != null && respuesta.getProducts() != null) {
                // Iteramos la lista de productos que Jackson rellenó y llamamos a su método mostrarDatos().
                respuesta.getProducts().forEach(Producto::mostrarDatos);
            }
        } catch (IOException e) {
            // Si falla la conexión a internet, o Jackson no puede parsear el JSON porque
            // algo estaba mal formado, Java "captura" (catch) el error y lo imprime,
            // en lugar de colgar el programa completamente.
            System.err.println("Error al procesar el JSON: " + e.getMessage());
        }
    }
}