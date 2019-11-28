package main.modelo.juego;

import main.modelo.tablero.Casillero;
import main.modelo.unidad.Unidad;

public interface Equipo {
    void colocar(Unidad unidad, Equipo equipo, Casillero casillero);
    void colocar(Unidad unidad, EquipoBlanco equipoBlanco, Casillero casillero);
    void colocar(Unidad unidad, EquipoNegro equipoNegro, Casillero casillero);
    void colocar(Unidad unidad, EquipoNull equipoNull, Casillero casillero);
}
