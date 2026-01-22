package controller;

import model.AgendaModel;
import model.Contacto;
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
                    Contacto c = view.leerContacto();
                    if (model.existeEmail(c.getEmail())) {
                        view.mostrarMensaje("Error: ya existe un contacto con ese email.");
                    } else if (model.agregarContacto(c)) {
                        view.mostrarMensaje("Contacto agregado correctamente.");
                    } else {
                        view.mostrarMensaje("No se pudo agregar el contacto.");
                    }
                    break;

                case 2:
                    Contacto encontrado = model.buscarPorDni(view.leerDni());
                    if (encontrado != null) {
                        view.mostrarMensaje("Contacto encontrado:");
                        view.mostrarContacto(encontrado);
                    } else {
                        view.mostrarMensaje("No se encontró el contacto.");
                    }
                    break;

                case 3:
                    if (model.borrarPorDni(view.leerDni())) {
                        view.mostrarMensaje("Contacto eliminado correctamente.");
                    } else {
                        view.mostrarMensaje("No se encontró el contacto.");
                    }
                    break;

                case 4:
                    if (model.estaVacia()) {
                        view.mostrarMensaje("No hay contactos en la agenda.");
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
