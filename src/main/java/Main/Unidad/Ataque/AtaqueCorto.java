package Main.Unidad.Ataque;

import Main.Tablero.Cercana;
import Main.Tablero.Tablero;
import Main.Unidad.Unidad;

public class AtaqueCorto extends AtaqueEstrategia {

    public AtaqueCorto(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Cercana(), danio);
    }
}
