package main.modelo.unidad.conjuntodeunidades;

import main.modelo.tablero.Tablero;
import main.modelo.unidad.Unidad;

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

    private ConjuntoDeUnidades agregarUnidadesDiferentesDeOtro(ConjuntoDeUnidades otroConjunto){
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

        this.buscarTodasLasVictimasDeExpansion(primerVictima);
        if(this.seEncuentra(primerVictima))
            this.unidades.remove(primerVictima);

        for (Unidad unidad: this.unidades() )
            unidad.recibirDanio(danio);
    }

}
