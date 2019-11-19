package Main;

import java.util.List;

public class ConjuntoDeSoldados extends ConjuntoDeUnidades {

    public void agregar(Unidad unidad) {
        unidad.agregarseA(this);
    }

    public void agregarSoldado(Soldado soldado) {
        this.unidades().add(soldado);
    }

    public void obtenerSoldadosDelConjunto(ConjuntoDeUnidades otroConjunto) {
        // TODO hacer con iterador
        for (Unidad unidad : otroConjunto.unidades()) {
            this.agregar(unidad);
        }
    }

    public ConjuntoDeSoldados buscarSoldadosAliadosContiguos(Unidad unidad) {
        ConjuntoDeUnidades unidadesContiguas = new ConjuntoDeSoldados();
        unidadesContiguas = Tablero.getInstance().obtenerUnidadesAlrededorDe(unidad, 1, unidadesContiguas);
        ConjuntoDeUnidades soldadosAliados = unidadesContiguas.obtenerUnidadesDeJugador(unidad.getJugador());
        ConjuntoDeSoldados soldadosAliadosContiguos = new ConjuntoDeSoldados();
        soldadosAliadosContiguos.obtenerSoldadosDelConjunto(soldadosAliados);
        return soldadosAliadosContiguos;
    }
}