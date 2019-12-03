package main.modelo.unidad.movimiento;

import main.modelo.direccion.Direccion;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;
import main.modelo.unidad.movimiento.MovimientoEstrategia;

public class MovimientoRegular implements MovimientoEstrategia {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
    }
}
