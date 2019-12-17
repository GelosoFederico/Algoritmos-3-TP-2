package main.vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import main.controlador.HandlerColocarUnidad;
import main.modelo.tablero.distancia.Posicion;

public class VistaBorde extends StackPane {

    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;
    private final ImageView imagen;

    public VistaBorde() {


            this.imagen = new ImageView("file:src/curandero.jpg");
            this.imagen.setFitHeight(ALTURA_CASILLERO);
            this.imagen.setFitWidth(ANCHURA_CASILLERO);



    }
}
