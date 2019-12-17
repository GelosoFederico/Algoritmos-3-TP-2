package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.unidad.Unidad;
import main.vista.GridPaneTablero;
import main.vista.VistaCasillero;

import static main.modelo.tablero.Tablero.getInstance;

public class HandlerSeleccionarAtacante implements EventHandler<MouseEvent> {
    private VistaCasillero vistaCasillero;
    private static VistaCasillero vistaCasilleroSeleccionado;
    private static Unidad unidadSeleccionada = null;
    private GridPaneTablero tablero;

    public HandlerSeleccionarAtacante(VistaCasillero vistaCasillero, GridPaneTablero tablero) {
        this.vistaCasillero = vistaCasillero;
        this.tablero = tablero;
    }

    public static void setUnidad(VistaCasillero vistaCasillero) {
        unidadSeleccionada =  getInstance().getUnidadEnPosicion(vistaCasillero.getPosicion());
    }

    public static Unidad getUnidad() {
        return unidadSeleccionada;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        setUnidad(this.vistaCasillero);
        this.tablero.setModoSeleccionarAtacado();
    }

}
