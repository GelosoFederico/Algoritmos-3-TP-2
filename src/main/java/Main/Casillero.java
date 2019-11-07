package Main;

public class Casillero {
    Posicion posicion;
    String estado;
    int deJugador;

    Casillero() {
        estado = "libre";
    }
    Casillero(Posicion posicionAsignada, int numeroDeJugador) {
        posicion = posicionAsignada;
        estado = "libre";
        deJugador = numeroDeJugador;
    }

    public Posicion posicion() {
        return posicion;
    }

    public String estado() {return estado;}

    public void ocupar() {
        estado = "ocupado";
    }

    public void liberar() {
        estado = "libre";
    }

    public int deJugador() {
        return deJugador;
    }

    public Casillero obtenerSiguienteEnDireccion(String direccion) {
        Direccion direccionA = new Direccion(direccion);
        Posicion posicionNueva = this.posicion().sumar(direccionA.posicionRelativa());
        Casillero nuevoCasillero = Juego.getInstance().tablero().obtenerCasilleroLibre(posicionNueva);
        //TODO si el liberar lo hace aca el metodo tendria que ser con otro nombre
        this.liberar();
        return nuevoCasillero;
    }

    public int calcularDistanciaA(Casillero casillero) {
        return this.posicion().distanciaA(casillero.posicion());
    }

}
