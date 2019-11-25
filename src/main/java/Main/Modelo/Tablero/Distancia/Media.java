package Main.Modelo.Tablero.Distancia;

import Main.Modelo.Unidad.Unidad;

public class Media extends Distancia {
    public Media(int distancia) {
        super(distancia);
    }

    public Media() {}

    public void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio) {
        distanciaPrototipo.daniarUnidadMedia(victima, danio);
    }

    public void daniarUnidadMedia(Unidad victima, int danio) {
        victima.recibirDanio(danio);
    }

}
