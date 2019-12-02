package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.juego.Juego;
import main.modelo.unidad.Catapulta;
import main.modelo.unidad.Unidad;


public class HandlerElegirCatapulta implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        Unidad catapulta = new Catapulta();
        catapulta.setEquipo(Juego.getInstance().getJugadorDeTurno().equipo());
        HandlerColocarUnidad.setUnidadElegida(catapulta);
        HandlerSonidos.getInstance().reproducirSonido("Crear Catapulta");
    }
}
