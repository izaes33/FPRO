/* **Objetivo:** Modificar el ejercicio anterior para usar una clase `Contacto` y garantizar que no existan contactos duplicados con el mismo email.

**Requisitos:**
1. Crear una clase `Contacto` con los atributos: `nombre` (String), `apellido` (String), `telefono` (int), `dni` (String) y `email` (String).
2. La clase debe tener:
    - Constructor con todos los parámetros
    - Getters y setters para todos los atributos
    - Método `toString()` que devuelva el formato: "Nombre: XXX, Apellido: XXX, Teléfono: XXX, Email: XXX"
3. Modificar la agenda para usar un array de tipo `Contacto[]` en lugar de `Object[]`.
4. Agregar validación de email único:
    - Antes de agregar un contacto, verificar que no exista otro contacto con el mismo email
    - Si el email ya existe, mostrar mensaje de error y no agregar el contacto
    - Crear un método auxiliar `boolean existeEmail(String email)` que recorra el array y devuelva `true` si encuentra el email
5. Al agregar persona, solicitar también el email.
6. Mantener todas las funcionalidades del ejercicio anterior: agregar, buscar por DNI, borrar por DNI y listar.
7. Actualizar todos los mensajes para incluir el email en las búsquedas y listados. */

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
