package main.modelo.juego;

import main.modelo.excepciones.IntentarColocarUnaUnidadNulaException;
import main.modelo.tablero.Casillero;
import main.modelo.unidad.Unidad;

public class EquipoNull implements Equipo {
    @Override
    public void colocar(Unidad unidad, Equipo equipo, Casillero casillero) {
        equipo.colocar(unidad,this, casillero);
    }
    @Override
    public void colocar(Unidad unidad, EquipoBlanco equipoBlanco, Casillero casillero) {
        throw new IntentarColocarUnaUnidadNulaException();
    }

    @Override
    public void colocar(Unidad unidad, EquipoNegro equipoNegro, Casillero casillero) {
        throw new IntentarColocarUnaUnidadNulaException();
    }

    @Override
    public void colocar(Unidad unidad, EquipoNull equipoNull, Casillero casillero) {
        throw new IntentarColocarUnaUnidadNulaException();
    }
}
