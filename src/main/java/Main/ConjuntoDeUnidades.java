package Main;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDeUnidades {
    protected List<Unidad> unidades;

    public ConjuntoDeUnidades(){
        this.unidades = new ArrayList<Unidad>();
    }

    public void agregar(Unidad unidad) {
        this.unidades().add(unidad);
    }

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
}
