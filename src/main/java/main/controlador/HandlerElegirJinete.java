package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.controlador.sonido.HandlerSonidoJinete;
import main.modelo.juego.Juego;
import main.modelo.unidad.Jinete;
import main.modelo.unidad.Unidad;


public class HandlerElegirJinete implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Unidad jinete = new Jinete();
        jinete.setEquipo(Juego.getInstance().getJugadorDeTurno().equipo());
        HandlerColocarUnidad.setUnidadElegida(jinete);
        HandlerSonidoJinete.reproducirSonidoSeleccion();
    }
}
