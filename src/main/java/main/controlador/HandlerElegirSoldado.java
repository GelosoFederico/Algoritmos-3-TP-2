package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.controlador.sonido.HandlerSonidoSoldado;
import main.modelo.juego.Juego;
import main.modelo.unidad.Soldado;
import main.modelo.unidad.Unidad;


public class HandlerElegirSoldado implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Unidad soldado = new Soldado();
        soldado.setEquipo(Juego.getInstance().getJugadorDeTurno().equipo());
        HandlerColocarUnidad.setUnidadElegida(soldado);
        HandlerSonidoSoldado.reproducirSonidoSeleccion();
    }
}
