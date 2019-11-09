package Main;

import static java.lang.Math.abs;
import static java.lang.Math.max;

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

    public void sumarle(Posicion otraPosicion) {
        this._x = this.posicionEnX() + otraPosicion.posicionEnX();
        this._y = this.posicionEnY() + otraPosicion.posicionEnY();
    }

    public Posicion sumar(Posicion otraPosicion) {
        return new Posicion(this.posicionEnX() + otraPosicion.posicionEnX(),
                this.posicionEnY() + otraPosicion.posicionEnY() );
    }

    public int distanciaA(Posicion otraPosicion) {
        return otraPosicion.distanciaAPuntoEnXEY(this.posicionEnX(),this.posicionEnY());
    }

    public int distanciaAPuntoEnXEY(int x,int y){
        int distancia_x = abs(this.posicionEnX()-x);
        int distancia_y = abs(this.posicionEnY()-y);

        return max(distancia_x,distancia_y);
    }
    // TODO: maybe string
}
