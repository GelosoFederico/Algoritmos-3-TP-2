package main.vista;

import javafx.scene.control.Alert;

public class VistaJugadorAtacadaEsDeEquipoIncorrecto extends Alert {
    public VistaJugadorAtacadaEsDeEquipoIncorrecto() {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Equipo incorrecto");
        this.setContentText("Esta unidad no puede atacar unidades de ese equipo");
        this.showAndWait();
    }
}
