package main.vista;

import Main.controlador.HandlerIniciarJuego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import main.vista.BotonElegirCatapulta;


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

    public GridPane crearTabla() {
        GridPane grid = new GridPane();
        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){
                ImageView imagenCasillero;
                grid.add(imagenCasillero = new ImageView("file:src/imagenCasillero.png"), i, j);
                imagenCasillero.setFitHeight(ALTURA_CASILLERO);
                imagenCasillero.setFitWidth(ANCHURA_CASILLERO);
            }
        }

        return grid;
    }

    public HBox crearBotonesDeUnidades() {
        HBox opcionesUnidades = new HBox(5);
        opcionesUnidades.setPadding(new Insets(10));
        opcionesUnidades.setAlignment(Pos.BASELINE_RIGHT);

        opcionesUnidades.getChildren().addAll(new main.vista.BotonElegirSoldado(),
                new main.vista.BotonElegirJinete(),
                new main.vista.BotonElegirCatapulta(),
                new main.vista.BotonElegirCurandero());
        return opcionesUnidades;
    }

    public static void main(String[] args) {
        launch();
    }

}