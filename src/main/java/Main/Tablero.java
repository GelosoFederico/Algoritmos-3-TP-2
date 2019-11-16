package Main;

public class Tablero {
    // Singleton pattern
    private static Tablero INSTANCE = new Tablero();

    int maximaCantidadDeCasilleros = 20;

    Casillero[][] casilleros = new Casillero[maximaCantidadDeCasilleros][maximaCantidadDeCasilleros];

    public Tablero(){
        this.crearCasilleros();
    }
    public static Tablero getInstance() {
        return INSTANCE;
    }
    public void reiniciar() {
        INSTANCE = new Tablero();
    }
    // TODO: sacar esto
    public Casillero obtenerCasilleroParaJugador(Posicion posicion, Jugador jugador) {
        Casillero casilleroBuscado = this.obtenerCasilleroEnPosicion(posicion);

        if (casilleroBuscado.deJugador() != jugador.numero())
            throw new CasilleroEsDeEnemigoException();
        return casilleroBuscado;
    }
    public Posicion obtenerPosicionDeUnidad(Unidad unidad) {
        // TODO: Refactorizar maybe
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                if( unidad == casilleros[i][j].unidad()) {
                    return casilleros[i][j].posicion();
                }
            }
        }
        throw new UnidadNoSeEncuentraEnTablero();
    }
    public void moverUnidadEnDireccion(Unidad unidad, Direccion direccion) {

        Posicion posicionActual = this.obtenerPosicionDeUnidad(unidad);
        Casillero casilleroActual = this.obtenerCasilleroEnPosicion(posicionActual);

        Posicion posicionNueva = posicionActual.sumar(direccion.posicionRelativa());
        Casillero casilleroNuevo = this.obtenerCasilleroEnPosicion(posicionNueva);

        casilleroNuevo.guardarUnidad(unidad);
        casilleroActual.liberar();
    }

    public void colocarUnidadEnPosicionDeJugador(Unidad unidad, Posicion posicion, Jugador jugador) {
        this.obtenerCasilleroEnPosicion(posicion).colocarUnidadDeJugador(unidad,jugador);
    }

    private void crearCasilleros() {
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

        return casilleros[posicion.posicionEnX()][posicion.posicionEnY()];
    }

    public int calcularDistanciaEntre(Unidad unidad1, Unidad unidad2) {
        Posicion pos1 = this.obtenerPosicionDeUnidad(unidad1);
        Posicion pos2 = this.obtenerPosicionDeUnidad(unidad2);
        return pos1.distanciaA(pos2);
    }

    public ConjuntoDeUnidades obtenerUnidadesAlrededorDe(Unidad unidadCentro, int distanciaMaxima, ConjuntoDeUnidades conjunto) {
        // TODO agregar iterador para que este codigo no se repita
        for(int i = 0; i < maximaCantidadDeCasilleros ; i++ ){
            for(int j = 0; j < maximaCantidadDeCasilleros ; j++ ) {
                // TODO esto se debe resolver con la unidad nula
                if (this.casilleros[i][j].unidad() != null) {
                    int distancia = this.calcularDistanciaEntre(unidadCentro,this.casilleros[i][j].unidad());
                    if( (distancia <= distanciaMaxima) && (distancia > 0) ) {
                        conjunto.agregar(this.casilleros[i][j].unidad());
                    }
                }
            }
        }
        return conjunto;
    }
}
