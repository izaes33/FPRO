import controller.GestorFicherosXml;

public class Main {

    public static void main(String[] args) {
        GestorFicherosXml gestorFicherosXml = new GestorFicherosXml();
        gestorFicherosXml.exportarXML();

        //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    }
}
