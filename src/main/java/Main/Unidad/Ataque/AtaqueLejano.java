package Main.Unidad.Ataque;

import Main.Tablero.Lejana;
import Main.Tablero.Tablero;
import Main.Unidad.Unidad;

public class AtaqueLejano extends AtaqueEstrategia {

    public AtaqueLejano(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Lejana(), danio);
    }
}
