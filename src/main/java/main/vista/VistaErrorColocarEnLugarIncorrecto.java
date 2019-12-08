package main.vista;

import javafx.scene.control.Alert;

public class VistaErrorColocarEnLugarIncorrecto extends Alert {

    public VistaErrorColocarEnLugarIncorrecto() {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Lugar no permitido");
        this.setContentText("Unidades nuevas deben colocarse de tu lado del tablero en un lugar vacío");
        this.showAndWait();
    }
}
