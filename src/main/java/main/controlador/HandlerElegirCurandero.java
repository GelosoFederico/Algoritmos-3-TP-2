package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.unidad.Curandero;


public class HandlerElegirCurandero implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        HandlerColocarUnidad.setUnidadElegida(new Curandero());
    }
}
