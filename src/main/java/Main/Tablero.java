package Main;
import java.util.Collection;

public class Tablero {

    int maximaCantidadDeCasilleros = 20;

    Casillero[][] casilleros = new Casillero[maximaCantidadDeCasilleros][maximaCantidadDeCasilleros];




    static Casillero casilleroDeLaPosicion(Posicion posicion) {
        return new Casillero(posicion, 1);
    }

    static Casillero obtenerCasilleroLibreParaJugador(Posicion posicion, Jugador jugador) throws CasilleroEstaOcupado {
        Casillero casilleroBuscado = Tablero.obtenerCasilleroDePosicion(posicion);

        if (casilleroBuscado.estado().equals("ocupado"))
            throw new CasilleroEstaOcupado();
        else {
            casilleroBuscado.setEstado("ocupado");
            return casilleroBuscado;
        }
    }

    static Casillero obtenerCasilleroDePosicion(Posicion posicion) {
        // TODO: A completar. Puse cualquier cosa.
        return new Casillero(posicion,1);
    }

    public void crearCasillerosParaJugador(int numeroDeJugador) {

        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {

                    casilleros[i][j] = new Casillero(new Posicion(i,j), numeroDeJugador);

            }
        }

    }

}
