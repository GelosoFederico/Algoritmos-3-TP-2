package Main.Unidad.Ataque;

import Main.Unidad.Unidad;

public interface AtaqueJinete extends AtaqueEstrategia {
    void atacar(Unidad atacante, Unidad victima);
}
