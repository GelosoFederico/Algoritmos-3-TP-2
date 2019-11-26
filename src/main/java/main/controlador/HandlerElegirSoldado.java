package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.direccion.Posicion;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.unidad.Soldado;


public class HandlerElegirSoldado implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        // TEMP Esto es para que no este sin jugadores
        Juego.getInstance().agregarJugador(new Jugador("Gabriela"));
        // TEMP
        Juego.getInstance().jugadores().get(0).colocarUnidadEn(new Soldado(),new Posicion(1,1));
    }
}
