package Main.Modelo.Unidad.Ataque;

import Main.Modelo.Tablero.Distancia.Cercana;
import Main.Modelo.Tablero.Tablero;
import Main.Modelo.Unidad.Unidad;

public class AtaqueCorto extends AtaqueEstrategia {

    public AtaqueCorto(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Cercana(), danio);
    }
}
