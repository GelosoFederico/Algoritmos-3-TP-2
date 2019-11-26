package main.vista;

import main.controlador.HandlerIniciarJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;


/**
 * JavaFX App
 */
public class App extends Application {
    // Preguntar: ya se cargó el archivo de JavaFx en el proyecto.
    @Override
    public void start(Stage stage) {


       // VBox root = new VBox(5);
        StackPane root =  new StackPane();
        Button buttonInicio = new Button();
        buttonInicio.setText("Iniciar juego");
        buttonInicio.setOnAction(new HandlerIniciarJuego(stage));

        root.getChildren().add(buttonInicio);


        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("AlgoChess");
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }

}