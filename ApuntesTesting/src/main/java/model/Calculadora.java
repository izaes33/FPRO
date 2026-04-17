package model;

public class Calculadora {

    public int sumar(int a, int b){
        return  a+b;
    }

    public int resta(int a, int b){
        return  a-b;
    }
    public int multi(int a, int b){
        return  a*b;
    }

    public double division(int a, int b){
        if (b == 0){
            throw new IllegalArgumentException("El segundo operando no es valido");
        }/* Recordatorio: si lanzamos la excepción (throw) dentro de un condicional para tratar el fallo, el método
            no se ejecuta completamente.
            En cambio, si declaramos la excepción con throws en la firma del método, indicamos que puede lanzarla y que
            deberá ser gestionada en la llamada.
            En cualquier caso, la excepción debe capturarse en el punto donde se invoque el método.
            Es decir:
            -throw dentro del método → corta la ejecución en ese punto.
            -throws en la firma → avisa de que el método puede lanzar la excepción.
            -En ambos casos → la excepción debe tratarse (try-catch) en la llamada (si no es runtime).*/
        return  a/b;
    }
}
