package main.vista;

import javafx.scene.layout.GridPane;
import main.modelo.tablero.distancia.Posicion;

public class GridPaneTablero extends GridPane {
    private static final int LONGITUD = 20;

    public GridPaneTablero() {
        super();

        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){

               // if(i == LONGITUD/2) {
                 //   this.setHgap(32);
                //}
                VistaCasillero casillero = new VistaCasillero(new Posicion(i, j), LONGITUD/2);

                this.add(casillero, i, j);
            }
        }
    }
}
