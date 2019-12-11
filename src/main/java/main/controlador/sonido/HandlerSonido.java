package main.controlador.sonido;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class HandlerSonido {
    private File archivoSonido;

    public HandlerSonido(File file){
        this.archivoSonido = file;
    }

    public void reproducirSonido(){
        Media sound = new Media(this.archivoSonido.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }
}
