package main.modelo.juego;

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



}
