import ConversorModeda.ConversorMoneda;
import MenuRestaurante.MenuRestaurante;
import EstadoPedido.EstadoPedido;

public class Main {

    public static void main(String[] args) {

        SistemaCalificaciones sistemaCalificaciones = new SistemaCalificaciones();
        sistemaCalificaciones.convertirEnLetra(10);

        ConversorMoneda conversorMoneda = new ConversorMoneda();
        conversorMoneda.convertirA("DOLAR" , 8000);

        ClasificadorTemperatura clasificadorTemperatura = new ClasificadorTemperatura();
        clasificadorTemperatura.clasifica(27.5);

        MenuRestaurante menuRestaurante = new MenuRestaurante();
        menuRestaurante.iniciarSistema();

        CalculadoraSimple calculadoraSimple = new CalculadoraSimple();
        calculadoraSimple.ejecutar();

        GeneradorSaludos generadorSaludos = new GeneradorSaludos();
        generadorSaludos.saludo();

        NivelesDeJuego nivelesDeJuego = new NivelesDeJuego();
        nivelesDeJuego.lanzaMensaje(800);

        TipoArchivo tipoArchivo = new TipoArchivo();
        tipoArchivo.analizador("mp3");

        CalculadoraIMC calculadoraIMC = new CalculadoraIMC();
        calculadoraIMC.calcula(102, 1.70);

        EstadoPedido estadoPedido = new EstadoPedido();
        estadoPedido.obtenerEstadoActual();

    }
}
