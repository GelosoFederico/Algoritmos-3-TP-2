package main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.controlador.HandlerIniciarJuego;


/**
 * JavaFX App
 */
public class App extends Application {
    // Preguntar: ya se cargó el archivo de JavaFx en el proyecto.
    @Override
    public void start(Stage stage) {

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