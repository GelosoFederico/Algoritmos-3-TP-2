package Main;

public abstract class Unidad implements Atacante, Movible{
    protected int vida;
    protected Casillero casillero;
    protected String jugador;
    protected int coste;

    public abstract void atacar(Unidad unidad);
    public void avanzar(String direccion) {
        Casillero nuevoCasillero = this.casillero.obtenerSiguienteEnDireccion(direccion);
        this.casillero = nuevoCasillero;
        this.casillero.ocupar();
    }
    public int coste() { return this.coste; }

    public void colocarEn(Casillero unCasillero) {
        this.casillero = unCasillero;
        unCasillero.ocupar(); //TODO consultar
    }

    public void recibirDanio(int danio) {
        if(vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida = vida - danio;
    }
    public Casillero getCasillero() {
        return this.casillero;
    }

    public String getJugador() { return this.jugador; }
    public void setJugador(String unJugador) { this.jugador = unJugador; }
    public int vida(){ return this.vida; }
}
