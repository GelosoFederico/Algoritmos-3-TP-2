package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.unidad.Unidad;
import main.vista.DiccionarioImagenes;
import main.vista.VistaCasillero;


public class HandlerSeleccionarMovible implements EventHandler<MouseEvent> {
    private VistaCasillero vistaCasillero;
    private static Unidad unidadElegida = null;

    public HandlerColocarUnidad(VistaCasillero vistaCasillero) {
        super();
        this.vistaCasillero = vistaCasillero;
    }

    @Override
    public void handle() {
        // Algo deberia hacer
    }

}
