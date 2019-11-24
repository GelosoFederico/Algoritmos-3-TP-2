package Main.Tablero.Distancia;

import Main.Excepciones.UnidadFueraDeRangoException;
import Main.Unidad.Unidad;

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
