package main.controlador;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import main.vista.VistaAgregarJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.File;

public class HandlerIniciarJuego implements EventHandler<ActionEvent> {
    private Stage stage;

    public HandlerIniciarJuego(Stage stage) {
        super();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        main.modelo.juego.Juego.getInstance();
        main.modelo.tablero.Tablero.getInstance();
        VistaAgregarJugador vistaJugador = new VistaAgregarJugador(this.stage);
        vistaJugador.dibujarPantalla();

    }
}
