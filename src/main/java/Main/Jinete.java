package Main;

public class Jinete extends Unidad implements Atacante {

    private String posicion;
    private int vida = 100;

    public void setPosicion(String unaPosicion) {
        this.posicion = unaPosicion;
    }

    public void atacar(Unidad jineteEnemigo) {
        int ataqueMediaDistancia = 15;
        jineteEnemigo.recivirDanio(ataqueMediaDistancia);
    }

    public void recivirDanio(int ataqueMediaDistancia) {
        this.vida = this.vida - ataqueMediaDistancia;
    }

    public int getVida() {
        return vida;
    }
}
