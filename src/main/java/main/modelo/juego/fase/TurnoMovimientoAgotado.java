package main.modelo.juego.fase;

import main.modelo.excepciones.JugadorYaMovioException;
import main.modelo.juego.Jugador;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;

public class TurnoMovimientoAgotado extends TurnoMovimiento {
    public void moverUnidadDeJugadorHacia(Unidad soldado1, Jugador jugador, Posicion posicion) {
        throw new JugadorYaMovioException();
    }
}