package Main.Modelo.Unidad.ConjuntoDeUnidades;

import Main.Modelo.Tablero.Tablero;
import Main.Modelo.Unidad.Soldado;
import Main.Modelo.Unidad.Unidad;

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