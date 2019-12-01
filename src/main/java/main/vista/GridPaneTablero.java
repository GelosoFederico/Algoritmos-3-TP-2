package main.vista;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import main.controlador.HandlerCasillero;
import main.controlador.HandlerTablero;
import main.modelo.direccion.Posicion;

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

        // this.setOnMouseClicked(new HandlerTablero(this));
    }
}
