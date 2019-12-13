package main.modelo.juego;

import main.modelo.excepciones.BandosNoCoincenExeption;

public class BandoEnemigo extends Bando {
    @Override
    public void permiteAtacar(Bando bando) {
        bando.permiteAtacar(this);
    }

    @Override
    public void permiteAtacar(BandoAliado bando) {
        throw new BandosNoCoincenExeption();
    }

    @Override
    public void permiteAtacar(BandoEnemigo bando) {
        //siga siga dice el juez
    }
}
