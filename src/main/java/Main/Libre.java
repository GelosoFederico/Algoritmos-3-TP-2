package Main;

public class Libre extends OcupacionState {

    @Override
    public OcupacionState ocupar(Unidad unaUnidad){

        return new Ocupado().ocupar(unaUnidad);
    }
    @Override
    public OcupacionState liberar(){
        return this;
    }
    @Override
    public Unidad unidad(){
        return  null;
    }
}
