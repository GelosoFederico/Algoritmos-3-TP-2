package Main.Tablero.Distancia;

import Main.Unidad.Unidad;

public class Lejana extends Distancia {
    public Lejana(int distancia) {
        super(distancia);
    }

    public Lejana() {}

    public void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio) {
        distanciaPrototipo.daniarUnidadLejana(victima, danio);
    }

    public void daniarUnidadLejana(Unidad victima, int danio) {
        victima.recibirDanio(danio);
    }
}