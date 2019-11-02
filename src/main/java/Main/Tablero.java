package Main;
import java.util.Collection;

public class Tablero {
    //Collection<Casillero> casilleros;
    static Casillero casilleroDeLaPosicion(Posicion posicion) {
        Casillero casilleroEnPosicion = new Casillero(posicion); // TODO: hardcodeo TDD
        return casilleroEnPosicion;   
    }

    static Casillero obtenerCasilleroLibreParaJugador(Posicion posicion, Jugador jugador) {
        return new Casillero(posicion); // TODO: hardcodeo
    }


}
