package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.direccion.Posicion;
import main.modelo.juego.Juego;
import main.modelo.unidad.Catapulta;


public class HandlerElegirCatapulta implements EventHandler<ActionEvent> {
    public void handle(ActionEvent event) {
        // TEMP
        Juego.getInstance().jugadores().get(0)
                .colocarUnidadEn(new Catapulta(),new Posicion(3,1));
    }
}
