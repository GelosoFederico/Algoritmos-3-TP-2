package Main.Unidad;

import Main.Direccion.Direccion;
import Main.Tablero.Tablero;

public class MovimientoRegular implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
    }
}
