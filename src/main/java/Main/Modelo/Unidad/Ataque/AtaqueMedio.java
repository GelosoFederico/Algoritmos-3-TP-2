package Main.Modelo.Unidad.Ataque;

import Main.Modelo.Tablero.Distancia.Media;
import Main.Modelo.Tablero.Tablero;
import Main.Modelo.Unidad.Unidad;

public class AtaqueMedio extends AtaqueEstrategia {

    public AtaqueMedio(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Media(), danio);
    }
}