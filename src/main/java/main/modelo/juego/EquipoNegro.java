package main.modelo.juego;

import main.modelo.excepciones.CasilleroEsDeEnemigoException;
import main.modelo.excepciones.EquiposDistintosException;
import main.modelo.excepciones.IntentarColocarUnaUnidadNulaException;
import main.modelo.tablero.Casillero;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;

public class EquipoNegro extends Equipo{
    private static final double PORCENTAJE_DANIO_EXTRA = 1.05;

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

    @Override
    public void colocar(Unidad unidad, EquipoNull equipoNull, Casillero casillero) {
        throw new IntentarColocarUnaUnidadNulaException();
    }


    @Override
    public int calcularDanioFinal(Unidad unidad, int danio) {
        return this.calcularDanioFinal(unidad, danio,
                Tablero.getInstance().obtenerCasilleroEnPosicion(unidad.posicion()).equipo());
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, Equipo equipo ) {
        return equipo.calcularDanioFinal(unidad, danio, this);
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, EquipoNegro equipoBlanco ) {
        return danio;
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, EquipoBlanco equipoBlanco ) {
        return (int)Math.ceil(danio * PORCENTAJE_DANIO_EXTRA);
    }

    @Override
    public int calcularDanioFinal(Unidad unidad, int danio, EquipoNull equipoNull ) {
        return danio;
    }

    @Override
    public void mismoEquipoQue(Equipo equipo) {
        equipo.mismoEquipoQue(this);
    }

    @Override
    public void mismoEquipoQue(EquipoNegro equipo) {

    }

    @Override
    public void mismoEquipoQue(EquipoBlanco equipo) {
        throw new EquiposDistintosException();
    }

}
