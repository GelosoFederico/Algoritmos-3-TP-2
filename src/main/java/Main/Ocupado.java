package Main;

public class Ocupado extends OcupacionState {
    @Override
    public OcupacionState ocupar(){
        throw new CasilleroOcupadoException();
    }
    @Override
    public OcupacionState liberar(){
        return new Libre();
    }
}
