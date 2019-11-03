package Main;

public class Jinete extends Unidad {

    private String posicion;
    private int vida;
    private Casillero casillero;
    private String jugador;
    private int costo;

    public Jinete(int vidaInicial) {
        vida = vidaInicial;
    }

    public Jinete() {
        vida = 100;
        casillero = new Casillero();
    }

    public void setPosicion(String unaPosicion) {
        this.posicion = unaPosicion;
    }

    @Override
    public void avanzar(String direccion) {
        Casillero nuevoCasillero = this.casillero.obtenerSiguienteEnDireccion(direccion);
        this.casillero = nuevoCasillero;
        this.posicion = direccion; /* REFACTOR pedir posicion a casillero */

    }

    @Override
    public int coste() {
        return costo;
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        int danioMediaDistancia = 15;
        final int MIN_DISTANCIA_MEDIA = 3;
        final int MAX_DISTANCIA_MEDIA = 5;

        if (this.jugador.equals(unidadEnemiga.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaExeption();
        }
        int distancia = casillero.calcularDistanciaA(unidadEnemiga.getCasillero());

        if(distancia < MIN_DISTANCIA_MEDIA || distancia > MAX_DISTANCIA_MEDIA ){
            throw new UnidadFueraDeRangoException();
        }
        unidadEnemiga.recibirDanio(danioMediaDistancia);
    }

    public void recibirDanio(int ataqueMediaDistancia) {
        if(vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        this.vida = this.vida - ataqueMediaDistancia;
    }

    @Override
    public Casillero getCasillero() {
        return casillero;
    }

    @Override
    public String getJugador() {
        return jugador;
    }

    public int vida() {
        return vida;
    }

    public void colocarEn(Casillero unCasillero) {
        casillero = unCasillero;
    }

    public void setJugador(String unJugador) {
        jugador = unJugador;
    }
}
