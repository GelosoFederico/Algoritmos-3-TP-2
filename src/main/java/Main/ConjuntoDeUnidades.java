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
}
