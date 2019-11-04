package Main;

public class Curandero extends Unidad {

    private int costo;
    private Casillero casillero;
    private String jugador;
    private Posicion posicion;

    public Curandero(){
        vida = 75;
        costo = 5;
        casillero = new Casillero();
    }

    public Curandero(int vidaInicial) {
        vida = vidaInicial;
        costo = 5;
        casillero = new Casillero();
    }

    @Override
    public void atacar(Unidad unidad) {
        int danioCortaDistancia = -15;
        final int MAX_DISTANCIA_CORTA = 2;
        if (!this.jugador.equals(unidad.getJugador())) {
            throw new ProhibidoCurarUnidadEnemigaExeption();
        }
        int distancia = casillero.calcularDistanciaA(unidad.getCasillero());
        if (distancia >= MAX_DISTANCIA_CORTA) {
            throw new UnidadFueraDeRangoException();
        }
        unidad.recibirDanio(danioCortaDistancia);
    }

    @Override
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public void avanzar(String direccion) {
        Casillero nuevoCasillero = this.casillero.obtenerSiguienteEnDireccion(direccion);
        this.casillero = nuevoCasillero;
        //this.posicion = direccion; /* REFACTOR pedir posicion a casillero */

    }

    @Override
    public int coste() {
        return costo;
    }

    @Override
    public void colocarEn(Casillero unCasillero) {
        casillero = unCasillero;
    }


    @Override
    public Casillero getCasillero() {
        return casillero;
    }

    @Override
    public String getJugador() {
        return jugador;
    }

    public void setJugador(String unJugador) {
        jugador = unJugador;
    }

    public int vida() {
        return vida;
    }
}
