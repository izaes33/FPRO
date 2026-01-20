/* Crea una agenda de personas gestionada por menú con operaciones básicas:

Realiza una aplicación que gestione usuarios mediante arrays.
Cada usuario: nombre (string), apellido (string), teléfono (int) y dni (string).

Funcionalidad guiada por menú:
- Agregar persona: pedir nombre, apellido, teléfono y dni. Agregar a la lista
- Buscar persona: pedir un dni y sacar por pantalla todos los datos con el
formato Nombre: XXX, Apellido: XXX, Teléfono: XXX
- Borrar persona: pedir un dni y eliminar de la lista
- Listar personas: listar todos los elementos con el formato
Nombre: XXX, Apellido: XXX, Teléfono: XXX
- En todos los casos dar confirmación al usuario tanto del éxito
como de la ejecución incorrecta de la opción */

import controller.AgendaController;
import model.AgendaModel;
import view.AgendaView;

public class Main {
    public static void main(String[] args) {
        AgendaModel model = new AgendaModel(100);
        AgendaView view = new AgendaView();
        AgendaController controller = new AgendaController(model, view);

        controller.iniciar();
    }
}
