
import ConversorModeda.ConversorMoneda;

public class Main {

    public static void main(String[] args) {

        /*SistemaCalificaciones sistemaCalificaciones = new SistemaCalificaciones();
        sistemaCalificaciones.convertirEnLetra(10);*/

        ConversorMoneda conversorMoneda = new ConversorMoneda();
        conversorMoneda.convertirA("DOLAR" , 8000);
    }
}
