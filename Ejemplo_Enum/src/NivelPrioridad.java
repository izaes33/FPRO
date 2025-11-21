public enum NivelPrioridad {
    BAJA(1),
    MEDIA(2),
    ALTA(3),
    URGENTE(4);

    private final int valor;

    // Constructor privado para asignar valores a las constantes
    private NivelPrioridad(int valor) {
        this.valor = valor;
    }

    // Método para obtener el valor asociado
    public int getValor() {
        return valor;
    }
}
