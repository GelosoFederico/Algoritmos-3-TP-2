package Main.Unidad.Ataque;

import Main.Tablero.Tablero;
import Main.Unidad.Unidad;

public class AtaqueLejano extends AtaqueEstrategia {

    public AtaqueLejano(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarEnDistanciaLejana(atacante, victima, danio);
    }
}
