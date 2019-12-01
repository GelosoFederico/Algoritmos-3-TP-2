package main.vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import main.controlador.HandlerTablero;

public class GridPaneTablero extends GridPane {
    private static final int LONGITUD = 20;
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;

    public GridPaneTablero() {
        super();

        for(int i=0; i< LONGITUD; i++) {
            for (int j = 0; j < LONGITUD; j++){
                ImageView imagenCasillero = new ImageView("file:src/imagenCasillero.png");
                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(imagenCasillero);
                this.add(stackPane,i,j);
                imagenCasillero.setFitHeight(ALTURA_CASILLERO);
                imagenCasillero.setFitWidth(ANCHURA_CASILLERO);
            }
        }

        this.setOnMouseClicked(new HandlerTablero(this));
    }
}
