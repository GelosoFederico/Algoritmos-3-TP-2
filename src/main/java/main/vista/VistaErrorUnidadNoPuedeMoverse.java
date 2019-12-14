package main.vista;

import javafx.scene.control.Alert;

public class VistaErrorUnidadNoPuedeMoverse extends Alert{

    public VistaErrorUnidadNoPuedeMoverse(){
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Unidad no puede moverse");
        this.setContentText("Esa unidad no puede moverse");
        this.showAndWait();
    }

}