package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerElegirCatapulta;

public class BotonElegirCatapulta extends Button {
    public BotonElegirCatapulta() {
        super();
        this.setText("Catapulta");
        this.setMinHeight(20);
        this.setOnAction(new HandlerElegirCatapulta());
    }
}
