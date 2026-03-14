package Ej02;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos una única instancia de la Vista
        EstudianteView vista = new EstudianteView();

        // 2. Creamos el Controlador pasándole la vista
        // (Recuerda que nuestro nuevo constructor ya no pide un estudiante, solo la vista)
        EstudianteController controller = new EstudianteController(vista);
        // 3. Creamos los objetos de tipo Estudiante
        Estudiante est1 = new Estudiante("Ana García", 20, 9.5, 10.0, 8.5);
        Estudiante est2 = new Estudiante("Juan Pérez", 22, 4.0, 5.5, 3.0);

        // 4. Agregamos los estudiantes al ArrayList del controlador
        controller.agregarEstudiante(est1);
        controller.agregarEstudiante(est2);

        // 5. Ejecutamos el informe
        // Este método ahora recorrerá la lista internamente y mostrará ambos
        System.out.println("--- GENERANDO INFORMES DE ESTUDIANTES ---");
        controller.actualizarVista();
    }
}