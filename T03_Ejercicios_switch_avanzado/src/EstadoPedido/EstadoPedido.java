package EstadoPedido;
import java.util.Random;

public class EstadoPedido {

    // Método que devuelve un estado aleatorio y muestra su mensaje
    public Estado obtenerEstadoActual() {

        Estado[] estados = Estado.values();
        Estado estado = estados[new Random().nextInt(estados.length)];

        System.out.println("Estado actual: " + estado);

        switch (estado) {

            case PENDIENTE -> {
                System.out.println("El pedido ha sido recibido, pero todavía no ha comenzado a procesarse.");
                System.out.println("Siguiente paso: PROCESANDO.");
            }

            case PROCESANDO -> {
                System.out.println("Estamos preparando tu pedido y verificando disponibilidad.");
                System.out.println("Siguiente paso: ENVIADO.");
            }

            case ENVIADO -> {
                System.out.println("El paquete ya salió del almacén.");
                System.out.println("Siguiente paso: EN TRANSITO.");
            }

            case EN_TRANSITO -> {
                System.out.println("Tu pedido está viajando hacia tu ubicación.");
                System.out.println("Siguiente paso: ENTREGADO.");
            }

            case ENTREGADO -> {
                System.out.println("El pedido ya ha sido entregado correctamente.");
                System.out.println("Esperamos que todo haya ido bien!");
            }

            case CANCELADO -> {
                System.out.println("El pedido fue cancelado y no continuará el proceso.");
            }
        }
        return estado;
    }
}
