package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.controlador.sonido.HandlerSonidoCurandero;
import main.modelo.juego.Juego;
import main.modelo.unidad.Curandero;
import main.modelo.unidad.Unidad;


public class HandlerElegirCurandero implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Unidad curandero = new Curandero();
        curandero.setEquipo(Juego.getInstance().getJugadorDeTurno().equipo());
        HandlerColocarUnidad.setUnidadElegida(curandero);
        HandlerSonidoCurandero.reproducirSonidoSeleccion();
    }
}
