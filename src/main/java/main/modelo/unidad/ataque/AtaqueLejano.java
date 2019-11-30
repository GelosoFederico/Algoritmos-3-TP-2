package main.modelo.unidad.ataque;

import main.modelo.tablero.Distancia.Lejana;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;

public class AtaqueLejano extends AtaqueEstrategia {

    public AtaqueLejano(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Lejana(), danio);
        Tablero.getInstance().obtenerUnidadesAlrededorDe(victima, 1, new ConjuntoDeUnidades());
    }
}
