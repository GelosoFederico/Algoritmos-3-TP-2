package Main.Juego;

import Main.Excepciones.CasilleroEsDeEnemigoException;
import Main.Tablero.Casillero;
import Main.Unidad.Unidad;

public class EquipoNegro implements Equipo{
    @Override
    public void colocar(Unidad unidad, Equipo equipo, Casillero casillero) {
        equipo.colocar(unidad,this, casillero);
    }

    @Override
    public void colocar(Unidad unidad, EquipoBlanco equipoBlanco, Casillero casillero) {
        throw new CasilleroEsDeEnemigoException();
    }

    @Override
    public void colocar(Unidad unidad, EquipoNegro equipoNegro, Casillero casillero) {
        casillero.ocupar(unidad);
    }
}
