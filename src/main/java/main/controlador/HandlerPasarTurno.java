package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.modelo.juego.Juego;
import main.vista.VistaMoverAtacar;

public class HandlerPasarTurno implements EventHandler<ActionEvent> {
    VistaMoverAtacar vistaMoverAtacar;

    public HandlerPasarTurno(VistaMoverAtacar vistaMoverAtacar) {this.vistaMoverAtacar = vistaMoverAtacar;}

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().terminarTurno();
        HandlerTurnos.pasarTurno();
        vistaMoverAtacar.actualizarInformacion();
    }
}
