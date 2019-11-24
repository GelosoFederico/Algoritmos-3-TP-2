package Main.Unidad;

import Main.Unidad.Ataque.AtaqueLejano;

public class Catapulta extends RealUnidad {

    private static final int DANIO = 20;

    public Catapulta() {
        vida = 50;
        coste = 5;
        ataqueEstrategia = new AtaqueLejano(DANIO);
        movimientoEstrategia = new MovimientoEstatico();
    }

}
