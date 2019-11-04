package Main;

public class Soldado extends Unidad{

    private String posicion;
    private int vida;
    private Casillero casillero;
    private String jugador;
    private int coste = 1;

    public Soldado() {
        posicion = null;
        vida = 100;
        casillero = new Casillero();
    }

    public Soldado(int vidaInicial) {
        vida = vidaInicial;
    }

    public String getPosicion() {
        return this.posicion;
    }

    public void setPosicion(String unaPosicion) {
        this.posicion = unaPosicion;
    }

    public void setJugador(String jugador1) {
        jugador = jugador1;
    }

    public String getJugador() { return jugador; }

    public Casillero getCasillero() {
        return casillero;
    }

    public void colocarEn(Casillero unCasillero) {
        this.casillero = unCasillero;
    }

    public int vida() {
        return this.vida;
    }

    public int coste() {
        return coste;
    }

    @Override
    public void avanzar(String direccion) {
        Casillero nuevoCasillero = this.casillero.obtenerSiguienteEnDireccion(direccion);
        this.casillero = nuevoCasillero;
        this.posicion = direccion; /* REFACTOR pedir posicion a casillero */
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        int danioCortaDistancia = 10;
        final int MAX_DISTANCIA_CORTA = 2;
        if (this.jugador.equals(unidadEnemiga.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaExeption();
        }
        int distancia = casillero.calcularDistanciaA(unidadEnemiga.getCasillero());
        if (distancia >= MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        unidadEnemiga.recibirDanio(danioCortaDistancia);
    }

    @Override
    public void recibirDanio(int danio) {
        if(vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida = vida - danio;
    }

}
