package Main;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDeUnidades {
    // TODO agregar iterador para tocar desde fuera
    protected List<Unidad> unidades;

    public ConjuntoDeUnidades(){ this.unidades = new ArrayList<Unidad>(); }

    public void agregar(Unidad unidad) {
        unidad.agregarseA(this);
    }
    public void agregarUnidad(Unidad unidad) { this.unidades().add(unidad); }
    public boolean seEncuentra(Unidad unidad) {
        return this.unidades().contains(unidad);
    }

    protected List<Unidad> unidades() {
        return this.unidades;
    }

    public int cantidad() {
        return this.unidades().size();
    }

    public boolean equals(ConjuntoDeUnidades otroConjunto) {
        if(this.cantidad() != otroConjunto.cantidad()) {
            return false;
        }
        for (Unidad unidad: this.unidades() ) {
            if(!otroConjunto.seEncuentra(unidad)) {
                return false;
            }
        }
        return true;
    }
    
    public ConjuntoDeUnidades obtenerUnidadesDeJugador(String jugadorNombre){
        // TODO el conjunto nuevo deberia clonarse del viejo para que sean de la misma clase (sacarle todas las unidades)
        ConjuntoDeUnidades conjuntoNuevo = new ConjuntoDeUnidades();
        for (Unidad unidad:this.unidades()) {
            if(unidad.getJugador().equals(jugadorNombre)){
                conjuntoNuevo.agregar(unidad);
            }
        }
        return conjuntoNuevo;
    }
}
