package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.excepciones.CasilleroOcupadoException;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;

public class  MovimientoEnBatallon implements MovimientoEstrategia {
    private ConjuntoDeSoldados batallon;

    public MovimientoEnBatallon(ConjuntoDeSoldados batallon){
        this.batallon = batallon;
    }

    @Override
    public void avanzar(Unidad noSirve, Direccion direccion) {
        ConjuntoDeSoldados soldadosPorMoverse = new ConjuntoDeSoldados();
        soldadosPorMoverse.obtenerSoldadosDelConjunto(batallon);
        ConjuntoDeSoldados siguientesSoldadosPorMoverse = new ConjuntoDeSoldados();
        for(int i=0; i<3; i++){
            for (Unidad unidad : soldadosPorMoverse.unidades()) {
                try {
                    Tablero.getInstance().moverUnidadEnDireccion(unidad, direccion);
                    // No los removemos aca porque tira excepcion de concurrencia
                }
                catch(CasilleroOcupadoException e){
                    siguientesSoldadosPorMoverse.agregar(unidad);
                }
            }
            soldadosPorMoverse = siguientesSoldadosPorMoverse;
            siguientesSoldadosPorMoverse = new ConjuntoDeSoldados();
        }
        if(soldadosPorMoverse.cantidad() == 3) {
            throw new CasilleroOcupadoException();
        }
    }
}
