package Main;

public class Soldado extends Unidad{

    public Soldado() {
        vida = 100;
        coste = 1;
        ataqueEstrategia = new AtaqueSoldado();
    }

    public Soldado(int vidaInicial) {
        vida = vidaInicial;
        coste = 1;
        ataqueEstrategia = new AtaqueSoldado();
    }
}
