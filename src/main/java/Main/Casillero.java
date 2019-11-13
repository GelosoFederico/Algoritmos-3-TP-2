package Main;

public class Casillero {
    private Posicion posicion;
    private OcupacionState ocupacion;
    private int deJugador;
    private Unidad unidad;

    Casillero() {
    }
    Casillero(Posicion posicionAsignada, int numeroDeJugador) {
        posicion = posicionAsignada;
        deJugador = numeroDeJugador;
        ocupacion = new Libre();
        unidad = null;
    }

    public Posicion posicion() {
        return posicion;
    }

    public void ocupar() {
        ocupacion = this.ocupacion.ocupar();
    }

    public void liberar() {
        ocupacion = this.ocupacion.liberar();
    }

    public int deJugador() {
        return deJugador;
    }

    public Casillero obtenerSiguienteEnDireccion(String direccion) {
        Direccion direccionA = new Direccion(direccion);
        Posicion posicionNueva = this.posicion().sumar(direccionA.posicionRelativa());
        Casillero nuevoCasillero = Tablero.getInstance().obtenerCasilleroEnPosicion(posicionNueva);
        //TODO si el liberar lo hace aca el metodo tendria que ser con otro nombre
        this.liberar();
        return nuevoCasillero;
    }

    public void colocarUnidadDeJugador(Unidad unidad, Jugador jugador) {
        if (this.unidad != null)
            throw new CasilleroOcupadoException();

        if (jugador.numero() != this.deJugador()) {
            throw new CasilleroEsDeEnemigoException();
        }

        this.unidad = unidad;
    }
    public void guardarUnidad(Unidad unidad) {
        if (this.unidad != null)
            throw new CasilleroOcupadoException();
        this.unidad = unidad;
    }

    public int calcularDistanciaA(Casillero casillero) {
        return this.posicion().distanciaA(casillero.posicion());
    }

}
