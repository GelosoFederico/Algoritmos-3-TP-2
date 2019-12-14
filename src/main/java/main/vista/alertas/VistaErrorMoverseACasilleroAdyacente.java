package main.vista.alertas;

import javafx.scene.control.Alert;

public class VistaErrorMoverseACasilleroAdyacente extends Alert{

    public VistaErrorMoverseACasilleroAdyacente(){
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Casillero no adyacente");
        this.setContentText("Las unidades solo pueden moverse a casilleros adyacentes");
        this.showAndWait();
    }

}
