package Main.Modelo.Unidad.Ataque;

import Main.Modelo.Tablero.Distancia.Lejana;
import Main.Modelo.Tablero.Tablero;
import Main.Modelo.Unidad.Unidad;

public class AtaqueLejano extends AtaqueEstrategia {

    public AtaqueLejano(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Lejana(), danio);
    }
}
