package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD) // De nuevo, mapea las variables a XML automáticamente.
public class Usuario {

    // @XmlAttribute le dice a JAXB: "No crees una etiqueta <id>1</id>".
    // En su lugar, mételo dentro de la etiqueta de apertura del usuario como un atributo: <usuario id="1">
    @XmlAttribute
    private int id;

    // Al no tener anotaciones, se convierten en etiquetas normales: <nombre>...</nombre>
    private String nombre;
    private String apellido;

    // Como Direccion es otra clase, JAXB creará una etiqueta <direccion> y meterá dentro sus campos
    private Direccion direccion;

    @XmlAttribute // Se convierte en atributo: <usuario ... dni="123123A">
    private String dni;

    @XmlAttribute // Se convierte en atributo: <usuario ... edad="41">
    private int edad;

    // Tienes un constructor personalizado que omite el "id" (seguramente por si el id se autogenera)
    public Usuario(String nombre, String apellido, Direccion direccion, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.edad = edad;
    }
}