package BuscaNumeroEnArray;
import java.util.Random;

public class IniciaBusqueda {

    public int iniciarBusqueda(int[] numeros, int objetivo) {
        // Método público que delega el trabajo al privado
        return buscarNumero(numeros, objetivo);
    }

    private int buscarNumero(int[] numeros, int objetivo) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }
}
