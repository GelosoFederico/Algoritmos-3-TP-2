package Main;

public class  MovimientoEnBatallon implements Movible {
    @Override
    public void avanzar(Unidad unidad, Direccion direccion) {
        Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
    }
}
