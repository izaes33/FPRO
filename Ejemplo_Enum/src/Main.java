public class Main {
    public static void main(String[] args) {
        NivelPrioridad prioridadTarea = NivelPrioridad.ALTA;

        System.out.println("El nivel de prioridad es: " + prioridadTarea);
        System.out.println("El valor numérico es: " + prioridadTarea.getValor());

        // Recorrer todas las constantes del enum
        for (NivelPrioridad p : NivelPrioridad.values()) {
            System.out.println("Constante: " + p + ", Valor: " + p.getValor());
        }
    }
}