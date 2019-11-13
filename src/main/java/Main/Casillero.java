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
        ocupacion = this.ocupacion.liberar(); // TODO: esto creo que vuela
        unidad = null;
    }

    public int deJugador() {
        return deJugador;
    }


    public void colocarUnidadDeJugador(Unidad unidad, Jugador jugador) {
        if (this.unidad != null)
            throw new CasilleroOcupadoException();

        if (jugador.numero() != this.deJugador()) {
            throw new CasilleroEsDeEnemigoException();
        }

        this.unidad = unidad;
    }

    // TODO: pensar en un nombre mejor. Este se diferencia del metodo colocarUnidadDeJugador
    // porque no necesita validar si es del aliado o enemigo. Es para usar en
    // TODO: meter este dentro del colocar
    public void guardarUnidad(Unidad unidad) {
        if (this.unidad != null)
            throw new CasilleroOcupadoException();
        this.unidad = unidad;
    }

    public Unidad unidad() {
        return unidad;
    }

    public int calcularDistanciaA(Casillero casillero) {
        return this.posicion().distanciaA(casillero.posicion());
    }

}
