package main.modelo.juego.fase;

import main.modelo.juego.Jugador;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;

public class TurnoMovimientoDisponible extends TurnoMovimiento {
    private FaseMoverYAtacar fase;

    public TurnoMovimientoDisponible(FaseMoverYAtacar fase) {
        this.fase = fase;
    }

    @Override
    public void moverUnidadDeJugadorHacia(Unidad unidad, Jugador jugador, Posicion posicion) {
        jugador.moverUnidadHacia(unidad, posicion);
        this.fase.movimientoUtilizado();
    }
}
