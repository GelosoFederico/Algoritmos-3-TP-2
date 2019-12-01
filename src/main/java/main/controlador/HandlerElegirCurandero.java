package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.unidad.Curandero;


public class HandlerElegirCurandero implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        HandlerTablero.setUnidadElegida(new Curandero());
        HandlerSonidos.getInstance().reproducirSonido("Crear Curandero");
    }
}
