package main.vista;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPartida extends Group {
    private final Stage stage;
    private GridPane tablero;

    private static final int LONGITUD = 20;
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;


    public VistaPartida(Stage stage) {
        super();
        this.stage = stage;
        this.tablero = new GridPaneTablero();

        VBox root = new VBox(5);
        root.getChildren().addAll(new HBoxBotonesDeUnidades(), this.tablero);
        Scene scene = new Scene(root);
        stage.setTitle("Eleccion de unidades");
        stage.setScene(scene);
        stage.show();
    }

    /*
    public void actualizar() {

    }

     */

}
