package Main;

public abstract class Unidad implements Atacante, Movible{
    protected int vida;
    protected Casillero casillero;
    protected String jugador;
    protected int coste;

    public abstract void atacar(Unidad unidad);
    public abstract void avanzar(String direccion);
    public int coste() { return this.coste; }

    public void colocarEn(Casillero unCasillero) {
        this.casillero = unCasillero;
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
