package Ej06;

public class CarteleraView { // Clase para la representación visual de las películas
    // Método para imprimir la ficha completa con formato legible
    public void imprimirFicha(String t, String d, String dur, int a, double c, boolean clasica) {
        System.out.println("🎬 TÍTULO: " + t + (clasica ? " [CLÁSICO]" : "")); // Añade etiqueta si es clásica
        System.out.println("   Director: " + d + " | Año: " + a);
        System.out.println("   Duración: " + dur + " | Calificación: " + c + "/10");
        System.out.println("--------------------------------------------------");
    }

    public void mostrarCabeceraRecomendados() {
        System.out.println("\n⭐ PELÍCULAS RECOMENDADAS (Nota >= 7):");
        System.out.println("==========================================");
    }
}