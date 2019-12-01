package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.unidad.Jinete;


public class HandlerElegirJinete implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        HandlerTablero.setUnidadElegida(new Jinete());
        HandlerSonidos.getInstance().reproducirSonido("Crear Jinete");
    }
}
