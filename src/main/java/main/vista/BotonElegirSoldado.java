package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerElegirSoldado;

public class BotonElegirSoldado extends Button {
    public BotonElegirSoldado() {
        super();
        this.setText("Soldado");
        this.setMinHeight(24);
        this.setOnAction(new HandlerElegirSoldado());
    }
}
