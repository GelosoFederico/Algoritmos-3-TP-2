package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.juego.Juego;

public class HandlerTerminarDeColocar implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().terminarDeColocarParaJugador();
        HandlerTurnos.pasarTurno();
    }
}
