package main.modelo.juego;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColocarUnidades extends Fase {
    private ConjuntoDeJugadores jugadores;
    private Iterator iterator;

    public ColocarUnidades(Juego juego) {
        super(juego);
        this.jugadores = new ConjuntoDeJugadores(juego.jugadores());
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        throw new JuegoNoPuedeTenerMasDe2JugadoresException();
    }

    @Override
    public void cambiarJugadorDeTurno() {
        if(this.iterator == null) {
            iterator = this.jugadores.iterator();
        }
        juego.setJugadorDeTurno((Jugador)iterator.next());
    }

    @Override
    public void removerJugador(){
        jugadores.jugadores().remove(juego.getJugadorDeTurno());
        if(this.jugadores.cantidad() == 0) {
            // juego.setearFase();
        }
    }
}
