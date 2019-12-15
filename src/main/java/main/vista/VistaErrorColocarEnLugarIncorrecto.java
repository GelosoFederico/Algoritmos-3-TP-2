package main.vista;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaErrorColocarEnLugarIncorrecto extends Alert {

    public VistaErrorColocarEnLugarIncorrecto() {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Lugar no permitido");
        this.setContentText("Unidades nuevas deben colocarse de tu lado del tablero en un lugar vacío");
        Image image = new Image("file:src/recursos/img/youBetterWatchYourMouse.png",300,300,true,true);
        ImageView imageView = new ImageView(image);
        this.setGraphic(imageView);
        this.showAndWait();
    }
}
