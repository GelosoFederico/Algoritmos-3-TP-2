package Main;

public class Casillero {
    private Posicion posicion;
    private OcupacionState ocupacion;
    private int deJugador;


    Casillero() {
    }
    Casillero(Posicion posicionAsignada, int numeroDeJugador) {
        posicion = posicionAsignada;
        deJugador = numeroDeJugador;
        ocupacion = new Libre();

    }

    public Posicion posicion() {
        return posicion;
    }

    public void ocupar(Unidad unaUnidad) {
        ocupacion = this.ocupacion.ocupar(unaUnidad);
    }

    public void liberar() {
        ocupacion = this.ocupacion.liberar(); // TODO: esto creo que vuela

    }

    public int deJugador() {
        return deJugador;
    }


    public void colocarUnidadDeJugador(Unidad unidad, Jugador jugador) {

        if (jugador.numero() != this.deJugador()) {
            throw new CasilleroEsDeEnemigoException();
        }

        this.ocupar(unidad);
    }

    // TODO: pensar en un nombre mejor. Este se diferencia del metodo colocarUnidadDeJugador
    // porque no necesita validar si es del aliado o enemigo. Es para usar en
    // TODO: meter este dentro del colocar
    public void guardarUnidad(Unidad unidad) { this.ocupar(unidad); }

    public Unidad obtenerUnidad() {
        return this.ocupacion.ocupante();
    }

    public int calcularDistanciaA(Casillero casillero) {
        return this.posicion().distanciaA(casillero.posicion());
    }

}
