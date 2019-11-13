package Main;

public class Curandero extends Unidad {

    public Curandero(){
        vida = 75;
        coste = 5;
        //casillero = null;
    }

    public Curandero(int vidaInicial) {
        vida = vidaInicial;
        coste = 5;
        //casillero = null;
    }

    @Override
    public void atacar(Unidad unidad) {
        int danioCortaDistancia = -15;
        final int MAX_DISTANCIA_CORTA = 2;
        if (!this.jugador.equals(unidad.getJugador())) {
            throw new ProhibidoCurarUnidadEnemigaException();
        }
        //int distancia = casillero.calcularDistanciaA(unidad.getCasillero());
        //if (distancia >= MAX_DISTANCIA_CORTA) {
        //    throw new UnidadFueraDeRangoException();
        //}
        unidad.recibirDanio(danioCortaDistancia);
    }

}
