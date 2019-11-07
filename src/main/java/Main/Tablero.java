package Main;

public class Tablero {

    int maximaCantidadDeCasilleros = 20;

    Casillero[][] casilleros = new Casillero[maximaCantidadDeCasilleros][maximaCantidadDeCasilleros];

    public Tablero(){
        this.crearCasilleros();
    }

    static Casillero casilleroDeLaPosicion(Posicion posicion) {
        return new Casillero(posicion, 1);
    }

    Casillero obtenerCasilleroLibre(Posicion posicion) {
        Casillero casilleroBuscado = this.obtenerCasilleroEnPosicion(posicion);
        if (casilleroBuscado.estado().equals("ocupado"))
            throw new CasilleroOcupadoException();
        return casilleroBuscado;
    }

    Casillero obtenerCasilleroLibreParaJugador(Posicion posicion, Jugador jugador) {
        Casillero casilleroBuscado = this.obtenerCasilleroEnPosicion(posicion);

        if (casilleroBuscado.estado().equals("ocupado"))
            throw new CasilleroOcupadoException();
        else if (casilleroBuscado.deJugador() != jugador.numero())
            throw new CasilleroEsDeEnemigoException();
        return casilleroBuscado;
    }

    static Casillero obtenerCasilleroDePosicion(Posicion posicion) {
        // TODO: A completar. Puse cualquier cosa.
        return new Casillero(posicion,1);
    }

    public void crearCasilleros() {
        int numeroDeJugador;
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            if (i < maximaCantidadDeCasilleros/2)
                numeroDeJugador = 1;
            else
                numeroDeJugador = 2;
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                    casilleros[i][j] = new Casillero(new Posicion(i,j), numeroDeJugador);
            }
        }
    }

    public Casillero obtenerCasilleroEnPosicion(Posicion posicion) {

        int xPosicion = posicion.posicionEnX();
        int yPosicion = posicion.posicionEnY();

        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                if(xPosicion == i && yPosicion == j) {
                    return casilleros[i][j];
                }
            }
        }

        throw new NoSeEncontroElCasilleroException();

    }
}
