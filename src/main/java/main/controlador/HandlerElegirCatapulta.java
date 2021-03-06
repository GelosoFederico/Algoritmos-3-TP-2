package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.controlador.sonido.HandlerSonidoCatapulta;
import main.modelo.juego.Juego;
import main.modelo.unidad.Catapulta;
import main.modelo.unidad.Unidad;


public class HandlerElegirCatapulta implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Unidad catapulta = new Catapulta();
        catapulta.setEquipo(Juego.getInstance().getJugadorDeTurno().equipo());
        HandlerColocarUnidad.setUnidadElegida(catapulta);
        HandlerSonidoCatapulta.reproducirSonidoSeleccion();
    }
}
