package main.vista;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    // --module-path "C:\Program Files\Java\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
    // TODO sin esto en la opcion de la VM no anda
    // Preguntar: ya se cargó el archivo de JavaFx en el proyecto.


    @Override
    public void start(Stage stage) {

        VBox root = new VBox(5);
        root.getChildren().addAll(crearBotonesDeUnidades(), new GridPaneTablero());
        Scene scene = new Scene(root);
        stage.setTitle("Eleccion de unidades");
        stage.setScene(scene);
        stage.show();
    }


    public HBox crearBotonesDeUnidades() {
        HBox opcionesUnidades = new HBox(5);
        opcionesUnidades.setPadding(new Insets(10));
        opcionesUnidades.setAlignment(Pos.BASELINE_RIGHT);

        opcionesUnidades.getChildren().addAll(new BotonElegirSoldado(),
                                            new BotonElegirJinete(),
                                            new BotonElegirCatapulta(),
                                            new BotonElegirCurandero());
        return opcionesUnidades;
    }

    public static void main(String[] args) {
        launch();
    }

}