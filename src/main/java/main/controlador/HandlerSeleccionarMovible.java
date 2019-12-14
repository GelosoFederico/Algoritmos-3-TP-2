package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.unidad.Unidad;
import main.vista.GridPaneTablero;
import main.vista.VistaCasillero;

import static main.modelo.tablero.Tablero.getInstance;


public class HandlerSeleccionarMovible implements EventHandler<MouseEvent> {

    private VistaCasillero vistaCasillero;
    private static VistaCasillero vistaCasilleroSeleccionado;
    private static Unidad unidadSeleccionada = null;
    private GridPaneTablero tablero;

    public HandlerSeleccionarMovible(VistaCasillero vistaCasillero, GridPaneTablero tablero) {
        this.vistaCasillero = vistaCasillero;
        this.tablero = tablero;
    }

    public static void setUnidad(VistaCasillero vistaCasillero) {
        unidadSeleccionada =  getInstance().getUnidadEnPosicion(vistaCasillero.getPosicion());
    }

    public static Unidad getUnidad() {
        return unidadSeleccionada;
    }

    public static void vaciarCasillero() {
        vistaCasilleroSeleccionado.vaciarVistaUnidad();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        setUnidad(this.vistaCasillero);
        vistaCasilleroSeleccionado = this.vistaCasillero;
        System.out.println("Elegi una unidad, ahora hay que apretar un casillero para moverlo hacia ahiii");
        this.tablero.setModoMoverUnidadHaciaAca();
    }
}
