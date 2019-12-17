package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerMostrarInformacion;

public class BotonMostrarInformacion extends Button {
    public BotonMostrarInformacion(GridPaneTablero tablero) {
        super();
        this.setText("Mostrar Información de la unidad");
        this.setMinHeight(24);

        this.setOnAction(new HandlerMostrarInformacion(tablero));
    }

}
