package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.juego.EquipoNegro;
import main.modelo.tablero.Tablero;
import main.modelo.tablero.distancia.Posicion;
import main.vista.VistaCasillero;

public class HandlerElegirEquipoParaCasillero implements EventHandler<ActionEvent> {

    private Posicion posicion;
    private VistaCasillero vistaCasillero;

    public HandlerElegirEquipoParaCasillero(VistaCasillero unaVistaDeCasillero) {
        this.posicion = unaVistaDeCasillero.getPosicion();
        this.vistaCasillero = unaVistaDeCasillero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(Tablero.getInstance().obtenerCasilleroEnPosicion(this.posicion).equipo().getClass().equals(EquipoNegro.class)){
            this.vistaCasillero.setVistaCasilleroEquipoNegro();
        }else {
            this.vistaCasillero.setVistaCasilleroEquipoBlanco();
        }

    }
}
