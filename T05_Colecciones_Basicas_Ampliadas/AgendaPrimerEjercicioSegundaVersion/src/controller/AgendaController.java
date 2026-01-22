package controller;

import model.Persona;
import java.util.ArrayList;

public class AgendaController {

    private ArrayList<Persona> personas;

    public AgendaController() {
        personas = new ArrayList<>();
    }

    public boolean agregarPersona(Persona persona) {
        personas.add(persona);
        return true;
    }

    public Persona buscarPersona(String dni) {
        for (Persona p : personas) {
            if (p.getDni().equalsIgnoreCase(dni)) {
                return p;
            }
        }
        return null;
    }

    public boolean borrarPersona(String dni) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getDni().equalsIgnoreCase(dni)) {
                personas.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Persona> listarPersonas() {
        return personas;
    }

    public boolean estaVacia() {
        return personas.isEmpty();
    }
}
