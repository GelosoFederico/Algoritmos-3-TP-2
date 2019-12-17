package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.vista.BotonMover;
import main.vista.GridPaneTablero;

public class HandlerMover implements EventHandler<ActionEvent> {
    private GridPaneTablero tablero;
    private BotonMover boton;
    public HandlerMover(GridPaneTablero tablero, BotonMover boton) {
        this.tablero = tablero;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.tablero.setModoSeleccionarMovible();
        this.boton.dejarApretado();
    }
}
