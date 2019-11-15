package Main;

public class Catapulta extends Unidad{

    public Catapulta() {
        vida = 50;
        coste = 5;
        ataqueEstrategia = new AtaqueCatapulta();
    }

    public Catapulta(int vidaInicial) {
        vida = vidaInicial;
        coste = 5;
        ataqueEstrategia = new AtaqueCatapulta();
    }


    @Override
    public void avanzar(Direccion direccion) {
        throw new UnidadNoPuedeMoverseException();
    }

}
