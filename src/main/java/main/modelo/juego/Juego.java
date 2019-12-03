package main.modelo.juego;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;
import main.modelo.excepciones.JuegoNoTieneJugadorConEseNombreException;
import main.modelo.excepciones.JugadorGanoLaPartida;
import main.modelo.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    // Singleton pattern
    private static Juego INSTANCE = null;

    private List<Jugador> jugadores = null;

    private Juego() {
        jugadores = new ArrayList<Jugador>();
        this.setearFase(new AgregarJugadores(this));
    }

    private Jugador jugadorDeTurno;
    private Fase fase;



    public static Juego getInstance() {
        if( INSTANCE == null) {
            INSTANCE = new Juego();
        }
        return INSTANCE;
    }

    public List<Jugador> jugadores() {
        return this.jugadores;
    }

    public Jugador getJugadorDeTurno() {
        return jugadorDeTurno;
    }

    public void setJugadorDeTurno(Jugador jugador) {
        jugadorDeTurno = jugador;
    }

    public void agregarJugador(Jugador jugador) {
        fase.agregarJugador(jugador);
    }

    public void murioUnidad(Unidad unidad) {
        this.encontrarJugadorPorNombre(unidad.getJugador()).pierdeUnidad(unidad);
    }

    private Jugador encontrarJugadorPorNombre(String jugadorNombre) {
        //TODO usar foreach
        for (int i = 0; i < this.jugadores().size(); i++) {
            if (this.jugadores().get(i).nombre().equals(jugadorNombre)) {
                return this.jugadores().get(i);
            }
        }
        throw new JuegoNoTieneJugadorConEseNombreException();
    }

    public void jugadorPerdio(Jugador jugador) {
        // Esto asume que hay exactamente dos jugadores
        this.jugadores().remove(jugador);
        throw new JugadorGanoLaPartida(this.jugadores().get(0));
    }

    public void cambiarJugadorDeTurno() {
        if (jugadorDeTurno == jugadores().get(0))
            jugadorDeTurno = jugadores().get(1);
        else
            jugadorDeTurno = jugadores().get(0);
    }

    public void ejecutarUnTurno() {
        // TODO: aca es donde se le permite al jugador de turno elegir una pieza
        //  y hacer algo: avanzar y ataque
        this.fase.cambiarJugadorDeTurno();
    }

    public void terminarDeColocarParaJugador() {
    }

    public void setearFase(Fase fase) {
        this.fase = fase;
    }

    public void agregarJugadorDirecto(Jugador jugador) {
        this.jugadores().add(jugador);
    }
}
