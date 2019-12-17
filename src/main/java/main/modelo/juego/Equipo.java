package main.modelo.juego;

import main.modelo.tablero.Casillero;
import main.modelo.unidad.Unidad;

public abstract class Equipo {
    public abstract void colocar(Unidad unidad, Equipo equipo, Casillero casillero);
    public abstract void colocar(Unidad unidad, EquipoBlanco equipoBlanco, Casillero casillero);
    public abstract void colocar(Unidad unidad, EquipoNegro equipoNegro, Casillero casillero);
    public abstract void colocar(Unidad unidad, EquipoNull equipoNull, Casillero casillero);

    public abstract int calcularDanioFinal(Unidad unidad, int danio);
    public abstract int calcularDanioFinal(Unidad unidad, int danio, Equipo equipo);
    public abstract int calcularDanioFinal(Unidad unidad, int danio, EquipoBlanco equipoBlanco );
    public abstract int calcularDanioFinal(Unidad unidad, int danio, EquipoNegro equipoNegro );
    public abstract int calcularDanioFinal(Unidad unidad, int danio, EquipoNull equipoNull );

    public void mismoEquipoQue(Unidad unidad) {
        unidad.equipo().mismoEquipoQue(this);
    }

    public abstract void mismoEquipoQue(Equipo equipo);
    public abstract void mismoEquipoQue(EquipoNegro equipo);
    public abstract void mismoEquipoQue(EquipoBlanco equipo);

    Bando identificarBando(Equipo equipo);
    Bando identificarBando(EquipoNegro equipoNegro);
    Bando identificarBando(EquipoBlanco equipoBlanco);
}
