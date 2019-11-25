package main.modelo.unidad.ataque;

import main.modelo.tablero.Distancia.Media;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;

public class AtaqueMedio extends AtaqueEstrategia {

    public AtaqueMedio(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Media(), danio);
    }
}