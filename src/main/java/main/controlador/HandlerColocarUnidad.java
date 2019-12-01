package main.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.unidad.Unidad;
import main.vista.DiccionarioImagenes;
import main.vista.VistaCasillero;

public class HandlerColocarUnidad implements EventHandler<MouseEvent> {
    private VistaCasillero vistaCasillero;
    private static Unidad unidadElegida = null;
    private DiccionarioImagenes diccionarioImagenes = new DiccionarioImagenes();

    public HandlerColocarUnidad(VistaCasillero vistaCasillero) {
        super();
        this.vistaCasillero = vistaCasillero;
    }

    static public Unidad getUnidadElegida() {
        return unidadElegida;
    }
    static public void setUnidadElegida(Unidad unidad) {
        unidadElegida = unidad;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(unidadElegida != null ) {
            Jugador jugador = Juego.getInstance().getJugadorDeTurno();
            jugador.colocarUnidadEn(unidadElegida, vistaCasillero.getPosicion());
            vistaCasillero.agregarUnidad(diccionarioImagenes.get("soldado")); // TODO: generalizar
        }
    }


}
