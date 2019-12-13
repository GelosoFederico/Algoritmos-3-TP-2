package main.modelo.unidad.conjuntodeunidades;

import main.modelo.unidad.movimiento.MovimientoEstrategia;
import main.modelo.unidad.movimiento.MovimientoRegular;

public abstract class Batallon {
    protected ConjuntoDeSoldados conjunto = new ConjuntoDeSoldados();
    protected MovimientoEstrategia estrategia;

    public abstract MovimientoEstrategia estrategia();
}
