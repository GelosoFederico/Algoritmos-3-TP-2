package main.modelo.direccion;

import main.modelo.tablero.Distancia.Distancia;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Posicion {
    int x;
    int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int posicionEnX() {
        return x;
    }

    public int posicionEnY() {
        return y;
    }

    public void sumarle(Posicion otraPosicion) {
        this.x = this.posicionEnX() + otraPosicion.posicionEnX();
        this.y = this.posicionEnY() + otraPosicion.posicionEnY();
    }

    public Posicion sumar(Posicion otraPosicion) {
        return new Posicion(this.posicionEnX() + otraPosicion.posicionEnX(),
                this.posicionEnY() + otraPosicion.posicionEnY() );
    }

    public Distancia distanciaA(Posicion otraPosicion) {
        return otraPosicion.distanciaAPuntoEnXEY(this.posicionEnX(),this.posicionEnY());
    }

    public Distancia distanciaAPuntoEnXEY(int x,int y){
        int distancia_x = abs(this.posicionEnX()-x);
        int distancia_y = abs(this.posicionEnY()-y);

        return Distancia.crearDistancia(max(distancia_x,distancia_y));
    }
}
