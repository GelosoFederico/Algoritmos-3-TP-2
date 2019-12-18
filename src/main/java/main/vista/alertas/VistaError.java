package main.vista.alertas;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.modelo.excepciones.ExcepcionEnJuego;

public class VistaError extends Alert {
    public VistaError(ExcepcionEnJuego excepcion) {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Jugada no permitida");
        this.setContentText(excepcion.mensajeDeError());
        Image image = new Image("file:src/recursos/img/youBetterWatchYourMouse.png",200,200,true,true);
        ImageView imageView = new ImageView(image);
        this.setGraphic(imageView);

        this.showAndWait();
    }
}
