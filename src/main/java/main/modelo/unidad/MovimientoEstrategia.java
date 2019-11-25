package main.modelo.unidad;

import main.modelo.direccion.Direccion;

public interface MovimientoEstrategia {
    void avanzar(Unidad unidad, Direccion direccion);
}
