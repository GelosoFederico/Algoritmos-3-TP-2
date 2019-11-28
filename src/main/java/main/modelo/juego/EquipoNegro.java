package main.modelo.juego;

import main.modelo.excepciones.CasilleroEsDeEnemigoException;
import main.modelo.tablero.Casillero;
import main.modelo.unidad.Unidad;

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
