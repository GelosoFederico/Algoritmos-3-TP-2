package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.unidad.Catapulta;


public class HandlerElegirCatapulta implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        HandlerColocarUnidad.setUnidadElegida(new Catapulta());
    }
}
