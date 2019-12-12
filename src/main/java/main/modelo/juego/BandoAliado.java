package main.modelo.juego;

public class BandoAliado extends Bando{

    @Override
    public Bando identificarBando(EquipoBlanco equipoBlanco, EquipoNegro equipoNegro) {
        return new BandoEnemigo();
    }

    @Override
    public Bando identificarBando(EquipoBlanco equipoBlanco1, EquipoBlanco equipoBlanco2) {
        return new BandoAliado();
    }

    @Override
    public Bando identificarBando(EquipoNegro equipoNegro, EquipoBlanco equipoBlanco) {
        return new BandoEnemigo();
    }

    @Override
    public Bando identificarBando(EquipoNegro equipoNegro1, EquipoNegro equipoNegro2) {
        return new BandoAliado();
    }
}
