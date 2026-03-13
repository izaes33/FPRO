package modeljson;

import lombok.Data;
import java.util.List;

/* @Data es una anotación de Lombok que le dice a Java: "Por debajo, créame automáticamente los Getters, Setters,
el método toString(), etc., para todos los atributos de esta clase". */
@Data

public class ProductosRespuesta {

    /* El JSON que recibimos de internet tiene una propiedad llamada "products" que es un array [].
    Jackson buscará un atributo en Java que se llame EXACTAMENTE "products". */
    private List<Producto> products;
    // Como es un array de productos, en Java lo representamos como una Lista de objetos 'Producto'.


    // Estas tres propiedades vienen en el JSON original para indicar la paginación
    // (cuántos productos hay en total, cuántos ha saltado, y el límite por página).
    private int total;
    private int skip;
    private int limit;
}