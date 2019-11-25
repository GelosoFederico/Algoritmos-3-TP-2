package Main.Modelo.Unidad;

import Main.Modelo.Direccion.Direccion;
import Main.Modelo.Tablero.Tablero;

public class MovimientoRegular implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
    }
}
