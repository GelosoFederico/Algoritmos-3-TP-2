package main.vista;

import javafx.scene.control.Alert;

public class VistaErrorJugadorYaAtaco extends Alert {
    public VistaErrorJugadorYaAtaco() {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Ya atacó");
        this.setContentText("Ya atacaste este turno");
        this.showAndWait();
    }

}
