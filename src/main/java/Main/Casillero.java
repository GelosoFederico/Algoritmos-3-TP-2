package Main;

public class Casillero {
    Posicion posicion;
    String estado = "libre";
    int deJugador = 1;


    Casillero(Posicion posicionAsignada) {
        posicion = posicionAsignada;
        estado = "libre";
    }

    static Casillero casilleroDeLaPosicion(Posicion posicion) {
        return Tablero.casilleroDeLaPosicion(posicion);
    }
    Posicion posicion() {
        return posicion;
    }

    public String estado() {
        return estado;
    }

    public void ocuparCasillero(Pieza unaPieza) {

        estado = "ocupado";
    }

    public void liberarCasillero() {
        estado = "libre";
    }

    //Ocupado
}
