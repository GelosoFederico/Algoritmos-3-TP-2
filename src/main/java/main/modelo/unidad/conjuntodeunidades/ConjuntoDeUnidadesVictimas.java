package main.modelo.unidad.conjuntodeunidades;

import main.modelo.tablero.Tablero;
import main.modelo.unidad.Soldado;
import main.modelo.unidad.Unidad;

import java.util.Iterator;

public class ConjuntoDeUnidadesVictimas extends ConjuntoDeUnidades {

    public void agregar(Unidad unidad) {
        unidad.agregarseA(this);
    }

    public ConjuntoDeUnidadesVictimas buscarTodasLasVictimasDeExpansion(Unidad unidadVictima){

        ConjuntoDeUnidades unidadesContiguas = this.buscarUnidadesContiguasALaVictima(unidadVictima);
        this.buscarUnidadesContiguasParaCadaVictima(unidadesContiguas);
        return this;
    }

    public ConjuntoDeUnidades buscarUnidadesContiguasALaVictima(Unidad unidad) {
        ConjuntoDeUnidades unidadesContiguas = new ConjuntoDeUnidades();

        return Tablero.getInstance().obtenerUnidadesAlrededorDe(unidad, 1, unidadesContiguas);
    }

    public void buscarUnidadesContiguasParaCadaVictima(ConjuntoDeUnidades unidades) {

        if(unidades.cantidad() == 0){ return;}

            for (Unidad unidad:unidades.unidades()) {

                ConjuntoDeUnidades unidadesContiguas = this.buscarUnidadesContiguasALaVictima(unidad);
                ConjuntoDeUnidades nuevasVictimas = this.agregarUnidadesDiferentesDeOtro(unidadesContiguas);
                this.buscarUnidadesContiguasParaCadaVictima(nuevasVictimas);

            }
    }

    public ConjuntoDeUnidades agregarUnidadesDiferentesDeOtro(ConjuntoDeUnidades otroConjunto){
        ConjuntoDeUnidades nuevasVictimas = new ConjuntoDeUnidades();
        for (Unidad unidad: otroConjunto.unidades() ) {
            if(!this.seEncuentra(unidad)) {
                this.agregarUnidad(unidad);
                nuevasVictimas.agregarUnidad(unidad);
            }
        }
        return nuevasVictimas;
    }

    public void recibirDanio(Unidad primerVictima, int danio){
        for (Unidad unidad: this.unidades() ) {
            if(unidad != primerVictima) {
                unidad.recibirDanio(danio);
            }
        }

    }

}
