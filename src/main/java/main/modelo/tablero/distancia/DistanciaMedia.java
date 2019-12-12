package main.modelo.tablero.distancia;

import main.modelo.unidad.Unidad;

public class DistanciaMedia extends Distancia {
    public DistanciaMedia(int distancia) {
        super(distancia);
    }

    public DistanciaMedia() {}

    public void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio) {
        distanciaPrototipo.daniarUnidadMedia(victima, danio);
    }

    public void daniarUnidadMedia(Unidad victima, int danio) {
        victima.recibirDanio(danio);
    }

}
