package Ej05;

public class RectanguloView { // Clase para la interfaz de usuario (Salida)
    // Método que imprime la ficha técnica del rectángulo
    public void mostrarInfo(double b, double h, double area, double per, boolean cuadrado) {
        System.out.println("======= INFO RECTÁNGULO =======");
        System.out.println("Base: " + b + " | Altura: " + h);
        System.out.println("Área: " + area); // Muestra el resultado del cálculo
        System.out.println("Perímetro: " + per); // Muestra el perímetro
        System.out.println("¿Es un cuadrado?: " + (cuadrado ? "Sí" : "No")); // Operador ternario para mejor lectura
        System.out.println("===============================\n");
    }

    // Mensaje para indicar que se está escalando la figura
    public void mensajeEscalado(double factor) {
        System.out.println(">> Escalando figura por un factor de: " + factor);
    }
}