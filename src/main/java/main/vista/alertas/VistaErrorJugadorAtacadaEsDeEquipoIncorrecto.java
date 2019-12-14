package main.vista.alertas;

import javafx.scene.control.Alert;

public class VistaErrorJugadorAtacadaEsDeEquipoIncorrecto extends Alert {
    public VistaErrorJugadorAtacadaEsDeEquipoIncorrecto() {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Equipo incorrecto");
        this.setContentText("Esta unidad no puede atacar unidades de ese equipo");
        this.showAndWait();
    }
}
