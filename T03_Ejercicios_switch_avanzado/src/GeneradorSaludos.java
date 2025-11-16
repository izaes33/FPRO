import java.time.LocalTime;
import java.util.Random;

public class GeneradorSaludos {

    /**
     * Requisito 1: Crea un método obtenerHoraActual() que devuelva un número entre 0 y 23.
     * En este caso, usaremos la hora real del sistema.
     * Si no se usa la hora real, se devuelve un número aleatorio para fines de prueba.
     */
    public static int obtenerHoraActual() {
        // Obtenemos la hora actual del sistema (en formato 0-23)
        return LocalTime.now().getHour();

        // --- OPCIÓN PARA PRUEBAS (Descomentar para probar horas fijas o aleatorias) ---
        // return new Random().nextInt(24); // Devuelve una hora aleatoria entre 0 y 23
        // return 2; // Ejemplo de Madrugada
        // return 14; // Ejemplo de Tarde
    }

    public void saludo(){

        // Llama al método para obtener la hora actual (0-23)
        final int HORA = obtenerHoraActual();

        String saludo;

        System.out.printf("Hora actual del sistema: %02d:00\n", HORA);
        System.out.println("------------------------------------");

        // Requisito 2: Usa switch(true) para clasificar los rangos de hora.
        // El switch(true) evalúa cada 'case' como una condición booleana.
        switch (HORA) {
            case 0,1,2,3,4,5 -> saludo = "🌙 ¡Buenas Madrugadas! Trabajar a esta hora es admirable.";
            case 6,7,8,9,10,11 -> saludo = "☕ ¡Buenos Días! Que tengas un excelente comienzo de jornada.";
            case 12,13,14,15,16,17,18,19 -> saludo = "☀️ ¡Buenas Tardes! Es la hora perfecta para tomar un descanso.";
            case 20,21,22,23 -> saludo = "🌌 ¡Buenas Noches! Espero que el día haya sido productivo.";
            default ->
                // Este 'default' solo se ejecutaría si obtenerHoraActual() devuelve un valor
                // fuera del rango 0-23, lo cual es improbable con LocalTime.
                saludo = "❌ Error: Hora fuera de rango.";
        }

        // Requisito 3: Muestra el saludo apropiado.
        System.out.println(saludo);
        System.out.println("------------------------------------");
    }
}