package Main.Unidad.Ataque;

import Main.Tablero.Media;
import Main.Tablero.Tablero;
import Main.Unidad.Unidad;

public class AtaqueMedio extends AtaqueEstrategia {

    public AtaqueMedio(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Media(), danio);
    }
}