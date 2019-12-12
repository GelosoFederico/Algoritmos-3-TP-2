package main.modelo.juego.fase;

import main.modelo.juego.Jugador;
import main.modelo.unidad.Unidad;

public class TurnoAtaqueDisponible extends TurnoAtaque {
    private FaseMoverYAtacar fase;

    public TurnoAtaqueDisponible(FaseMoverYAtacar fase) {
        this.fase = fase;
    }

    @Override
    public void atacarConUnidadDeJugadorAUnidad(Unidad atacante, Jugador jugador, Unidad defensora) {
        jugador.atacarConUnidadAUnidad(atacante, defensora);
        this.fase.ataqueUtilizado();

    }
}
