package main.modelo.tablero.Distancia;

import main.modelo.excepciones.UnidadFueraDeRangoException;
import main.modelo.unidad.Unidad;

public class DistanciaNula extends Distancia {
    public DistanciaNula() {
    }

    public DistanciaNula(int distancia) {
        super(distancia);
    }

    @Override
    public void daniarUnidadEnRango(Unidad victima, Distancia distanciaPrototipo, int danio) {
        throw new UnidadFueraDeRangoException();
    }
}
