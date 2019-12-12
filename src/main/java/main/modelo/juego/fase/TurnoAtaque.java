package main.modelo.juego.fase;

import main.modelo.juego.Jugador;
import main.modelo.unidad.Unidad;

public abstract class TurnoAtaque {
    public abstract void atacarConUnidadDeJugadorAUnidad(Unidad atacante, Jugador jugador, Unidad defensora);
}
