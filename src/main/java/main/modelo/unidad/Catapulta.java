package main.modelo.unidad;

import main.modelo.unidad.ataque.AtaqueLejano;
import main.modelo.unidad.ataque.Expansion;
import main.modelo.unidad.movimiento.MovimientoEstatico;

public class Catapulta extends RealUnidad {

    private static final int DANIO = 20;

    public Catapulta() {
        this.vida = 50;
        this.coste = 5;
        this.ataqueEstrategia = new AtaqueLejano(DANIO);
        this.ataqueEstrategia.setPostEstrategia(new Expansion(DANIO));
        this.movimientoEstrategia = new MovimientoEstatico();
    }
}
