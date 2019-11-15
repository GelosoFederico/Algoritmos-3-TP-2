package Main;

public class Curandero extends Unidad {

    public Curandero(){
        vida = 75;
        coste = 5;
        ataqueEstrategia = new AtaqueCurandero();
    }

    public Curandero(int vidaInicial) {
        vida = vidaInicial;
        coste = 5;
        ataqueEstrategia = new AtaqueCurandero();
    }

}
