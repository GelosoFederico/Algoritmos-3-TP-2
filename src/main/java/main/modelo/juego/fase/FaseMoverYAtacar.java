package main.modelo.juego.fase;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;

public class FaseMoverYAtacar extends Fase {

    public FaseMoverYAtacar(Juego juego) {
        super(juego);
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        throw new JuegoNoPuedeTenerMasDe2JugadoresException();
    }

    @Override
    public void cambiarJugadorDeTurno() {


    }

    @Override
    public void removerJugador() {

    }
}
