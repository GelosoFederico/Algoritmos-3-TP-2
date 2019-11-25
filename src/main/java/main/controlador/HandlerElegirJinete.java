package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.direccion.Posicion;
import main.modelo.juego.Juego;
import main.modelo.unidad.Jinete;


public class HandlerElegirJinete implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        // TEMP
        Juego.getInstance().jugadores().get(0)
                .colocarUnidadEn(new Jinete(),new Posicion(2,1));
    }
}
