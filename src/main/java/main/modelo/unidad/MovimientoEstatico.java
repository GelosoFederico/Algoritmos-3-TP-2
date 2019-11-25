package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.excepciones.UnidadNoPuedeMoverseException;

public class MovimientoEstatico implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        throw new UnidadNoPuedeMoverseException();
    }
}
