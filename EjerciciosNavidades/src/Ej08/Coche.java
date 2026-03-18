package Ej08;

public class Coche {
    private String marca;
    private String modelo;
    private int anio;
    private double kilometraje;
    private double combustible;

    public Coche() {}

    public Coche(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = 0.0;
        this.combustible = 50.0;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public double getKilometraje() { return kilometraje; }
    public double getCombustible() { return combustible; }

    // Conducir (1L cada 15km)
    public boolean conducir(double km) {
        double consumoNecesario = km / 15.0;

        if (this.combustible >= consumoNecesario) {
            this.kilometraje += km;
            this.combustible -= consumoNecesario;
            return true;
        }
        return false;
    }

    // Repostar con límite 60L
    public double repostar(double litros) {
        double litrosRepostados = 0;

        if (litros > 0) {
            double espacioDisponible = 60.0 - this.combustible;

            if (litros > espacioDisponible) {
                litrosRepostados = espacioDisponible;
                this.combustible = 60.0;
            } else {
                litrosRepostados = litros;
                this.combustible += litros;
            }
        }

        return litrosRepostados;
    }

    public int calcularAntiguedad() {
        return 2025 - this.anio;
    }

    public boolean necesitaMantenimiento() {
        return this.kilometraje > 10000;
    }

    // Autonomía restante
    public double calcularAutonomia() {
        return this.combustible * 15;
    }

    // Km hasta próxima revisión
    public double kmHastaRevision() {
        return 10000 - (this.kilometraje % 10000);
    }
}