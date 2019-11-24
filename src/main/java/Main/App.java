package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    // --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
    // TODO sin esto en la opcion de la VM no anda
    // Preguntar
    @Override
    public void start(Stage stage) {
       Button botonDeInicio =  new Button();
       botonDeInicio.setText("Enviar");
       Scene scene = new Scene(botonDeInicio);
       stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}