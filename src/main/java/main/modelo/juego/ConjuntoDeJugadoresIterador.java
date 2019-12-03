package main.modelo.juego;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ConjuntoDeJugadoresIterador implements Iterator {
    int current = 0;
    private List<Jugador> jugadores;

    ConjuntoDeJugadoresIterador(List<Jugador> jugadores){
        this.jugadores = jugadores;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Jugador next() {
        this.current++;
        if(this.current == this.jugadores.size()) {
            this.current = 0;
        }
        return this.jugadores.get(current);
    }

    @Override
    public void remove() {
        this.jugadores.remove(current);
        if(this.jugadores.size() == current) {
            current--;
        }

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
