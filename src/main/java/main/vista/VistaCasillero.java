package main.vista;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.StackPane;
import main.controlador.HandlerColocarUnidad;
import main.modelo.tablero.distancia.Posicion;

import java.awt.*;

public class VistaCasillero extends StackPane {
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;

    private Posicion posicion;
    private ImageView imagen;
    private boolean posicionCentral = false;

    public VistaCasillero(Posicion pos, int longitudDelCentro) {
        super();
        this.posicion = pos;
        if(pos.posicionEnX() == longitudDelCentro){
            this.posicionCentral = true;
            this.imagen = new ImageView("file:src/casilleroConBorde.png");
            this.imagen.setFitHeight(ALTURA_CASILLERO);
            this.imagen.setFitWidth(ANCHURA_CASILLERO*2);
        }else {
            this.imagen = new ImageView("file:src/imagenCasillero.png");
            this.imagen.setFitHeight(ALTURA_CASILLERO);
            this.imagen.setFitWidth(ANCHURA_CASILLERO);
        }
        this.getChildren().add(this.imagen);
        this.setOnMouseClicked(new HandlerColocarUnidad(this));
    }

    public Posicion getPosicion() { return this.posicion; }

    public void agregarUnidad(ImageView unidad) {
        this.getChildren().add(unidad);
    }

}
