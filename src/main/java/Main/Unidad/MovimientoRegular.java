package Main.Unidad;

import Main.Direccion.Direccion;
import Main.Tablero.Tablero;

public class MovimientoRegular implements Movible {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
    }
}
