package main.modelo.unidad.conjuntodeunidades;

import main.modelo.unidad.movimiento.MovimientoEstrategia;
import main.modelo.unidad.movimiento.MovimientoRegular;

public class BatallonIncompleto extends Batallon {

    public BatallonIncompleto(ConjuntoDeSoldados conjuntoDeSoldados) {
        super();
        this.estrategia = new MovimientoRegular();
        this.conjunto = conjuntoDeSoldados;
    }

    @Override
    public MovimientoEstrategia estrategia() {
        return this.estrategia;
    }
}
