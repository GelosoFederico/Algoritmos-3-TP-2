package main.modelo.unidad.conjuntodeunidades;

import main.modelo.unidad.movimiento.MovimientoEnBatallon;
import main.modelo.unidad.movimiento.MovimientoEstrategia;

public class BatallonCompleto extends Batallon {
    public BatallonCompleto(ConjuntoDeSoldados conjuntoDeSoldados) {
        super();
        this.conjunto = conjuntoDeSoldados;
        this.estrategia = new MovimientoEnBatallon(conjuntoDeSoldados);
    }

    @Override
    public MovimientoEstrategia estrategia() {
        return this.estrategia;
    }
}
