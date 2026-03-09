package modelXml;

// Importaciones de la librería Lombok para generar código automáticamente
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Importaciones de JAXB para mapear a XML
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

// --- ANOTACIONES DE LOMBOK ---
@Getter // Crea automáticamente los métodos getCalle(), getProvincia(), etc.
@Setter // Crea automáticamente los métodos setCalle(), setProvincia(), etc.
@AllArgsConstructor // Crea un constructor con todos los parámetros (calle, provincia, localidad).
@NoArgsConstructor  // Crea un constructor vacío (obligatorio para que JAXB funcione correctamente).

// --- ANOTACIONES DE JAXB ---
@XmlAccessorType(XmlAccessType.FIELD) /* Le dice a JAXB cómo debe acceder a los datos de la clase
cuando convierte entre XML y objetos Java indicando que JAXB usará directamente los atributos de
la clase en lugar de getters. Y por defecto le dice a JAXB que coja todos los campos (FIELD)
de esta clase y los convierta en etiquetas XML (ej. <calle>Madrid</calle>) */

public class Direccion {

    // Al no tener anotaciones extra, JAXB creará etiquetas con el mismo nombre que las variables
    private String calle;
    private String provincia;
    private String localidad;
}