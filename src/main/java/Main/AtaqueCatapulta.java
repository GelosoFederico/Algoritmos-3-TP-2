package Main;

public class AtaqueCatapulta implements AtaqueEstrategia{
    public void atacar(Unidad atacante, Unidad victima) {
        int danioLargaDistancia = 20;
        final int MIN_DISTANCIA_LARGA = 6;

        if (atacante.getJugador().equals(victima.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        int distancia = Tablero.getInstance().calcularDistanciaEntre(atacante, victima);

        if(distancia < MIN_DISTANCIA_LARGA){
            throw new UnidadFueraDeRangoException();
        }
        victima.recibirDanio(danioLargaDistancia);
    }
}
