package Main;

public class Libre extends OcupacionState {
    @Override
    public OcupacionState ocupar(){
        return new Ocupado();
    }
    @Override
    public OcupacionState liberar(){
        return this;
    }
}
