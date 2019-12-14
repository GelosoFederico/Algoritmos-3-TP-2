package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.vista.BotonAtacar;
import main.vista.GridPaneTablero;

public class HandlerAtacar implements EventHandler<ActionEvent> {
    private GridPaneTablero tablero;
    private BotonAtacar boton;
    public HandlerAtacar(GridPaneTablero tablero, BotonAtacar boton) {
        this.tablero = tablero;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.tablero.setModoSeleccionarAtacante();
    //    this.boton.dejarApretado();
    }
}
