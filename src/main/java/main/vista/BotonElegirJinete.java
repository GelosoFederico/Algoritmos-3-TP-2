package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerElegirJinete;

public class BotonElegirJinete extends Button {
    public BotonElegirJinete() {
        super();
        this.setText("Jinete");
        this.setMinHeight(24);
        this.setOnAction(new HandlerElegirJinete());
    }
}
