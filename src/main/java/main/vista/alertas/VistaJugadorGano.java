package main.vista.alertas;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.modelo.juego.Jugador;

import java.io.File;

public class VistaJugadorGano extends Alert {

    public VistaJugadorGano(Jugador jugador) {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Victoria!");
        this.setContentText("Enhorabuena ".concat(jugador.nombre()).concat(", has ganado!"));
        Image image = new Image("file:src/recursos/img/hasGanadoLaPartida.jpg",200,200,true,true);
        ImageView imageView = new ImageView(image);
        this.setGraphic(imageView);
        Media media = new Media(new File("src/recursos/sonidos/AgeofEmpires2Maintheme-8 bit.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        this.showAndWait();
    }
}
