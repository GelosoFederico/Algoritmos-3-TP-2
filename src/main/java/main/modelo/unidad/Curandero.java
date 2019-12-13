package main.modelo.unidad;

import main.modelo.excepciones.BandosNoCoincenExeption;
import main.modelo.excepciones.ProhibidoCurarUnidadEnemigaException;
import main.modelo.juego.BandoAliado;
import main.modelo.unidad.ataque.AtaqueCorto;

public class Curandero extends RealUnidad {
    private static final int DANIO_CURANDERO = -15;

    public Curandero(){
        vida = 75;
        coste = 5;
        ataqueEstrategia = new AtaqueCorto(DANIO_CURANDERO);
        bandoAtacable = new BandoAliado();
    }

    @Override
    public void validarAtaque(Unidad unidadVictima){
        try {
            bandoAtacable.permiteAtacar(this.equipo().identificarBando(unidadVictima.equipo()));
        }
        catch (BandosNoCoincenExeption e){
            throw new ProhibidoCurarUnidadEnemigaException();
        }
    }

    @Override
    public void atacar(Unidad unidad) {
        this.validarAtaque(unidad);
        this.ataqueEstrategia.atacar(this, unidad);
    }
}
