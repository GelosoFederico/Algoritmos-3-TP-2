package main.modelo.unidad.conjuntodeunidades;

import main.modelo.tablero.Tablero;
import main.modelo.unidad.Soldado;
import main.modelo.unidad.Unidad;

public class ConjuntoDeUnidadesVictimas extends ConjuntoDeUnidades {

    ConjuntoDeUnidades nuevasVictimas = new ConjuntoDeUnidades();

    public void agregar(Unidad unidad) {
        unidad.agregarseA(this);
    }


    //public void agregarUnidad(Unidad unidad) {
  //      this.unidades().add(unidad);
    //}

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
                this.agregarUnidadesDiferentesDeOtro(unidadesContiguas);
                this.buscarUnidadesContiguasParaCadaVictima(this.nuevasVictimas);

            }
    }

    public void agregarUnidadesDiferentesDeOtro(ConjuntoDeUnidades otroConjunto){
        this.nuevasVictimas = new ConjuntoDeUnidades();
        for (Unidad unidad: otroConjunto.unidades() ) {
            if(!this.seEncuentra(unidad)) {
                this.agregarUnidad(unidad);
                this.nuevasVictimas.agregarUnidad(unidad);
            }
        }
    }
}
