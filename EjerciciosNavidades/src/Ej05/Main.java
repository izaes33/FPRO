package Ej05;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos la vista común
        RectanguloView vista = new RectanguloView();

        // 2. Creamos un Rectángulo (Modelo 1)
        Rectangulo r1 = new Rectangulo(5.0, 10.0);
        RectanguloController control1 = new RectanguloController(r1, vista);

        // 3. Creamos un Cuadrado (Modelo 2)
        Rectangulo r2 = new Rectangulo(4.0, 4.0);
        RectanguloController control2 = new RectanguloController(r2, vista);

        // --- Pruebas ---
        System.out.println("PROBANDO RECTÁNGULO 1:");
        control1.actualizarVista();
        control1.escalarRectangulo(2.0); // Debería pasar a 10x20

        System.out.println("PROBANDO RECTÁNGULO 2 (CUADRADO):");
        control2.actualizarVista();
    }
}