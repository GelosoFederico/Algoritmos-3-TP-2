package main.modelo.juego;

import main.modelo.excepciones.JuegoNoTieneJugadorConEseNombreException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConjuntoDeJugadores implements Iterable {
    private List<Jugador> jugadores;

    public ConjuntoDeJugadores(){
        this.jugadores = new ArrayList<Jugador>();
    }

    public ConjuntoDeJugadores(ConjuntoDeJugadores otrosJugadores){
        this.jugadores = new ArrayList<Jugador>(otrosJugadores.jugadores());
    }

    public List<Jugador> jugadores() {
        return this.jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores().add(jugador);
    }

    @Override
    public Iterator iterator() {
        return new ConjuntoDeJugadoresIterador(this.jugadores());
    }

    public int cantidad() {return jugadores.size(); }

    public Jugador primero() { return jugadores.get(0); }

    public Jugador encontrarJugadorPorNombre(String jugadorNombre) {
        for (int i = 0; i < this.jugadores().size(); i++) {
            if (this.jugadores().get(i).nombre().equals(jugadorNombre)) {
                return this.jugadores().get(i);
            }
        }
        throw new JuegoNoTieneJugadorConEseNombreException();

    }
}
