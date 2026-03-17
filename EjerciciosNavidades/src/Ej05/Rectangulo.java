package Ej05;

public class Rectangulo { // Clase que representa la figura geométrica
    private double base; // Atributo para la longitud horizontal
    private double altura; // Atributo para la longitud vertical

    // Constructor: Inicializa el objeto validando que las dimensiones sean lógicas
    public Rectangulo(double base, double altura) {
        // Usamos los setters internos para aprovechar la validación ya escrita
        setBase(base);
        setAltura(altura);
    }

    // Getters: Retornan el valor actual de los atributos
    public double getBase() { return base; }
    public double getAltura() { return altura; }

    // Setters con Validación: Evitan que el objeto tenga dimensiones imposibles (negativas)
    public void setBase(double base) {
        if (base > 0) { // Solo asignamos si el valor es positivo
            this.base = base;
        } else {
            this.base = 1.0; // Valor por defecto en caso de error para evitar cálculos nulos
        }
    }

    public void setAltura(double altura) {
        if (altura > 0) { // Validación de seguridad
            this.altura = altura;
        } else {
            this.altura = 1.0; // Valor por defecto
        }
    }

    // Lógica de Negocio: Cálculo del Área (Base * Altura)
    public double calcularArea() {
        return base * altura; // Fórmula estándar del área
    }

    // Lógica de Negocio: Cálculo del Perímetro (Suma de todos los lados)
    public double calcularPerimetro() {
        return 2 * (base + altura); // Perímetro = 2b + 2h
    }

    // Lógica de Negocio: Comprobar si es un cuadrado
    public boolean esCuadrado() {
        return base == altura; // Es cuadrado si ambos lados miden lo mismo
    }

    // Lógica de Negocio: Cambio de tamaño proporcional
    public void escalar(double factor) {
        if (factor > 0) { // Solo escalamos si el factor es positivo
            this.base *= factor; // Multiplicamos base por el factor
            this.altura *= factor; // Multiplicamos altura por el factor
        }
    }
}