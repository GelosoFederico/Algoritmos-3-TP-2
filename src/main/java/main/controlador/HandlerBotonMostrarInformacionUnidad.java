package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.vista.GridPaneTablero;

public class HandlerBotonMostrarInformacionUnidad implements EventHandler<ActionEvent> {


    private final GridPaneTablero tablero;

    public HandlerBotonMostrarInformacionUnidad(GridPaneTablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.tablero.setModoMostrarInfoUnidades();
    }
}
