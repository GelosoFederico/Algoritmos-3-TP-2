package Main;
import java.util.Collection;

public class Tablero {

    int maximaCantidadDeCasilleros = 20;

    Casillero[][] casilleros = new Casillero[maximaCantidadDeCasilleros][maximaCantidadDeCasilleros];



    public Tablero(){
        this.crearCasillerosParaJugador(1);
        this.crearCasillerosParaJugador(2);

    }

    static Casillero casilleroDeLaPosicion(Posicion posicion) {
        return new Casillero(posicion, 1);
    }

    Casillero obtenerCasilleroLibreParaJugador(Posicion posicion, Jugador jugador) throws CasilleroEstaOcupado, CasilleroEsDeEnemigo {
        Casillero casilleroBuscado = this.obtenerCasilleroLibreDePosicion(posicion);

        if (casilleroBuscado.estado().equals("ocupado"))
            throw new CasilleroEstaOcupado();
        else {

            if(casilleroBuscado.deJugador() != 1)
                throw new CasilleroEsDeEnemigo();

            casilleroBuscado.setEstado("ocupado", 1);
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


    public Casillero obtenerCasilleroLibreDePosicion(Posicion posicion) {

        int xPosicion = posicion.posicionEnX();
        int yPosicion = posicion.posicionEnY();
        Casillero unCasillero = new Casillero(0, 0, 0);

        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                if(xPosicion == i && yPosicion == j) {
                    unCasillero = casilleros[i][j];
                    break;
                }
            }
        }
        return unCasillero;

    }

}
