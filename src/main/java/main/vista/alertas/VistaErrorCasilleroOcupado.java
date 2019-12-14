package main.vista.alertas;

import javafx.scene.control.Alert;

public class VistaErrorCasilleroOcupado extends Alert{

    public VistaErrorCasilleroOcupado(){
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Casillero ocupado");
        this.setContentText("Ese casillero está ocupado");
        this.showAndWait();
    }

}
