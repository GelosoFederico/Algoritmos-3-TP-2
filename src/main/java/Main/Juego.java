package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
        if(this.jugadores().size() == 2) {
            throw new JuegoNoPuedeTenerMasDe2Jugadores();
        }
        this.jugadores().add(jugador);
    }

    public void murioUnidad(Unidad unidad){
        unidad.jugador().pierdeUnidad(unidad);
    }

    public void jugadorPerdio(Jugador jugador) {

    }

    public void reiniciar() {
        INSTANCE = new Juego();
    }
}
