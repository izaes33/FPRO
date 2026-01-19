/* Crear un método que procese una lista de tareas y use `return` anticipadamente
si encuentra una tarea prioritaria.

**Requisitos:**
1. Crea un método `String procesarTareas(String[] tareas)`.
2. Recorre el array de tareas.
3. Si encuentra una tarea que contiene la palabra "URGENTE", usa `return` inmediatamente devolviendo esa tarea.
4. Si no hay tareas urgentes, devuelve "No hay tareas urgentes".
5. En el `main`, prueba con diferentes arrays de tareas. */

package Ej06;

public class MainEj06 {

    public static void main(String[] args) {
        GestorTareas gestorTareas=new GestorTareas();

        String[] tareas1 = {
                "Revisar correos",
                "Enviar informe URGENTE al jefe",
                "Actualizar base de datos"
        };

        String[] tareas2 = {
                "Hacer copia de seguridad",
                "Limpiar escritorio",
                "Planificar reunión"
        };

        String[] tareas3 = {
                "URGENTE: restaurar servidor",
                "Revisar logs"
        };

        System.out.println(gestorTareas.procesarTareas(tareas1));
        System.out.println(gestorTareas.procesarTareas(tareas2));
        System.out.println(gestorTareas.procesarTareas(tareas3));
    }
}
