package Main;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    // Singleton pattern
    private static Juego INSTANCE = new Juego();

    private List<Jugador> _jugadores;

    private Juego() {
        _jugadores = new ArrayList<Jugador>();
    }

    public static Juego getInstance() {
        return INSTANCE;
    }

    public List<Jugador> jugadores() {
        return this._jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        if (this.jugadores().size() == 2) {
            throw new JuegoNoPuedeTenerMasDe2JugadoresException();
        }
        this.jugadores().add(jugador);
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

    public void reiniciar() {
        INSTANCE = new Juego();
        Jugador.reiniciar();
    }
}
