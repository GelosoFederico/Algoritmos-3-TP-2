package Main;

public abstract class Unidad implements Atacante, Movible{
    protected int vida;

    public abstract void atacar(Unidad unidad);
    public abstract void setPosicion(Posicion posicion);
    public abstract void avanzar(String direccion);
    public abstract int coste();
    public abstract void colocarEn(Casillero casillero);
    public void recibirDanio(int danio) {
        if(vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida = vida - danio;
    }
    public abstract Casillero getCasillero();
    public abstract String getJugador();
}
