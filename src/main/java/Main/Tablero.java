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
        this.INSTANCE = new Tablero();
    }
    // TODO: sacar esto
    public Casillero obtenerCasilleroParaJugador(Posicion posicion, Jugador jugador) {
        Casillero casilleroBuscado = this.obtenerCasilleroEnPosicion(posicion);

        if (casilleroBuscado.deJugador() != jugador.numero())
            throw new CasilleroEsDeEnemigoException();
        return casilleroBuscado;
    }

    public void moverUnidadEnDireccion(Unidad unidad, String direccion) {
        Direccion direccionA = new Direccion(direccion);
        //Posicion posicionNueva = posicion().sumar(direccionA.posicionRelativa());
        //Casillero nuevoCasillero = Tablero.getInstance().obtenerCasilleroEnPosicion(posicionNueva);
        //nuevoCasillero.guardarUnidad(unidad);
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
