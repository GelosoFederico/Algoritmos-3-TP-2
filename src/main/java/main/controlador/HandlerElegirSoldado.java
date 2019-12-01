package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.unidad.Soldado;


public class HandlerElegirSoldado implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        HandlerColocarUnidad.setUnidadElegida(new Soldado());
    }
}
