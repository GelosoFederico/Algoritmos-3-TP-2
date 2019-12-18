package main.modelo.juego;

import main.modelo.excepciones.BandosNoCoincenExeption;

public class BandoAliado extends Bando{

    @Override
    public void permiteAtacar(Bando bando) {
        bando.permiteAtacar(this);
    }

    @Override
    public void permiteAtacar(BandoAliado bando) {
        //siga siga dice el juez
    }

    @Override
    public void permiteAtacar(BandoEnemigo bando) {
        throw new BandosNoCoincenExeption();
    }
}
