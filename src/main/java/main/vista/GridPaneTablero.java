package main.vista;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import main.controlador.HandlerSeleccionarMovible;
import main.modelo.tablero.distancia.Posicion;

public class GridPaneTablero extends GridPane {
    private static final int LONGITUD = 20;

    public GridPaneTablero() {
        super();

        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){
                VistaCasillero casillero = new VistaCasillero(new Posicion(i,j));

                this.add(casillero, i, j);
            }
        }
    }

    public void setModoSeleccionarMovible() {
        for (Node node : this.getChildren()) {
            VistaCasillero vistaCasillero = (VistaCasillero) node;
            vistaCasillero.setHandler(new HandlerSeleccionarMovible(vistaCasillero));
        }
    }
}
