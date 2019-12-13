package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerPasarTurno;


public class BotonPasarTurno extends Button {
    public BotonPasarTurno() {
        super();
        this.setText("Pasar turno");
        this.setMinHeight(24);
        this.setOnAction(new HandlerPasarTurno());
    }
}