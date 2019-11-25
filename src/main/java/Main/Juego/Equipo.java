package Main.Juego;

import Main.Tablero.Casillero;
import Main.Unidad.Unidad;
public interface Equipo {
    void colocar(Unidad unidad, Equipo equipo, Casillero casillero);
    void colocar(Unidad unidad, EquipoBlanco equipoBlanco, Casillero casillero);
    void colocar(Unidad unidad, EquipoNegro equipoNegro, Casillero casillero);
}
