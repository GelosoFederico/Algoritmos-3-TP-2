package main.vista.alertas;

import javafx.scene.control.Alert;

public class VistaErrorUnidadNoLePerteneceAJugador extends Alert {

    public VistaErrorUnidadNoLePerteneceAJugador() {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Unidad no pertenece");
        this.setContentText("No se pueden mover unidades o atacar con unidades que no te pertenecen");
        this.showAndWait();
    }

}
