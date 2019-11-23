package Main.Unidad;

import Main.Excepciones.ProhibidoAtacarUnidadAliadaException;
import Main.Tablero.Tablero;
import Main.Excepciones.UnidadFueraDeRangoException;

public class AtaqueJineteArco implements AtaqueJinete {
    public void atacar(Unidad atacante, Unidad victima) {
        int danioMediaDistancia = 15;
        final int MIN_DISTANCIA_MEDIA = 3;
        final int MAX_DISTANCIA_MEDIA = 5;

        if (atacante.getJugador().equals(victima.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        int distancia = Tablero.getInstance().calcularDistanciaEntre(atacante, victima);

        if(distancia < MIN_DISTANCIA_MEDIA || distancia > MAX_DISTANCIA_MEDIA ){
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danioMediaDistancia);
    }
}
