package main.modelo.unidad.movimiento;

import main.modelo.direccion.Direccion;
import main.modelo.excepciones.UnidadNoPuedeMoverseException;
import main.modelo.unidad.Unidad;

public class MovimientoEstatico implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        throw new UnidadNoPuedeMoverseException();
    }
}
