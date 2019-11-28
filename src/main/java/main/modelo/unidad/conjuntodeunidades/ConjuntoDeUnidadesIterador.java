package Main.Unidad.ConjuntoDeUnidades;

import Main.Unidad.Unidad;
import java.util.Iterator;

public class ConjuntoDeUnidadesIterador implements Iterator<Unidad> {
    Iterator<Unidad> iterador;

    public ConjuntoDeUnidadesIterador(ConjuntoDeUnidades unidades) {
        iterador = unidades.unidades().iterator();
    }

    @Override
    public boolean hasNext() {
        return this.iterador.hasNext();
    }

    @Override
    public Unidad next() {
        return this.iterador.next();
    }

    @Override
    public void remove() {
        iterador.remove();
    }
}
