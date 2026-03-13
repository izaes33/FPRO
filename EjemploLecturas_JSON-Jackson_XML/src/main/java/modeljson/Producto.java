package modeljson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Data // De nuevo, Lombok nos genera los Getters y Setters automáticamente.
public class Producto {

    // Jackson cogerá cada propiedad del JSON (ej: "id": 1) y la guardará aquí.
    // Los nombres DEBEN coincidir con las claves del JSON.
    private long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private double discountPercentage;
    private double rating;
    private long stock;

    // "tags" en el JSON es un array de textos (ej: ["smartphone", "apple"]).
    // En Java lo traducimos como una Lista de Strings.
    private List<String> tags;

    private String brand;
    private String sku;
    private long weight;

    // "dimensions" en el JSON no es un texto ni un número, es OTRO objeto con llaves {}.
    // Por eso creamos una clase dedicada (Dimensions) para mapear su contenido.
    private Dimensions dimensions;

    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;

    // "reviews" es un array de objetos. Por tanto, es una Lista de la clase Review.
    private List<Review> reviews;

    private String returnPolicy;
    private long minimumOrderQuantity;
    private Meta meta;
    private List<String> images;
    private String thumbnail;

    // Método propio para imprimir los datos básicos por consola de forma bonita.
    public void mostrarDatos(){
        // %d significa "insertar un número entero" (el id)
        // %.2f significa "insertar un número decimal con 2 decimales" (el price)
        System.out.printf("id = %d, precio = %.2f%n", id, price);
    }

    // --- CLASES INTERNAS ---
    // Son estáticas (static) porque pertenecen a la estructura de Producto,
    // pero no necesitan que un Producto exista para definirse. Ayudan a organizar el código.

    @Data
    public static class Dimensions {
        private double width;
        private double height;
        private double depth;
    }

    @Data
    public static class Meta {
        // @JsonIgnore le da una orden directa a Jackson:
        // "Cuando leas el JSON y veas la clave 'createdAt', IGNÓRALA, no intentes mapearla".
        // Esto se hace a menudo con las fechas porque su formato en texto a veces da problemas
        // al pasarlo a OffsetDateTime si Jackson no está configurado para ese formato específico.
        @JsonIgnore
        private OffsetDateTime createdAt;
        @JsonIgnore
        private OffsetDateTime updatedAt;
        private String barcode;
        private String qrCode;
    }

    @Data
    public static class Review {
        private long rating;
        private String comment;
        @JsonIgnore // Ignoramos la fecha de la review por precaución, igual que arriba.
        private OffsetDateTime date;
        private String reviewerName;
        private String reviewerEmail;
    }
}