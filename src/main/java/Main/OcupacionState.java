package Main;

public abstract class OcupacionState {
    public abstract OcupacionState ocupar(Unidad unaUnidad);
    public abstract OcupacionState liberar();
    public abstract Unidad unidad();

}
