package main.vista.alertas;

import javafx.scene.control.Alert;

public class VistaErrorUnidadFueraDeRango extends Alert {

    public VistaErrorUnidadFueraDeRango(){
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Unidad fuera de rango");
        this.setContentText("Esa unidad esta fuera del rango en que esta unidad puede atacar");
        this.showAndWait();
    }

}
