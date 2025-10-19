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
        System.out.print("¿Cuantas bebidas vas a comprar?: ");
        int bebidas = lectorTeclado.nextInt();
        System.out.print("¿Cuantos bocadillos vas a comprar?: ");
        int bocatas = lectorTeclado.nextInt();
        System.out.print("¿Cuanto vale cada bebida?: ");
        double precioBebida = lectorTeclado.nextInt();
        System.out.print("¿Cuanto vale cada bocadillo?: ");
        double precioBocadillo = lectorTeclado.nextInt();
        System.out.print("¿Cuantas personas han realizado la compra?: ");
        int numeroPersonas = lectorTeclado.nextInt();
//3-> realizar cálculos
        double costeBocatas = bocatas*precioBocadillo;
        double costeBebidas = bebidas*precioBebida;
        double costeTotal = costeBocatas+costeBebidas;
        double precioPersona = costeTotal/numeroPersonas;
//4-> mostrar información
        System.out.println("El precio total de la compra es: " +costeTotal);
        System.out.println("El precio total de la los bocatas es: " +costeBocatas);
        System.out.println("El precio total de la las bebidas es: " +costeBebidas);
        System.out.println("El precio a pagar por persona es: " +precioPersona);

        lectorTeclado.close();
    }
}
