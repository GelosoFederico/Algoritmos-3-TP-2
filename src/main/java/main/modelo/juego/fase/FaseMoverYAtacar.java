package main.modelo.juego.fase;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;

public class FaseMoverYAtacar extends Fase {
    private TurnoMovimiento turnoMovimiento;
    private TurnoAtaque turnoAtaque;

    public FaseMoverYAtacar(Juego juego) {
        super(juego);
        this.turnoMovimiento = new TurnoMovimientoDisponible(this);
        this.turnoAtaque = new TurnoAtaqueDisponible(this);
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        throw new JuegoNoPuedeTenerMasDe2JugadoresException();
    }

    @Override
    public void cambiarJugadorDeTurno() {
        this.juego.cambiarJugadorDeTurnoDirecto();
        this.renovarAcciones();
    }

    private void renovarAcciones() {
        this.turnoMovimiento = new TurnoMovimientoDisponible(this);
        this.turnoAtaque = new TurnoAtaqueDisponible(this);
    }

    @Override
    public void removerJugador() {

    }

    public void movimientoUtilizado() {
        this.turnoMovimiento = new TurnoMovimientoAgotado();
    }

    public void ataqueUtilizado() {
        this.turnoAtaque = new TurnoAtaqueAgotado();
    }

    public void moverUnidadHacia(Unidad unidad, Posicion posicion){
        this.turnoMovimiento.moverUnidadDeJugadorHacia(unidad,juego.getJugadorDeTurno(), posicion);
    }

    @Override
    public void atacarConUnidadAUnidad(Unidad atacante, Unidad defensora) {
        this.turnoAtaque.atacarConUnidadDeJugadorAUnidad(atacante,juego.getJugadorDeTurno(), defensora);
    }

}
