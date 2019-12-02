package main.vista;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.vista.GridPaneTablero;
import main.vista.VBoxBotonesDeUnidades;

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

        HBox root = new HBox(5);
        root.getChildren().addAll( this.tablero,new VBoxBotonesDeUnidades());
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
