package Main;

public class Posicion {
    int _x;
    int _y;

    Posicion(int x,int y) {
        _x = x;
        _y = y;
    }

    public int posicionEnX() {
        return _x;
    }

    public int posicionEnY() {
        return _y;
    }

    // TODO: maybe string
}
