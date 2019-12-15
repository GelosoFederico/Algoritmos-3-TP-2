package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.excepciones.*;
import main.modelo.juego.Juego;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;
import main.vista.*;
import main.vista.alertas.*;

public class HandlerMoverUnidadHaciaAca implements EventHandler<MouseEvent> {
    private VistaCasillero vistaCasillero;
    private GridPaneTablero tablero;

    public HandlerMoverUnidadHaciaAca(VistaCasillero vistaCasillero, GridPaneTablero tablero) {
        this.vistaCasillero = vistaCasillero;
        this.tablero = tablero;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try {
            Unidad unidadSeleccionada = HandlerSeleccionarMovible.getUnidad();
            Posicion posicionFinal = this.vistaCasillero.getPosicion();
            Juego.getInstance().fase().moverUnidadHacia(unidadSeleccionada, posicionFinal);
            vistaCasillero.agregarUnidad(unidadSeleccionada);
            HandlerSeleccionarMovible.vaciarCasillero();
            this.tablero.setModoSinReaccion();
        } catch (ExcepcionEnJuego e) {
            new VistaError(e);
        }
    }


}
