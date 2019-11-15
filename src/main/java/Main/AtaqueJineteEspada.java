package Main;

public class AtaqueJineteEspada implements AtaqueJinete {
    public void atacar(Unidad atacante, Unidad victima) {
        // TODO: Danio podria ser un atributo de cada subclase, si fuese clase abstracta
        int danioCortaDistancia = 5;
        final int MIN_DISTANCIA_CORTA = 1;
        final int MAX_DISTANCIA_CORTA = 2;

        if (atacante.getJugador().equals(victima.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        int distancia = Tablero.getInstance().calcularDistanciaEntre(atacante, victima);

        if(distancia < MIN_DISTANCIA_CORTA || distancia > MAX_DISTANCIA_CORTA ){
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danioCortaDistancia);
    }
}
