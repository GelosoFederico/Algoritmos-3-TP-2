package Main.Vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    // --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
    // TODO sin esto en la opcion de la VM no anda
    // Preguntar: ya se cargó el archivo de JavaFx en el proyecto.

    private static final int LONGITUD = 20;
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;

    @Override
    public void start(Stage stage) {
        //Button botonDeInicio =  new Button();
        // botonDeInicio.setText("Inicio del juego");
        //  Scene scene = new Scene(botonDeInicio);

        GridPane grid = new GridPane();

        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){
                ImageView imagenCasillero;
                grid.add(imagenCasillero = new ImageView("file:src/imagenCasillero.png"), i, j);
                imagenCasillero.setFitHeight(ALTURA_CASILLERO);
                imagenCasillero.setFitWidth(ANCHURA_CASILLERO);
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