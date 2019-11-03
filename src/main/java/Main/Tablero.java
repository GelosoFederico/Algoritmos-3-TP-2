package Main;
import java.util.Collection;

public class Tablero {
    //Collection<Casillero> casilleros;
    static Casillero casilleroDeLaPosicion(Posicion posicion) {
        Casillero casilleroEnPosicion = new Casillero(posicion); // TODO: hardcodeo TDD
        return casilleroEnPosicion;   
    }

    static Casillero obtenerCasilleroLibreParaJugador(Posicion posicion, Jugador jugador) throws CasilleroEstaOcupado {
        Casillero casilleroBuscado = Tablero.obtenerCasilleroDePosicion(posicion);

        if (casilleroBuscado.estado() == "ocupado")
            throw new CasilleroEstaOcupado();
        else {
            casilleroBuscado.setEstado("ocupado");
            return casilleroBuscado;
        }
    }

    static Casillero obtenerCasilleroDePosicion(Posicion posicion) {
        // TODO: A completar. Puse cualquier cosa.
        return new Casillero(posicion);
    }

}
