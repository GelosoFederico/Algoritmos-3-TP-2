package Main;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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
       botonDeInicio.setText("Inicio del juego");

     //  Scene scene = new Scene(botonDeInicio);

        GridPane grid = new GridPane();

        for(int i=0; i< 20; i++) {
            for (int j = 0; j < 20; j++){
                grid.add(new Button("Critian"), i, j);
            }
        }

        Scene scene = new Scene(grid);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}