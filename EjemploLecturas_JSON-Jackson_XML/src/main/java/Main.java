import controller.GestorFicherosXml;
import controller.GestorFicherosJSON_Jackson;

public class Main {

    public static void main(String[] args) {
        GestorFicherosXml gestorFicherosXml = new GestorFicherosXml();
        gestorFicherosXml.exportarXML();

        GestorFicherosJSON_Jackson gestor = new GestorFicherosJSON_Jackson();
        gestor.lecturaJSON();
    }
}
