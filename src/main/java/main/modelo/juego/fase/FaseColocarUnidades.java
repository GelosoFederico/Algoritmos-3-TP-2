package main.modelo.juego.fase;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;
import main.modelo.juego.ConjuntoDeJugadores;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FaseColocarUnidades extends Fase {
    private List<Jugador> jugadores;

    public FaseColocarUnidades(Juego juego) {
        super(juego);
        this.jugadores = new ArrayList<>(juego.jugadores().jugadores());
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        throw new JuegoNoPuedeTenerMasDe2JugadoresException();
    }

    @Override
    public void cambiarJugadorDeTurno() {
        if(! (jugadores.size() == 1))
            this.juego.cambiarJugadorDeTurnoDirecto();
    }

    @Override
    public void removerJugador(){
        Jugador jugadorASacar = juego.getJugadorDeTurno();
        this.juego.cambiarJugadorDeTurnoDirecto();
        this.jugadores.remove(jugadorASacar);
        if(this.jugadores.size() == 0) {
            juego.setearFase(new FaseMoverYAtacar(juego));
            this.juego.setJugadorDeTurno(this.juego.jugadores().primero());
        }
    }
}
