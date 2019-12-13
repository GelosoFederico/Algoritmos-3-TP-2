package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;
import main.vista.VistaCasillero;


public class HandlerSeleccionarMovible implements EventHandler<MouseEvent> {
    private VistaCasillero vistaCasillero;
    private static Unidad unidadSeleccionada;

    public HandlerSeleccionarMovible(VistaCasillero vistaCasillero) {
        this.vistaCasillero = vistaCasillero;
        this.unidadSeleccionada = null;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.unidadSeleccionada = Tablero.getInstance().getUnidadEnPosicion(vistaCasillero.getPosicion());
        System.out.println("Elegi una unidad");
    }
}
