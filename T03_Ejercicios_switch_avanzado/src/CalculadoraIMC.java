/***Objetivo:** Crear un programa que calcule y clasifique el
 Índice de Masa Corporal (IMC).
 **Requisitos:**
 1. Declara variables `double peso` (en kg) y `double altura` (en metros).
 2. Calcula el IMC: `peso / (altura * altura)`.
 3. Usa `switch(true)` para clasificar: Bajo peso (<18.5), Normal (18.5-24.9), Sobrepeso (25-29.9), Obesidad (>=30).
 4. Muestra el IMC calculado y la clasificación correspondiente. */

public class CalculadoraIMC {

    public void calcula(double peso, double altura_enMetros) {

        double imc = peso / (altura_enMetros * altura_enMetros);
        String tipoImc = tipoImc(imc);   // aquí se llama al método
        String imcTipo;

        switch (tipoImc) {

            case "bajo peso" -> {
                imcTipo = "Bajo peso";
                System.out.printf("Tu IMC es de: %.2f, lo que corresponde a %s%n", imc, imcTipo);
            }

            case "peso adecuado" -> {
                imcTipo = "Peso adecuado";
                System.out.printf("Tu IMC es de: %.2f lo que corresponde a %s%n", imc, imcTipo);
            }

            case "sobrepeso" -> {
                imcTipo = "Sobrepeso";
                System.out.printf("Tu IMC es de: %.2f lo que corresponde a %s%n", imc, imcTipo);
            }

            case "obesidad" -> {
                imcTipo = "Obesidad";
                System.out.printf("Tu IMC es de: %.2f lo que corresponde a %s%n", imc, imcTipo);
            }

            default -> {
                System.out.println("IMC fuera de rango.");
            }
        }
    }

    public String tipoImc(double imc) {

        if (imc < 18.5)
            return "bajo peso";

        if (imc <= 24.9)
            return "peso adecuado";

        if (imc <= 29.9)
            return "sobrepeso";

        return "obesidad";
    }
}