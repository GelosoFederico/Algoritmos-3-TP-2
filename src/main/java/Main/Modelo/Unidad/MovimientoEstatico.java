package Main.Modelo.Unidad;

import Main.Modelo.Direccion.Direccion;
import Main.Modelo.Excepciones.UnidadNoPuedeMoverseException;

public class MovimientoEstatico implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        throw new UnidadNoPuedeMoverseException();
    }
}
