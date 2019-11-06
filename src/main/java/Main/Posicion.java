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

    public void incrementarPosicionEnX() { _x = _x + 1; }

    public void decrementarPosicionEnX() { _x = _x - 1; }

    public void decrementarPosicionEnY() { _y = _y - 1; }

    public void incrementarPosicionEnY() { _y = _y + 1; }

    // TODO: maybe string
}
