package main.modelo.unidad.ataque;

import main.modelo.tablero.distancia.Lejana;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;

public class AtaqueLejanoNormal extends AtaqueLejano {


    public AtaqueLejanoNormal(int danio) { super(danio); }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Lejana(), danio);
    }
}