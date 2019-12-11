package main.modelo.juego.fase;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;
import main.modelo.juego.ConjuntoDeJugadores;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;

import java.util.Iterator;

public class FaseColocarUnidades extends Fase {
    private ConjuntoDeJugadores jugadores;
    private Iterator iterator;

    public FaseColocarUnidades(Juego juego) {
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
