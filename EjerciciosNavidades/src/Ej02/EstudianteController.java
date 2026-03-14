package Ej02;

import java.util.ArrayList;
import java.util.List;

public class EstudianteController { // Clase mediadora del patrón MVC
    private List<Estudiante> estudiantes;
    private EstudianteView vista; /* Esta variable es la que hace posible que la inyección
    de dependencias funcione a lo largo de toda la vida del objeto.
Para entenderlo, hay que diferenciar entre el acto de recibir la dependencia y el acto de guardarla.
1. El Constructor "Recibe" (Inyección):
Cuando haces public EstudianteController(EstudianteView vista), estás abriendo la puerta.
La inyección de dependencias ocurre en ese preciso instante. El Main decide qué vista inyectar.
2. La Variable "Guarda" (Persistencia)
Si no tuvieras la variable private EstudianteView vista; dentro del controlador,
pasar la vista por el constructor no serviría de nada.
El parámetro del constructor es una variable local. Muere en cuanto el constructor termina de ejecutarse (al llegar a la llave de cierre }).
Si el controlador no la guarda en su propia variable "de clase", cuando luego llames al método actualizarVista(), el controlador ya habría olvidado
qué vista le pasaron. No tendría a quién enviarle los datos. */

    /* Constructor: recibe la vista e inicializa el ArrayList vacío
    El constructor ahora sirve para configurar la infraestructura de tu objeto.
Acepta la Vista: (Inyección de dependencia) para saber dónde hablar.
Crea la Lista: Para tener un lugar donde guardar datos.
Sin el constructor, se tendría que inicializar la lista y la vista manualmente desde fuera en cada método,
lo cual sería un caos de código repetido. El constructor garantiza que el objeto "nazca" sano y listo para trabajar. */
    public EstudianteController(EstudianteView vista) {
        this.estudiantes = new ArrayList<>();
        this.vista = vista;
    }
    /* Al introducir varios Estudiantes a través del constructor, los posteriores no sobreescribirían
    la variable VISTA que guardaron los anteriores, porque el controlador no mira una variable fija,
    sino que hace esto:
"Voy a recorrer mi lista desde el primer asiento hasta el último y, por cada uno que encuentre,
llamaré a la vista para que imprima su informe".
Por eso, al final del proceso, se verán los informes de Ana, de Juan y de todos los que se haya añadido,
sin que ninguno haya "pisado" al anterior.*/

    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    // Método que orquesta la generación del informe para cada estudiante
    public void actualizarVista() {
        for (Estudiante modelo : estudiantes) {
            // El controlador extrae la información de cada modelo en la lista
            // y se la pasa a la vista para que la imprima.
            vista.mostrarInforme(
                    modelo.getNombre(),
                    modelo.getEdad(),
                    modelo.getNotaMatematicas(),
                    modelo.getNotaProgramacion(),
                    modelo.getNotaIngles(),
                    modelo.calcularPromedio(),
                    modelo.obtenerCalificacion()
            );
        }
    }
}