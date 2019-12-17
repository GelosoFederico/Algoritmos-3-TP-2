package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerAtacar;

public class BotonAtacar extends Button {
    public BotonAtacar(GridPaneTablero tablero) {
        super();
        this.setText("Atacar");
        this.setMinHeight(24);
        this.setOnAction(new HandlerAtacar(tablero,this));
    }
}
