package main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;

/**
 * JavaFX App
 */
public class App extends Application {
    // Preguntar: ya se cargó el archivo de JavaFx en el proyecto.
    @Override
    public void start(Stage stage) {

        // TEMPORAL: solo para que pueda andar
        Juego.getInstance().agregarJugador(new Jugador("Gabriela"));

        VBox root = new VBox(5);
        root.getChildren().addAll(new HBoxBotonesDeUnidades(), new GridPaneTablero());
        Scene scene = new Scene(root);
        stage.setTitle("Eleccion de unidades");
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }

}