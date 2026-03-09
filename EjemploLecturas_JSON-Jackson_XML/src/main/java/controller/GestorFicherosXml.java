package controller;

import modelXml.Agenda;
import modelXml.Direccion;
import modelXml.Usuario;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class GestorFicherosXml {

    public void exportarXML() {
        // Creamos el objeto raíz
        Agenda agenda = new Agenda();
        // Añadimos usuarios a la lista con sus datos de prueba
        agenda.getLista().add(new Usuario(1, "Borja1", "Martin1", new Direccion("Madrid1", "Madrid", "Madrid"), "123123A", 41));
        agenda.getLista().add(new Usuario(2, "Borja2", "Martin2", new Direccion("Madrid2", "Madrid", "Madrid"), "223123A", 42));
        agenda.getLista().add(new Usuario(3, "Borja3", "Martin3", new Direccion("Madrid3", "Madrid", "Madrid"), "323123A", 43));
        agenda.getLista().add(new Usuario(4, "Borja4", "Martin4", new Direccion("Madrid4", "Madrid", "Madrid"), "423123A", 44));
        agenda.getLista().add(new Usuario(5, "Borja5", "Martin5", new Direccion("Madrid5", "Madrid", "Madrid"), "523123A", 45));

        // 2. CONVERTIMOS A XML (Marshalling)
        try {
            /* Creamos el importador (la libraría) "Contexto" de JAXB, avisándole de
            cuál es la clase raíz (Agenda) que va a manejar */
            JAXBContext context = JAXBContext.newInstance(Agenda.class);

            /* Creamos el objeto Marshaller, que es la herramienta que hace la traducción
            de Java a XML */
            Marshaller marshaller = context.createMarshaller();

            /* Si se descomenta la siguiente línea lo que hace es tabular el XML con saltos
            de línea y espacios para que sea más legible.
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); */

            /* Ejecutamos la traducción mediante el metodo marsahll, que lo que hace es
            coger el objeto 'agenda' y guardarlo en el archivo físico. */
            marshaller.marshal(agenda, new File("src/main/java/ficheros/usuarios.xml"));

        } catch (JAXBException e) {
            /* Si algo falla (la ruta del archivo no existe, hay problemas de permisos,
            o hay algún error en la estructura de los datos), salta este error */
            System.out.println("Error en la codificacion del fichero XML");
            System.out.println(e.getMessage());
        }
    }
}