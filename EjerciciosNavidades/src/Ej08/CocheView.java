package Ej08;

public class CocheView {

    public void mostrarMensaje(String mensaje) {
        System.out.println("➤ " + mensaje);
    }

    public void mostrarInfo(String marca, String modelo, int anio,
                            double km, double combustible,
                            int antiguedad, boolean mantenimiento) {

        System.out.println("\n══════════════════════════════════════");
        System.out.println("            🚗 VEHÍCULO");
        System.out.println("══════════════════════════════════════");

        System.out.println("📌 Marca/Modelo : " + marca + " " + modelo);
        System.out.println("📅 Año          : " + anio + " (" + antiguedad + " años)");

        System.out.println("──────────────────────────────────────");

        System.out.printf("🛣️ Kilómetros   : %.2f km%n", km);
        System.out.printf("⛽ Combustible  : %.2f L%n", combustible);

        System.out.println("──────────────────────────────────────");

        if (mantenimiento) {
            System.out.println("⚠️  Estado      : NECESITA MANTENIMIENTO");
        } else {
            System.out.println("✅ Estado       : Todo correcto");
        }

        System.out.println("══════════════════════════════════════\n");
    }
}