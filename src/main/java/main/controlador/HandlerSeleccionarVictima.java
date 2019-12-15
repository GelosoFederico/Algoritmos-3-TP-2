package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.controlador.sonido.HandlerSonidoPelea;
import main.modelo.excepciones.*;
import main.modelo.juego.Juego;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;
import main.vista.*;
import main.vista.alertas.*;

public class HandlerSeleccionarVictima implements EventHandler<MouseEvent> {
    private VistaCasillero vistaCasillero;
    private GridPaneTablero gridPaneTablero;

    public HandlerSeleccionarVictima(VistaCasillero vistaCasillero, GridPaneTablero gridPaneTablero) {
        this.gridPaneTablero = gridPaneTablero;
        this.vistaCasillero = vistaCasillero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            Unidad unidadAtacante = HandlerSeleccionarAtacante.getUnidad();
            Unidad unidadVictima = Tablero.getInstance().getUnidadEnPosicion(vistaCasillero.getPosicion());
            Juego.getInstance().atacarConUnidadAUnidad(unidadAtacante, unidadVictima);
            HandlerSonidoPelea.reproducirSonidoSeleccion();
            this.gridPaneTablero.setModoSinReaccion();
        } catch (ExcepcionEnJuego e) {
            new VistaError(e);
        } catch (JugadorGanoLaPartida e) {
            new VistaJugadorGano(e.jugadorGanador());
        }
    }
}
