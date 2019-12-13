package main.controlador;

import main.controlador.sonido.HandlerSonidoJugador;
import main.vista.VistaPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HandlerAgregarJugador implements EventHandler<ActionEvent> {
    private final TextField textField;
    private Stage stage;

    public HandlerAgregarJugador(TextField textField, Stage stage) {
        super();
        this.textField = textField;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        String nombre = this.textField.getText().trim();
        main.modelo.juego.Juego.getInstance().agregarJugador(new main.modelo.juego.Jugador(nombre));
        this.textField.setText("");
        HandlerSonidoJugador.reproducirSonidoCreacion();
        if(main.modelo.juego.Juego.getInstance().jugadores().cantidad() == 2) {
            VistaPartida partida = new VistaPartida(this.stage);
        }
    }

}
