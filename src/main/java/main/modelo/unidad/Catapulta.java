package main.modelo.unidad;

import main.modelo.unidad.ataque.AtaqueLejanoConExpansion;

public class Catapulta extends RealUnidad {

    private static final int DANIO = 20;

    public Catapulta() {
        vida = 50;
        coste = 5;
        ataqueEstrategia = new AtaqueLejanoConExpansion(DANIO);
        movimientoEstrategia = new MovimientoEstatico();
    }
}
