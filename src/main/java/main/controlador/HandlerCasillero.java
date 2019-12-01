package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.vista.VistaCasillero;

public class HandlerCasillero implements EventHandler<MouseEvent> {
    private VistaCasillero casillero;

    public HandlerCasillero(VistaCasillero casillero) {
        super();
        this.casillero = casillero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("lelga");
        if(HandlerTablero.getUnidadElegida() != null) {
            Jugador jugador = Juego.getInstance().getJugadorDeTurno();
            jugador.colocarUnidadEn(HandlerTablero.getUnidadElegida(), casillero.getPosicion());
            // casillero.actualizarImagen(new ImageView("file:src/imagenUnidad.png"));
        }
    }
}
