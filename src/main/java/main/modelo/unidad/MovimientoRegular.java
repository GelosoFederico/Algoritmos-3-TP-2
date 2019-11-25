package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.tablero.Tablero;

public class MovimientoRegular implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
    }
}
