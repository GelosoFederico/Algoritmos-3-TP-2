package Main;

public class Soldado extends Unidad{

    public Soldado() {
        vida = 100;
        coste = 1;
        casillero = null;
    }

    public Soldado(int vidaInicial) {
        vida = vidaInicial;
        coste = 1;
        casillero = null;
    }

    @Override
    public void avanzar(String direccion) {
        this.casillero = this.casillero.obtenerSiguienteEnDireccion(direccion);
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        int danioCortaDistancia = 10;
        final int MAX_DISTANCIA_CORTA = 2;
        if (this.jugador.equals(unidadEnemiga.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        int distancia = casillero.calcularDistanciaA(unidadEnemiga.getCasillero());
        if (distancia >= MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        unidadEnemiga.recibirDanio(danioCortaDistancia);
    }

}
