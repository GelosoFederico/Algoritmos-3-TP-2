package main.modelo.unidad.ataque;

import main.modelo.tablero.Tablero;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;

public abstract class AtaqueEstrategia {
    protected int danio;
    protected ModificadorAtaque postEstrategia;

    public AtaqueEstrategia(int danio) {
        this.danio = danio;
        this.postEstrategia = new ModificadorAtaqueNulo();
    }

    public void atacar(Unidad atacante, Unidad victima) {
        Posicion posicionVictima = victima.posicion();
        this.atacarUnidad(atacante, victima);
        this.postEstrategia.ejecutar(Tablero.getInstance().getUnidadEnPosicion(posicionVictima));
    }

    public abstract void atacarUnidad(Unidad atacante, Unidad victima);

    public void setPostEstrategia(ModificadorAtaque mod){
        this.postEstrategia = mod;
    }
}
