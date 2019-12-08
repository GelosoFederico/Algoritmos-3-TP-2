package main.modelo.unidad.ataque;

import main.modelo.tablero.Tablero;
import main.modelo.tablero.distancia.Lejana;
import main.modelo.unidad.Unidad;

public abstract class AtaqueLejano extends AtaqueEstrategia  {
    AtaqueLejano(int danio) {
        super(danio);
    }

    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Lejana(), danio);
    }
}
