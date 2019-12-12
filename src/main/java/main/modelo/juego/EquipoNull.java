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

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio) {
        return danio;
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, Equipo equipo ) {
        return danio;
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, EquipoBlanco equipoBlanco ) {
        return danio;
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, EquipoNegro equipoNegro ) {
        return danio;
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, EquipoNull equipoNull ) {
        return danio;
    }

    @Override
    public Bando identificarBando(Equipo equipo) {
        return null;
    }

    @Override
    public Bando identificarBando(EquipoNegro equipoNegro) {
        return null;
    }

    @Override
    public Bando identificarBando(EquipoBlanco equipoBlanco) {
        return null;
    }

}
