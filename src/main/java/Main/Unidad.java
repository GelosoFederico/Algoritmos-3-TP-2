package Main;

public abstract class Unidad implements Atacante, Movible{
    protected int vida;

    public abstract void atacar(Unidad unidad);
    public abstract void setPosicion(String posicion);
    public abstract void avanzar(String direccion);
    public abstract int coste();
    public abstract void colocarEn(Casillero casillero);
    public abstract void recibirDanio(int danio);
    public abstract Casillero getCasillero();
    public abstract String getJugador();
}
