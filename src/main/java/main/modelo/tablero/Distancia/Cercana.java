package main.modelo.tablero.Distancia;

import main.modelo.unidad.Unidad;

public class Cercana extends Distancia {
    public Cercana(){}

    public Cercana(int distancia) {
        super(distancia);
    }

    public void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio) {
        distanciaPrototipo.daniarUnidadCercana(victima, danio);
    }

    public void daniarUnidadCercana(Unidad victima, int danio) {
        victima.recibirDanio(danio);
    }

}
