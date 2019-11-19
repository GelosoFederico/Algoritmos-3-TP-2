package Main;

public class Catapulta extends Unidad{

    public Catapulta() {
        vida = 50;
        coste = 5;
        ataqueEstrategia = new AtaqueCatapulta();
        movimientoEstrategia = new MovimientoEstatico();
    }

    public Catapulta(int vidaInicial) {

        vida = vidaInicial;
        coste = 5;
        ataqueEstrategia = new AtaqueCatapulta();
    }

    @Override
    public void atacar(Unidad unidad) {
        int danioLargaDistancia = 20;
        final int MIN_DISTANCIA_LARGA = 6;

        if (this.jugador.equals(unidad.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        int distancia = Tablero.getInstance().calcularDistanciaEntre(this, unidad);

        if(distancia < MIN_DISTANCIA_LARGA){
            throw new UnidadFueraDeRangoException();
        }
        unidad.recibirDanio(danioLargaDistancia);
    }
}
