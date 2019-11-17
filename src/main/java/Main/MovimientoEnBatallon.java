package Main;

public class  MovimientoEnBatallon implements Movible {
    private ConjuntoDeSoldados batallon;

    public MovimientoEnBatallon(ConjuntoDeSoldados batallon){
        this.batallon = batallon;
    }

    @Override
    public void avanzar(Unidad noSirve, Direccion direccion) {
        for (Unidad unidad : batallon.unidades()) {
            try {
                Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
            }
            catch(CasilleroOcupadoException e){}
        }
    }
}
