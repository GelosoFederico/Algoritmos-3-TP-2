package Main.Unidad.Ataque;

import Main.Excepciones.ProhibidoAtacarUnidadAliadaException;
import Main.Tablero.Tablero;
import Main.Excepciones.UnidadFueraDeRangoException;
import Main.Unidad.Unidad;

public class AtaqueSoldado implements AtaqueEstrategia {
    public void atacar(Unidad atacante, Unidad victima) {
        int danioCortaDistancia = 10;
        final int MAX_DISTANCIA_CORTA = 2;
        // TODO: resolver tema unidad enemiga
        if (atacante.getJugador().equals(victima.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }

        int distancia = Tablero.getInstance().calcularDistanciaEntre(atacante, victima);
        if (distancia > MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danioCortaDistancia);
    }
}
