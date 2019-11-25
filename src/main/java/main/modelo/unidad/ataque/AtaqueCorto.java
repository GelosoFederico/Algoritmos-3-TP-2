package main.modelo.unidad.ataque;

import main.modelo.tablero.Distancia.Cercana;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;

public class AtaqueCorto extends AtaqueEstrategia {

    public AtaqueCorto(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Cercana(), danio);
    }
}
