package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerElegirCurandero;

public class BotonElegirCurandero extends Button {
    public BotonElegirCurandero() {
        super();
        this.setText("Curandero");
        this.setMinHeight(20);
        this.setOnAction(new HandlerElegirCurandero());
    }
}
