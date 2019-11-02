package Main;

public abstract class Unidad implements Atacante {
    private int vida;


    public abstract void recivirDanio(int ataqueMediaDistancia);
    public abstract void atacar(Unidad unaUnidad);
    public abstract void setPosicion(String unaPosicionMedia);
}
