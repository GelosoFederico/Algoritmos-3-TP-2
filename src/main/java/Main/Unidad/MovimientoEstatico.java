package Main.Unidad;

import Main.Direccion.Direccion;
import Main.Excepciones.UnidadNoPuedeMoverseException;

public class MovimientoEstatico implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        throw new UnidadNoPuedeMoverseException();
    }
}
