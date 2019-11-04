package Main;

public class Casillero {
<<<<<<< HEAD
    Posicion posicion;
    String estado;
    int deJugador;

    Casillero(Posicion posicionAsignada, int numeroDeJugador) {
        posicion = posicionAsignada;
        estado = "libre";
        deJugador = numeroDeJugador;
    }

    Posicion posicion() {
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

    public Casillero obtenerSiguienteEnDireccion(String otraPosicion) {
        Casillero unCasillero = new Casillero();
        return unCasillero;
    }

    public int calcularDistanciaA(Casillero casillero) {
        return 1;
    }

    public Posicion getPosicion() {
        return posicion;
    }
}
