package main.vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main.controlador.HandlerTablero;

public class GridPaneTablero extends GridPane {
    private static final int LONGITUD = 20;
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;

    public GridPaneTablero() {
        super();

        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){
                ImageView imagenCasillero;
                this.add(imagenCasillero = new ImageView("file:src/imagenCasillero.png"), i, j);
                imagenCasillero.setFitHeight(ALTURA_CASILLERO);
                imagenCasillero.setFitWidth(ANCHURA_CASILLERO);
            }
        }

        this.setOnMouseClicked(new HandlerTablero(this));
    }
}
