package main.modelo.unidad.conjuntodeunidades;

import main.modelo.tablero.Tablero;
import main.modelo.unidad.Soldado;
import main.modelo.unidad.Unidad;

import java.util.Iterator;

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

    public Batallon formarBatallon(Soldado soldadoCentro) {
        Soldado primerSoldado = soldadoCentro;
        ConjuntoDeSoldados soldadosContiguosAliados = new ConjuntoDeSoldados();
        soldadosContiguosAliados = soldadosContiguosAliados.buscarSoldadosAliadosContiguos(soldadoCentro);
        Batallon batallon = new BatallonIncompleto(soldadosContiguosAliados);
        //si hay un soldado contiguo, busco los contiguos a este otro
        // y veo si puedo formar un batallon
        if (soldadosContiguosAliados.cantidad() == 1) {
            Iterator<Unidad> iterador = soldadosContiguosAliados.iterator();

            soldadoCentro = (Soldado) iterador.next();
            soldadosContiguosAliados = new ConjuntoDeSoldados();
            soldadosContiguosAliados = soldadosContiguosAliados.buscarSoldadosAliadosContiguos(soldadoCentro);
        }

        // tengo 2 o mas soldados contiguos para formar un batallon
        if (soldadosContiguosAliados.cantidad() >= 2) {
            int i=0;
            Iterator<Unidad> iterador = soldadosContiguosAliados.iterator();
            while( (soldadosContiguosAliados.cantidad()) > 2){
                // El que lo llamo tiene que estar en el batallon
                if(!iterador.hasNext()) {
                    iterador = soldadosContiguosAliados.iterator();
                }
                i++;
                if(iterador.next() != primerSoldado) {
                    iterador.remove();
                }
            }
            soldadosContiguosAliados.agregar(soldadoCentro);
            batallon = new BatallonCompleto(soldadosContiguosAliados);
        }
        return batallon;
    }
}
