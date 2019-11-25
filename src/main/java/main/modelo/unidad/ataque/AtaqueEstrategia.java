package main.modelo.unidad.ataque;

import main.modelo.unidad.Unidad;

public abstract class AtaqueEstrategia {
    protected int danio;

    public AtaqueEstrategia(int danio) {
        this.danio = danio;
    }

    public abstract void atacar(Unidad atacante, Unidad victima);
}
