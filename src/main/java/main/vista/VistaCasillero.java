package main.vista;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import main.controlador.HandlerColocarUnidad;
import main.modelo.Observer;
import main.modelo.juego.EquipoNegro;
import main.modelo.tablero.Tablero;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.NullUnidad;
import main.modelo.unidad.Unidad;


public class VistaCasillero extends StackPane implements Observer {
    private static final int ALTURA_CASILLERO = 32;
    private static final int ANCHURA_CASILLERO = 32;
    private EventHandler<MouseEvent> eventHandler = null;

    private Posicion posicion;
    private ImageView imagen;
    private static DiccionarioImagenes diccionarioImagenes = new DiccionarioImagenes();
    public VistaCasillero(Posicion pos) {
        super();
        this.posicion = pos;

        if(Tablero.getInstance().obtenerCasilleroEnPosicion(this.posicion).equipo().getClass().equals(EquipoNegro.class)){
            this.setVistaCasilleroEquipoNegro();
        }else {
            this.setVistaCasilleroEquipoBlanco();
        }
        this.imagen.setFitHeight(ALTURA_CASILLERO);
        this.imagen.setFitWidth(ANCHURA_CASILLERO);

        this.getChildren().add(this.imagen);
        this.agregarUnidad(diccionarioImagenes.get(NullUnidad.class));

        this.setHandler(new HandlerColocarUnidad(this));
        Tablero.getInstance().obtenerCasilleroEnPosicion(this.posicion).addObserver(this);
    }

    public Posicion getPosicion() { return this.posicion; }
    public void agregarUnidad(ImageView unidad) {

        this.getChildren().add(unidad);
    }
    public void agregarUnidad(Unidad unidad) { // TODO: hacer que aparezca aca la unidad y desaparezca en el otro
        this.getChildren().add(diccionarioImagenes.get(unidad.getClass()));
    }
    public void setHandler(EventHandler<MouseEvent> event) {
        this.eventHandler = event;
        this.setOnMouseClicked(event);
    }

    public void vaciarHandler() {
        if (eventHandler != null)
            this.removeEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);
    }

    public void setVistaCasilleroEquipoNegro(){
        this.imagen = new ImageView("file:src/recursos/img/imagenCasillero.png");
    }

    public void setVistaCasilleroEquipoBlanco(){
        this.imagen = new ImageView("file:src/recursos/img/casilleroOtroColor.png");
    }


    public void cambiarVistaUnidad() {
        Unidad unidad = Tablero.getInstance().getUnidadEnPosicion(this.getPosicion());
        if(this.getChildren().size() == 2) {
            this.getChildren().remove(1);
        }
        if(unidad.getClass() != NullUnidad.class) {
            this.agregarUnidad(diccionarioImagenes.get(unidad.getClass()));
        }
    }

    public void change() {
        this.cambiarVistaUnidad();
    }
}
