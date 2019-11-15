package Main;

public class Jinete extends Unidad {

    public Jinete() {
        vida = 100;
        coste = 3;
        ataqueEstrategia = new AtaqueJineteArco();
    }

    public Jinete(int vidaInicial) {
        vida = vidaInicial;
        coste = 3;
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        ataqueEstrategia.atacar(this,unidadEnemiga);

        // TODO: ramificar
    }

}
