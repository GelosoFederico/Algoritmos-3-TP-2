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
        Casillero nuevoCasillero = Juego.getInstance().tablero().obtenerCasilleroEnPosicion(posicionNueva);
        //TODO si el liberar lo hace aca el metodo tendria que ser con otro nombre
        this.liberar();
        return nuevoCasillero;
    }

    public int calcularDistanciaA(Casillero casillero) {
        return this.posicion().distanciaA(casillero.posicion());
    }

}
