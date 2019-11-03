package Main;
import java.util.Collection;

public class Tablero {

    Casillero[][] casilleros;

    int maximaCantidadDeCasilleros = 20;


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

        for(int i = 1; i <= maximaCantidadDeCasilleros ; i++ ){
            for(int j = 1; j <= maximaCantidadDeCasilleros ; j++ ) {
                Casillero unCasillero = new Casillero(new Posicion(i,j), numeroDeJugador);

                    casilleros[i][j] = unCasillero;

            }
        }

    }

}
