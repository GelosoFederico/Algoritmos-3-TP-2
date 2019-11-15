package Main;

public abstract class Unidad implements Atacante{
    protected int vida;
    protected String jugador;
    protected int coste;
    protected Movible movimientoStrategy = new MovimientoRegular();

    public abstract void atacar(Unidad unidad);
    public void avanzar(Direccion direccion) { movimientoStrategy.avanzar(this ,direccion); }
    public int coste() { return this.coste; }

    public void recibirDanio(int danio) {
        if(vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida = vida - danio;
    }

    public String getJugador() { return this.jugador; }
    public void setJugador(String unJugador) { this.jugador = unJugador; }
    public int vida(){ return this.vida; }
    public Posicion posicion() { return Tablero.getInstance().obtenerPosicionDeUnidad(this);}
}
