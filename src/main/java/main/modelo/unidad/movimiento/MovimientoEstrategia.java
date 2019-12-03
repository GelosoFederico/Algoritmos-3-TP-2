package main.modelo.unidad.movimiento;

import main.modelo.direccion.Direccion;
import main.modelo.unidad.Unidad;

public interface MovimientoEstrategia {
    void avanzar(Unidad unidad, Direccion direccion);
}
