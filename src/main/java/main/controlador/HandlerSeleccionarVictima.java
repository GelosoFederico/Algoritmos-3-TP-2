package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.juego.Juego;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;
import main.vista.GridPaneTablero;
import main.vista.VistaCasillero;

public class HandlerSeleccionarVictima implements EventHandler<MouseEvent> {
    private VistaCasillero vistaCasillero;
    private GridPaneTablero gridPaneTablero;

    public HandlerSeleccionarVictima(VistaCasillero vistaCasillero, GridPaneTablero gridPaneTablero) {
        this.gridPaneTablero = gridPaneTablero;
        this.vistaCasillero = vistaCasillero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Unidad unidadAtacante = HandlerSeleccionarAtacante.getUnidad();
        Unidad unidadVictima = Tablero.getInstance().getUnidadEnPosicion(vistaCasillero.getPosicion());
        Juego.getInstance().atacarConUnidadAUnidad(unidadAtacante,unidadVictima);
        System.out.println("Tengo la victima y la ataque");
        this.gridPaneTablero.setModoSinReaccion();
    }
}
