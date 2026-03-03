package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
// @XmlRootElement indica que esta clase es la etiqueta contenedora de todo el documento.
// (name ="agenda") fuerza a que la etiqueta se llame <agenda> en lugar de <Agenda> (por defecto usa el nombre de la clase).
@XmlRootElement(name ="agenda")
@XmlAccessorType(XmlAccessType.FIELD)
public class Agenda {

    // @XmlElement obliga a que cada elemento de esta lista se llame <usuario> dentro del XML,
    // en lugar de usar el nombre de la variable ("lista").
    @XmlElement(name = "usuario")
    private List<Usuario> lista;

    // Constructor que inicializa la lista vacía para evitar errores de tipo NullPointerException
    public Agenda() {
        lista = new ArrayList<>();
    }
}