package Main;

public class Jinete extends Unidad {

    public Jinete() {
        vida = 100;
        coste = 3;
    }

    public Jinete(int vidaInicial) {
        vida = vidaInicial;
        coste = 3;
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        try {
            ataqueEstrategia = new AtaqueJineteArco();
            ataqueEstrategia.atacar(this, unidadEnemiga);
        }
        catch (RuntimeException exception){
            ataqueEstrategia = new AtaqueJineteEspada();
            ataqueEstrategia.atacar(this,unidadEnemiga);
        }
    }

}
