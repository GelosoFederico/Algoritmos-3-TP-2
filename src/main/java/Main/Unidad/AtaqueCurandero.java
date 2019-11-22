package Main.Unidad;

import Main.Excepciones.ProhibidoCurarUnidadEnemigaException;
import Main.Tablero.Tablero;
import Main.Excepciones.UnidadFueraDeRangoException;

public class AtaqueCurandero implements AtaqueEstrategia {
    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        int danioCortaDistancia = -15;
        final int MAX_DISTANCIA_CORTA = 2;
        if (!atacante.getJugador().equals(victima.getJugador())) {
            throw new ProhibidoCurarUnidadEnemigaException();
        }
        int distancia = Tablero.getInstance().calcularDistanciaEntre(atacante, victima);
        if (distancia > MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danioCortaDistancia);
    }
}
