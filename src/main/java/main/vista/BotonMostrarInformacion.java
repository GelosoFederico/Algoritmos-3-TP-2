package main.vista;

import javafx.scene.control.Button;
import main.controlador.HandlerBotonMostrarInformacionUnidad;

public class BotonMostrarInformacion extends Button {
    public BotonMostrarInformacion(GridPaneTablero tablero) {
        super();
        this.setText("Volver a Mostrar Información de la unidad");
        this.setMinHeight(24);

        this.setOnAction(new HandlerBotonMostrarInformacionUnidad(tablero));
    }

}
