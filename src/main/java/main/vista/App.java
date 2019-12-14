package main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.controlador.HandlerIniciarJuego;
import main.controlador.sonido.HandlerSonido;

import java.io.File;


/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {

        StackPane root =  new StackPane();
        Button buttonInicio = new Button();
        buttonInicio.setText("Iniciar juego");
        buttonInicio.setOnAction(new HandlerIniciarJuego(stage));

        Image imagen = new Image("file:src/recursos/img/imagenInicio.jpg",500,300,true,true);
        final ImageView imagenVista = new ImageView(imagen);

        root.getChildren().addAll(imagenVista, buttonInicio);


      //  Media media = new Media(new File("src/recursos/sonidos/8-BitSeinfeldTheme.mp3").toURI().toString());
        Media media = new Media(new File("src/recursos/sonidos/8-BitTheOffice(US)Theme.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();


        Scene scene = new Scene(root, 500, 500);

        stage.setTitle("AlgoChess");
        stage.setScene(scene);
        stage.show();
    }
/*
    public static void musicaInicio(File file){
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

    }

*/
    public static void main(String[] args) {
        launch();
    }

}