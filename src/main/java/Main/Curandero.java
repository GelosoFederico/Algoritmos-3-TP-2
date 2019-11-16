package Main;

public class Curandero extends Unidad {

    public Curandero(){
        vida = 75;
        coste = 5;
    }

    public Curandero(int vidaInicial) {
        vida = vidaInicial;
        coste = 5;
    }

    @Override
    public void atacar(Unidad unidad) {
        int danioCortaDistancia = -15;
        final int MAX_DISTANCIA_CORTA = 2;
        if (!this.jugador.equals(unidad.getJugador())) {
            throw new ProhibidoCurarUnidadEnemigaException();
        }
        int distancia = Tablero.getInstance().calcularDistanciaEntre(this, unidad);
        if (distancia > MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        unidad.recibirDanio(danioCortaDistancia);
    }

}
