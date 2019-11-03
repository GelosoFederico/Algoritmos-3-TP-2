package Main;

public abstract class Unidad implements Atacante {
    private int vida;


    public abstract void recivirDanio(int danio);
    public abstract void atacar(Unidad unidad);
    public abstract void setPosicion(String posicion);
}
