package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.excepciones.CasilleroOcupadoException;
import main.modelo.excepciones.PosicionesNoEstanADistanciaUnoException;
import main.modelo.excepciones.UnidadNoPerteneceAJugadorException;
import main.modelo.excepciones.UnidadNoPuedeMoverseException;
import main.modelo.juego.Juego;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;
import main.vista.*;

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
        } catch (CasilleroOcupadoException e) {
            new VistaErrorCasilleroOcupado();
        } catch (PosicionesNoEstanADistanciaUnoException e) {
            new VistaErrorMoverseACasilleroAdyacente();
        } catch (UnidadNoPerteneceAJugadorException e) {
            new VistaErrorUnidadNoLePerteneceAJugador();
        } catch (UnidadNoPuedeMoverseException e) {
            new VistaErrorUnidadNoPuedeMoverse();
        }
    }
}
