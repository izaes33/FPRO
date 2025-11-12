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

    public void ejercicio01() {
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

    /* Permítase introducir el valor con IVA de una compra con dos decimales (la
compra no puede ser superior a 500€ ni inferior a 0€ y el valor del IVA de dicha
compra (valor entero entre 0 y 25%.¿Cuánto costó la compra sin IVA?¿Cuánto fue
el IVA? Muéstrese los resultados redondeados a dos decimales. Compra)

1-> pedir cosas por teclado
2-> guardar cosas en variables
3-> realizar cálculos
4-> mostrar información */

    public void ejercicio02() {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Valor de la compra (entre 0.00 y 500.00): ");
        double inputPrecioVenta = lectorTeclado.nextDouble();
        double precioVenta = Math.min(inputPrecioVenta, 500);
        System.out.print(" IVA (entre 0 y 25%): ");
        int inputTasa = lectorTeclado.nextInt();
        int tasa = Math.min(inputTasa, 25);
        double costeTasa = (precioVenta/100)*tasa;
        double precioSinIva = precioVenta-costeTasa;
        System.out.printf("Precio sin IVA: %.2f€\n",precioSinIva);
        System.out.printf("Importe IVA: %.2f€\n",costeTasa);
        // Original (Incorrecto): System.out.printf("Precio sin IVA: %.2f%n", precioSinIva + "€");
        // Corrección: Pasa solo la variable 'double' y añade el símbolo '€' al texto
        // System.out.printf("Precio sin IVA: %.2f€%n", precioSinIva);
    }

    /*Ejercicio 3
 Se introducen los 5 dígitos de un número (decenas de mil, unidades de mil,
centenas, decenas y unidades), y se obtiene el número correspondiente.
Numero)

1-> pedir cosas por teclado
2-> guardar cosas en variables
3-> realizar cálculos
4-> mostrar información */

    public void ejercicio03() {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Decenas de mil: ");
        int decenasDeMil = lectorTeclado.nextInt();
        System.out.print("Unidades de mil: ");
        int unidadesDeMil = lectorTeclado.nextInt();
        System.out.print("Centenas: ");
        int centenas = lectorTeclado.nextInt();
        System.out.print("Decenas: ");
        int decenas = lectorTeclado.nextInt();
        System.out.print("Unidades: ");
        int unidades = lectorTeclado.nextInt();
        int numeroIntroducido = (decenasDeMil * 10000) + (unidadesDeMil * 1000) + (centenas * 100) + (decenas * 10) + unidades;
        System.out.print("Numero introducido: " + numeroIntroducido);
    }

    Ejercicio 4
 /*Hágase un programa que convierta segundos en horas, minutos y segundos.
 Segundos)*/

    public void ejercicio04() {
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.print("Número de segundos: ");
        int inputSegundos = lectorTeclado.nextInt();
        int horas = inputSegundos / 3600;
        int minutos = (inputSegundos % 3600) / 60;
        int segundos = inputSegundos % 60;
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);
    }
}
