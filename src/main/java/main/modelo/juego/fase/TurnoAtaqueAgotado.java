package main.modelo.juego.fase;

import main.modelo.excepciones.JugadorYaAtacoException;
import main.modelo.juego.Jugador;
import main.modelo.unidad.Unidad;

public class TurnoAtaqueAgotado extends TurnoAtaque {

    @Override
    public void atacarConUnidadDeJugadorAUnidad(Unidad atacante, Jugador jugador, Unidad defensora) {
        throw new JugadorYaAtacoException();
    }

}
