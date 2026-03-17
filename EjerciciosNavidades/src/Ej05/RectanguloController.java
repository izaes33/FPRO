package Ej05;

public class RectanguloController { // El "Cerebro" que conecta datos y pantalla
    private Rectangulo modelo; // Referencia al modelo
    private RectanguloView vista; // Referencia a la vista

    public RectanguloController(Rectangulo modelo, RectanguloView vista) {
        this.modelo = modelo; // Inyectamos el modelo
        this.vista = vista;   // Inyectamos la vista
    }

    // Método para sincronizar los datos del modelo con la salida visual
    public void actualizarVista() {
        // Obtenemos todos los cálculos necesarios del modelo
        double b = modelo.getBase();
        double h = modelo.getAltura();
        double area = modelo.calcularArea();
        double per = modelo.calcularPerimetro();
        boolean cuadrado = modelo.esCuadrado();

        // Enviamos los datos procesados a la vista
        vista.mostrarInfo(b, h, area, per, cuadrado);
    }

    // Método para ejecutar la acción de escalado
    public void escalarRectangulo(double factor) {
        vista.mensajeEscalado(factor); // Notificamos a la interfaz
        modelo.escalar(factor);        // Modificamos el modelo
        actualizarVista();             // Refrescamos la vista con los nuevos datos
    }
}