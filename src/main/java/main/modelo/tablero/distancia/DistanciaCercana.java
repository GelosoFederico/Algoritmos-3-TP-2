package main.modelo.tablero.distancia;

import main.modelo.unidad.Unidad;

public class DistanciaCercana extends Distancia {
    public DistanciaCercana(){}

    public DistanciaCercana(int distancia) {
        super(distancia);
    }

    public void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio) {
        distanciaPrototipo.daniarUnidadCercana(victima, danio);
    }

    public void daniarUnidadCercana(Unidad victima, int danio) {
        victima.recibirDanio(danio);
    }

}
