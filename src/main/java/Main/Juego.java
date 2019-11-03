package Main;

import java.util.Vector;

public class Juego {
    // Singleton pattern
    private static Juego INSTANCE = new Juego();
    private Vector<Jugador> jugadores;

    private Juego() {
        jugadores = new Vector<Jugador>();
    }

    public static Juego getInstance() {
        return INSTANCE;
    }

    /*
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void murioUnidad(Unidad unidad){
        unidad.jugador().pierdeUnidad(unidad);
    }
    */

    public void jugadorPerdio(Jugador jugador) {

    }
}
