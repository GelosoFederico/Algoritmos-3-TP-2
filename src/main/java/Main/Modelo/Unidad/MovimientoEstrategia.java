package Main.Modelo.Unidad;

import Main.Modelo.Direccion.Direccion;

public interface MovimientoEstrategia {
    void avanzar(Unidad unidad, Direccion direccion);
}
