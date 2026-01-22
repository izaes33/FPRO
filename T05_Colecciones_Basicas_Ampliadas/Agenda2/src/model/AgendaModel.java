package model;

public class AgendaModel {

    private Contacto[] contactos;
    private int total;

    public AgendaModel(int capacidad) {
        contactos = new Contacto[capacidad];
        total = 0;
    }

    public boolean existeEmail(String email) {
        for (int i = 0; i < total; i++) {
            if (contactos[i].getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarContacto(Contacto c) {
        if (total >= contactos.length) return false;
        if (existeEmail(c.getEmail())) return false;

        contactos[total++] = c;
        return true;
    }

    public Contacto buscarPorDni(String dni) {
        for (int i = 0; i < total; i++) {
            if (contactos[i].getDni().equalsIgnoreCase(dni)) {
                return contactos[i];
            }
        }
        return null;
    }

    public boolean borrarPorDni(String dni) {
        for (int i = 0; i < total; i++) {
            if (contactos[i].getDni().equalsIgnoreCase(dni)) {
                for (int j = i; j < total - 1; j++) {
                    contactos[j] = contactos[j + 1];
                }
                total--;
                return true;
            }
        }
        return false;
    }

    public Contacto[] listar() {
        Contacto[] resultado = new Contacto[total];
        for (int i = 0; i < total; i++) {
            resultado[i] = contactos[i];
        }
        return resultado;
    }

    public boolean estaVacia() {
        return total == 0;
    }
}
