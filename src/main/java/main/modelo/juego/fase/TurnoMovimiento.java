package main.modelo.juego.fase;

import main.modelo.juego.Jugador;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;

public abstract class TurnoMovimiento {
    public abstract void moverUnidadDeJugadorHacia(Unidad unidad, Jugador jugador, Posicion posicion);


}
