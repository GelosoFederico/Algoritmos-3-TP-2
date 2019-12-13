package main.modelo.juego;

public abstract class Bando {

    public abstract void permiteAtacar(Bando bando);
    public abstract void permiteAtacar(BandoAliado bando);
    public abstract void permiteAtacar(BandoEnemigo bando);
}
