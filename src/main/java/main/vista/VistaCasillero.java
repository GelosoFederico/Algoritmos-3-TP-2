package main.vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import main.controlador.HandlerColocarUnidad;
import main.controlador.HandlerElegirEquipoParaCasillero;
import main.modelo.juego.EquipoNegro;
import main.modelo.tablero.Tablero;
import main.modelo.tablero.distancia.Posicion;

public class VistaCasillero extends StackPane {
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;

    private Posicion posicion;
    private ImageView imagen;

    public VistaCasillero(Posicion pos) {
        super();
        this.posicion = pos;

        HandlerElegirEquipoParaCasillero elegirImagen = new HandlerElegirEquipoParaCasillero(this);
        this.imagen.setFitHeight(ALTURA_CASILLERO);
        this.imagen.setFitWidth(ANCHURA_CASILLERO);

        this.getChildren().add(this.imagen);

        this.setOnMouseClicked(new HandlerColocarUnidad(this));
    }

    public Posicion getPosicion() { return this.posicion; }
    public void agregarUnidad(ImageView unidad) {
        this.getChildren().add(unidad);
    }

    public void setVistaCasilleroEquipoNegro(){
        this.imagen = new ImageView("file:src/recursos/img/imagenCasillero.png");
    }

    public void setVistaCasilleroEquipoBlanco(){
        this.imagen = new ImageView("file:src/recursos/img/casilleroOtroColor.png");
    }


}
