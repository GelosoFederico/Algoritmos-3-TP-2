package Main;

public class Casillero {
    Posicion posicion;
    String estado = "libre";
    int deJugador = 1;


    Casillero(int x, int y) {
        posicion = new Posicion(x,y);
        estado = "libre";
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
