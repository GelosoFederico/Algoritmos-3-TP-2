package Main;

public class Casillero {
    Posicion posicion;
    Casillero(int x, int y) {
        posicion = new Posicion(x,y);
    }

    Posicion posicion() {
        return posicion;
    }

    //Ocupado
}
