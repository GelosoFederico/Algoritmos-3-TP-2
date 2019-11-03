package Main;

public class Casillero {
    Posicion posicion;
    String estado = "libre";
    int deJugador = 1;


    Casillero(Posicion posicionAsignada, int numeroDeJugador) {
        posicion = posicionAsignada;
        estado = "libre";
        deJugador = numeroDeJugador;
    }

    public Casillero(int i, int j, int numeroDeJugador) {
        posicion = new Posicion(i, j);
        estado = "libre";
        deJugador = numeroDeJugador;
    }

    static Casillero casilleroDeLaPosicion(Posicion posicion) {
        return Tablero.casilleroDeLaPosicion(posicion);
    }
    Posicion posicion() {
        return posicion;
    }

    public String estado() {return estado;}

    public void setEstado(String string) {
        estado = "ocupado";
    }
    public void ocuparCasillero(Pieza unaPieza) {
        estado = "ocupado";
    }

    public void liberarCasillero() {
        estado = "libre";
    }

    //Ocupado
}
