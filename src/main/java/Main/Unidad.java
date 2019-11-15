package Main;

public abstract class Unidad implements Movible{
    protected int vida;
    protected String jugador;
    protected int coste;
    protected AtaqueEstrategia ataqueEstrategia;

    public void atacar(Unidad unidadVictima) {
        ataqueEstrategia.atacar(this,unidadVictima);
    };
    public void avanzar(Direccion direccion) {
        Tablero.getInstance().moverUnidadEnDireccion(this,direccion);
    }
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
