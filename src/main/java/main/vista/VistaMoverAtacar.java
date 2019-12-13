package main.vista;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.modelo.juego.Juego;

public class VistaMoverAtacar extends Group {
    private final Stage stage;
    private GridPaneTablero tablero;
    private VBox infoIzquierda;
    public VistaMoverAtacar(Stage stage, GridPaneTablero tablero) {
        this.stage = stage;
        this.tablero = tablero;
        this.infoIzquierda = new VBox();
        String nombreJugador = Juego.getInstance().getJugadorDeTurno().nombre();
        this.infoIzquierda.getChildren().add(new Text(nombreJugador));
        infoIzquierda.getChildren().addAll(new BotonMover(tablero), new BotonAtacar(), new BotonPasarTurno());
        this.actualizarInformacion();
        // Boton mover
        // Boton atacar
        HBox root = new HBox(5);
        root.getChildren().addAll(tablero,infoIzquierda);
        Scene scene = new Scene(root);
        this.stage.setScene(scene);
        this.stage.setTitle("Mover y Atacar");
        tablero.setModoSeleccionarMovible();
        tablero.setModoSinReaccion();
        stage.show();

    }

    public void actualizarInformacion() {
        String nombreJugador = Juego.getInstance().getJugadorDeTurno().nombre();

        Text nombre = (Text)this.infoIzquierda.getChildren().get(0);
        nombre.setText(nombreJugador);
    }
}