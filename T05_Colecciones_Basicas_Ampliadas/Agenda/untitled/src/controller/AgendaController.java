package controller;

import model.AgendaModel;
import model.Persona;
import view.AgendaView;

public class AgendaController {

    private AgendaModel model;
    private AgendaView view;

    public AgendaController(AgendaModel model, AgendaView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        int opcion;

        do {
            view.mostrarMenu();
            opcion = view.leerOpcion();

            switch (opcion) {
                case 1:
                    Persona p = view.leerPersona();
                    if (model.agregarPersona(p)) {
                        view.mostrarMensaje("Persona agregada correctamente.");
                    } else {
                        view.mostrarMensaje("Agenda llena.");
                    }
                    break;

                case 2:
                    Persona encontrada = model.buscarPorDni(view.leerDni());
                    if (encontrada != null) {
                        view.mostrarMensaje("Persona encontrada:");
                        view.mostrarPersona(encontrada);
                    } else {
                        view.mostrarMensaje("No se encontró la persona.");
                    }
                    break;

                case 3:
                    if (model.borrarPorDni(view.leerDni())) {
                        view.mostrarMensaje("Persona eliminada correctamente.");
                    } else {
                        view.mostrarMensaje("No se encontró la persona.");
                    }
                    break;

                case 4:
                    if (model.estaVacia()) {
                        view.mostrarMensaje("No hay personas en la agenda.");
                    } else {
                        view.mostrarLista(model.listar());
                    }
                    break;

                case 5:
                    view.mostrarMensaje("Saliendo...");
                    break;

                default:
                    view.mostrarMensaje("Opción incorrecta.");
            }

        } while (opcion != 5);
    }
}
