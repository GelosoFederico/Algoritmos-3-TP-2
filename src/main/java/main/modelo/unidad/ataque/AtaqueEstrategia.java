package main.modelo.unidad.ataque;

import main.modelo.unidad.Unidad;

public abstract class AtaqueEstrategia {
    protected int danio;
    protected ModificadorAtaque postEstrategia;

    public AtaqueEstrategia(int danio) {
        this.danio = danio;
        this.postEstrategia = new ModificadorNulo();
    }

    public void atacar(Unidad atacante, Unidad victima) {
        this.atacarUnidad(atacante, victima);
        this.postEstrategia.ejecutar(victima);
    }

    public abstract void atacarUnidad(Unidad atacante, Unidad victima);

    public void setPostEstrategia(ModificadorAtaque mod){
        this.postEstrategia = mod;
    }
}
