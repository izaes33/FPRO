import java.util.Scanner;

public class EjercicioNumerado {

    /*Hágase una aplicación que permita introducir el número de bebidas y bocadillos
comprados (valores entre 0 y 20).
Además se podrá introducir el precio de cada bebida (valor entre 0.00 € y 3.00 €)
y de cada bocadillo (valor entre 0.00 € y 5.00€).
También se podrá introducir el número de alumnos que realizaron la compra
(valor entre 0 y 10).
Se mostrará el total de la compra (con el subtotal de las
bebidas y de los bocadillos) y la cantidad que debe pagar cada alumno
redondeada a 2 decimales. CosteBar)

1-> pedir cosas por teclado
2-> guardar cosas en variables
3-> realizar cálculos
4-> mostrar información*/

    public void ejercicio01() { //Calculadora de salario con condiciones
        Scanner lectorTeclado = new Scanner(System.in);
// 1-> pedir cosas por teclado
// 2-> guardar cosas en variables
        System.out.print("Número de bebidas (entre 0 y 20): ");
        int inputBebidas = lectorTeclado.nextInt();
        int bebidas = Math.min(inputBebidas, 20);
        System.out.print("Número de bocadillos (entre 0 y 20): ");
        int inputBocatas = lectorTeclado.nextInt();
        int bocatas = Math.min(inputBocatas, 20);
        System.out.print("Precio de cada bebida (entre 0,00 y 3,00€): ");
        double inputPrecioBebida = lectorTeclado.nextDouble();
        double precioBebida = Math.min(inputPrecioBebida, 3);
        System.out.print(" Precio de cada bocadillo (entre 0,00 y 5,00€): ");
        double inputPrecioBocadillo = lectorTeclado.nextDouble();
        double precioBocadillo = Math.min(inputPrecioBocadillo, 5);

        System.out.print("¿Cuantas personas han realizado la compra? (entre 1 y 10): ");
        int inputNumeroPersonas = lectorTeclado.nextInt();
        int numeroPersonas = Math.min(inputNumeroPersonas, 10);

//3-> realizar cálculos
        double costeBocatas = bocatas*precioBocadillo;
        double costeBebidas = bebidas*precioBebida;
        double costeTotal = costeBocatas+costeBebidas;
        double precioPersona = costeTotal/numeroPersonas;
//4-> mostrar información
        System.out.println("Subtotal bebidas: " +costeBebidas+ "€");
        System.out.println("Subtotal bocatas: " +costeBocatas+ "€");
        System.out.println("Total de la compra: " +costeTotal+ "€");
        System.out.println("Cantidad a pagar por persona: " +precioPersona+ "€");

        lectorTeclado.close();
    }
}
