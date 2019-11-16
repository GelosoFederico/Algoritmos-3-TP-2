package Main;

public class Ocupado extends OcupacionState {
    private Unidad unidad = null;


    @Override
    public OcupacionState ocupar(Unidad unaUnidad){

        if (this.unidad != null)
            throw new CasilleroOcupadoException();

        this.unidad = unaUnidad;
        return this;
    }

    @Override
    public OcupacionState liberar(){
        return new Libre();
    }

    @Override
    public Unidad unidad(){
        return  this.unidad;
    }
}
