package Main;

public class Jinete extends Unidad {

    public Jinete() {
        vida = 100;
        coste = 3;
        casillero = null;
    }

    public Jinete(int vidaInicial) {

        vida = vidaInicial;
        coste = 3;
        casillero = null;
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        int danioMediaDistancia = 15;
        final int MIN_DISTANCIA_MEDIA = 3;
        final int MAX_DISTANCIA_MEDIA = 5;

        if (this.jugador.equals(unidadEnemiga.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        int distancia = casillero.calcularDistanciaA(unidadEnemiga.getCasillero());

        if(distancia < MIN_DISTANCIA_MEDIA || distancia > MAX_DISTANCIA_MEDIA ){
            throw new UnidadFueraDeRangoException();
        }
        unidadEnemiga.recibirDanio(danioMediaDistancia);
    }

}
