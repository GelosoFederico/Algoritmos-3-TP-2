package main.modelo.tablero.distancia;

import main.modelo.unidad.Unidad;

public class DistanciaLejana extends Distancia {
    public DistanciaLejana(int distancia) {
        super(distancia);
    }

    public DistanciaLejana() {}

    public void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio) {
        distanciaPrototipo.daniarUnidadLejana(victima, danio);
    }

    public void daniarUnidadLejana(Unidad victima, int danio) {
        victima.recibirDanio(danio);
    }
}