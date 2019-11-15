package Main;

public class MovimientoEstatico implements Movible {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        throw new UnidadNoPuedeMoverseException();
    }
}
