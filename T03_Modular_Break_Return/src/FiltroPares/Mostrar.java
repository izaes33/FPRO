package FiltroPares;

public class Mostrar {

    public void imprimirPares(int[] numeros) {
        // Método público que delega el trabajo
        mostrarPares(numeros);
    }

    private void mostrarPares(int[] numeros) {
        boolean primero = true;

        for (int num : numeros) {

            if (num % 2 != 0) {
                continue; // saltar impares
            }

            if (!primero) {
                System.out.print(", ");
            }

            System.out.print(num);
            primero = false;
        }

        System.out.println();
    }
}