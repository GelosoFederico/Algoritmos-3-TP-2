package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.juego.Juego;

public class HandlerPasarTurno implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().terminarTurno();
        HandlerTurnos.pasarTurno();
    }
}
