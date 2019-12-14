package main.vista;

import javafx.scene.control.Alert;
import main.modelo.juego.Jugador;

public class VistaJugadorGano extends Alert {

    public VistaJugadorGano(Jugador jugador) {
        super(Alert.AlertType.ERROR);
        this.setHeaderText("Victoria!");
        this.setContentText("Enhorabuena ".concat(jugador.nombre()).concat(", has ganado!"));
        this.showAndWait();
    }
}
