package main.modelo.juego;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;

import java.util.ArrayList;
import java.util.List;

public class ColocarUnidades extends Fase {
    private List<Jugador> jugadores;

    public ColocarUnidades(Juego juego) {
        super(juego);
        this.jugadores = new ArrayList<Jugador>(juego.jugadores());
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        throw new JuegoNoPuedeTenerMasDe2JugadoresException();
    }

    @Override
    public void cambiarJugadorDeTurno() {

    }

}
