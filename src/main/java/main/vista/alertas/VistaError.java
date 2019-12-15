package main.vista.alertas;

import javafx.scene.control.Alert;
import main.modelo.excepciones.ExcepcionEnJuego;

public class VistaError extends Alert {
    public VistaError(ExcepcionEnJuego excepcion) {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Jugada no permitida");
        this.setContentText(excepcion.mensajeDeError());
        this.showAndWait();
    }
}
