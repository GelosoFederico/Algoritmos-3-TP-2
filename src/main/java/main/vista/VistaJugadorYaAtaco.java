package main.vista;

import javafx.scene.control.Alert;

public class VistaJugadorYaAtaco extends Alert {
    public VistaJugadorYaAtaco() {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Ya atacó");
        this.setContentText("Ya atacaste este turno");
        this.showAndWait();
    }

}
