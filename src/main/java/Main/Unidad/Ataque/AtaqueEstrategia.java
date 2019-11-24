package Main.Unidad.Ataque;

import Main.Unidad.Unidad;

public abstract class AtaqueEstrategia {
    protected int danio;

    public AtaqueEstrategia(int danio) {
        this.danio = danio;
    }

    public abstract void atacar(Unidad atacante, Unidad victima);
}
