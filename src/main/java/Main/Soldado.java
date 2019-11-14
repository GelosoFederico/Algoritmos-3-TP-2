package Main;

public class Soldado extends Unidad{

    public Soldado() {
        vida = 100;
        coste = 1;
    }

    public Soldado(int vidaInicial) {
        vida = vidaInicial;
        coste = 1;
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        int danioCortaDistancia = 10;
        final int MAX_DISTANCIA_CORTA = 2;
        if (this.jugador.equals(unidadEnemiga.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        int distancia = Tablero.getInstance().calcularDistanciaEntre(this, unidadEnemiga);
        if (distancia > MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        unidadEnemiga.recibirDanio(danioCortaDistancia);
    }

}
