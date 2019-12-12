package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.unidad.ataque.AtaqueCorto;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.movimiento.MovimientoEnBatallon;
import main.modelo.unidad.movimiento.MovimientoEstrategia;
import main.modelo.unidad.movimiento.MovimientoRegular;

import java.util.Iterator;

public class Soldado extends RealUnidad {

    private static final int DANIO = 10;

    public Soldado() {
        vida = 100;
        coste = 1;
        ataqueEstrategia = new AtaqueCorto(DANIO);
    }

    @Override
    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados) {
        conjuntoDeSoldados.agregarSoldado(this);
    }

    public ConjuntoDeSoldados obtenerBatallon() {
        ConjuntoDeSoldados batallon = new ConjuntoDeSoldados();
        return batallon.formarBatallon(this);
    }

    public MovimientoEstrategia obtenerEstrategiaDeMovimiento() {
        MovimientoEstrategia estrategia = new MovimientoRegular(); // Estrategia por default
        ConjuntoDeSoldados batallon = obtenerBatallon();
        if (batallon.cantidad() == 3)
            estrategia = new MovimientoEnBatallon(batallon);
        return estrategia;
    }

    @Override
    public void avanzar(Direccion direccion) {
        this.movimientoEstrategia = this.obtenerEstrategiaDeMovimiento();
        this.movimientoEstrategia.avanzar(this, direccion);
    }
}
