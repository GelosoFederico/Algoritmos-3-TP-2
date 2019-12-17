package main.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import main.modelo.juego.Juego;
import main.modelo.juego.fase.FaseMoverYAtacar;
import main.vista.GridPaneTablero;
import main.vista.VistaMoverAtacar;

public class HandlerTerminarDeColocar implements EventHandler<ActionEvent> {
    private Stage stage;
    private GridPaneTablero gridPaneTablero;

    public HandlerTerminarDeColocar(Stage stage, GridPaneTablero gridPaneTablero) {
        this.stage = stage;
        this.gridPaneTablero = gridPaneTablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego.getInstance().terminarDeColocarParaJugador();

        if (Juego.getInstance().fase().getClass().equals(FaseMoverYAtacar.class))
            new VistaMoverAtacar(stage, gridPaneTablero);
        else
            HandlerTurnos.pasarTurno();
    }
}
