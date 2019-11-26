package main.vista;

import Main.controlador.HandlerIniciarJuego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {
    // Preguntar: ya se cargó el archivo de JavaFx en el proyecto.
    @Override
    public void start(Stage stage) {

        VBox root = new VBox(5);
        Button buttonInicio = new Button();
        buttonInicio.setText("Iniciar");
        buttonInicio.setOnAction(new HandlerIniciarJuego(stage));
        root.getChildren().add(buttonInicio);
        Scene scene = new Scene(root);
        stage.setTitle("AlgoChess");
        stage.setScene(scene);
        stage.show();


    }




    public static void main(String[] args) {
        launch();
    }

}