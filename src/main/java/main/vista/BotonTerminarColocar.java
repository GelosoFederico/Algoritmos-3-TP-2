package main.vista;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.controlador.HandlerTerminarDeColocar;

public class BotonTerminarColocar extends Button {
    public BotonTerminarColocar(Stage stage, GridPaneTablero tablero) {
        super();
        this.setText("Terminar de colocar");
        this.setMinHeight(20);
        this.setOnAction(new HandlerTerminarDeColocar(stage, tablero));
    }
}
