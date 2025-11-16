package MenuRestaurante;

public enum CategoriaPlato {
    // 1. Las constantes ahora reciben un array de Strings en el constructor
    ENTRANTE(new String[]{
            "Ensalada César",
            "Crema de calabaza",
            "Tostas de jamón ibérico"
    }),
    PRINCIPAL(new String[]{
            "Solomillo con patatas panaderas",
            "Salmón a la plancha con verduras",
            "Lasaña casera"
    }),
    POSTRE(new String[]{
            "Tarta de queso con frutos rojos",
            "Brownie de chocolate",
            "Fruta fresca"
    }),
    BEBIDA(new String[]{
            "Agua mineral",
            "Refresco de cola",
            "Cerveza artesanal"
    });

    // 2. Campo privado y final para almacenar las opciones
    private final String[] opciones;

    // 3. Constructor que recibe el array de opciones
    CategoriaPlato(String[] opciones) {
        this.opciones = opciones;
    }

    // 4. Getter para acceder a las opciones desde la clase principal
    public String[] getOpciones() {
        return opciones;
    }
}
