package model;

public class AgendaModel {

    private Persona[] personas;
    private int total;

    public AgendaModel(int capacidad) {
        personas = new Persona[capacidad];
        total = 0;
    }

    public boolean agregarPersona(Persona p) {
        if (total >= personas.length) return false;
        personas[total++] = p;
        return true;
    }

    public Persona buscarPorDni(String dni) {
        for (int i = 0; i < total; i++) {
            if (personas[i].getDni().equalsIgnoreCase(dni)) {
                return personas[i];
            }
        }
        return null;
    }

    public boolean borrarPorDni(String dni) {
        for (int i = 0; i < total; i++) {
            if (personas[i].getDni().equalsIgnoreCase(dni)) {
                for (int j = i; j < total - 1; j++) {
                    personas[j] = personas[j + 1];
                }
                total--;
                return true;
            }
        }
        return false;
    }

    public Persona[] listar() {
        Persona[] resultado = new Persona[total];
        for (int i = 0; i < total; i++) {
            resultado[i] = personas[i];
        }
        return resultado;
    }

    public boolean estaVacia() {
        return total == 0;
    }
}
