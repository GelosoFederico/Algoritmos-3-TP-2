package Main;

public class Catapulta extends Unidad{

    public Catapulta() {
        vida = 50;
        coste = 5;
        //casillero = null;
    }

    public Catapulta(int vidaInicial) {

        vida = vidaInicial;
        coste = 5;
        //casillero = null;
    }

    @Override
    public void atacar(Unidad unidad) {
        int danioLargaDistancia = 20;
        final int MIN_DISTANCIA_LARGA = 6;

        if (this.jugador.equals(unidad.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        //int distancia = casillero.calcularDistanciaA(unidad.getCasillero());

        //if(distancia < MIN_DISTANCIA_LARGA){
        //    throw new UnidadFueraDeRangoException();
        //}
        unidad.recibirDanio(danioLargaDistancia);
    }

    @Override
    public void avanzar(Direccion direccion) {
        throw new UnidadNoPuedeMoverseException();
    }

}
