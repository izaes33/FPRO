package Ej08;

public class CocheController {
    private Coche modelo;
    private CocheView vista;

    public CocheController(Coche modelo, CocheView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void viajar(double km) {
        vista.mostrarMensaje("🚀 Iniciando viaje de " + km + " km");

        boolean puedoViajar = modelo.conducir(km);

        if (!puedoViajar) {
            vista.mostrarMensaje("❌ ERROR: No hay suficiente combustible");
        } else {
            vista.mostrarMensaje("✅ Viaje completado");

            System.out.println("──────── RESULTADO DEL VIAJE ────────");
            System.out.printf("⛽ Combustible restante : %.2f L%n", modelo.getCombustible());
            System.out.printf("🛣️ Autonomía restante  : %.2f km%n", modelo.calcularAutonomia());
            System.out.printf("🔧 Km hasta revisión   : %.2f km%n", modelo.kmHastaRevision());
            System.out.println("────────────────────────────────────\n");
        }
    }

    public void irAGasolinera(double litros) {
        vista.mostrarMensaje("⛽ Intentando repostar " + litros + " L");

        double repostados = modelo.repostar(litros);

        System.out.println("──────── REPOSTAJE ────────");
        System.out.printf("✔️ Litros añadidos : %.2f L%n", repostados);
        System.out.printf("⛽ Nivel depósito : %.2f / 60 L%n", modelo.getCombustible());
        System.out.println("───────────────────────────\n");
    }

    public void actualizarCuadroMandos() {
        vista.mostrarInfo(
                modelo.getMarca(),
                modelo.getModelo(),
                modelo.getAnio(),
                modelo.getKilometraje(),
                modelo.getCombustible(),
                modelo.calcularAntiguedad(),
                modelo.necesitaMantenimiento()
        );
    }
}