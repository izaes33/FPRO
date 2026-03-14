package Ej01;

public class Libro {
    private String titulo; // Atributos privados para cumplir con el encapsulamiento
    private String autor;
    private int numPaginas;
    private double precio;

    public Libro() {
    }

    public Libro(String titulo, String autor, int numPaginas, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.precio = precio;
    }

    // Getters y Setters: Métodos públicos para acceder y modificar atributos privados de forma segura
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; } // Permite cambiar el título

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getNumPaginas() { return numPaginas; }
    public void setNumPaginas(int numPaginas) { this.numPaginas = numPaginas; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Lógica de negocio: Comprobar si es un libro largo
    public boolean esLibroLargo() {
        return this.numPaginas > 300; // Retorna true si supera 300, aplicando la regla del enunciado
    }

    // Lógica de negocio: Modificar el precio basado en un porcentaje
    public void aplicarDescuento(double porcentaje) {
        double descuento = precio * (porcentaje / 100);
        precio = precio - descuento;
    }
}