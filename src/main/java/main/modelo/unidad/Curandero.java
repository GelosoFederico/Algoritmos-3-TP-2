package main.modelo.unidad;

import main.modelo.excepciones.ProhibidoCurarUnidadEnemigaException;
import main.modelo.unidad.ataque.AtaqueCorto;

public class Curandero extends RealUnidad {
    private static final int DANIO_CURANDERO = -15;

    public Curandero(){
        vida = 75;
        coste = 5;
        ataqueEstrategia = new AtaqueCorto(DANIO_CURANDERO);
    }

    @Override
    public void atacar(Unidad unidad) {
        if (!this.getJugador().equals(unidad.getJugador())) {
            throw new ProhibidoCurarUnidadEnemigaException();
        }
        this.ataqueEstrategia.atacar(this, unidad);
    }

}
