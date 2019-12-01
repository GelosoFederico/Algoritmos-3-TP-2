package main.vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.controlador.HandlerCasillero;
import main.modelo.direccion.Posicion;

public class VistaCasillero extends HBox {
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;
    private Posicion posicion;
    private ImageView imagen;

    public VistaCasillero(Posicion pos) {
        super();
        this.posicion = pos;
        this.imagen = new ImageView("file:src/imagenCasillero.png");
        this.imagen.setFitHeight(ALTURA_CASILLERO);
        this.imagen.setFitWidth(ANCHURA_CASILLERO);
        this.getChildren().add(this.imagen);
        this.setOnMouseClicked(new HandlerCasillero(this));
    }

    public Posicion getPosicion() { return this.posicion; }
    public void actualizarImagen(ImageView imagen) {this.imagen = imagen; }

}
