package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerMover;

public class BotonMover extends Button {
    public BotonMover(GridPaneTablero tablero) {
        super();
        this.setText("Mover");
        this.setMinHeight(24);
        this.setOnAction(new HandlerMover(tablero,this));
    }

    public void dejarApretado() {
        this.setPressed(true);
    }
}
