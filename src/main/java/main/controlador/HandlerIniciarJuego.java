package Main.controlador;

import Main.vista.VistaAgregarJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

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
