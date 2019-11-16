package Main;

public class ConjuntoDeSoldados extends ConjuntoDeUnidades {
    public void agregar(Unidad unidad) {
        unidad.agregarseA(this);
    }

    public void agregarSoldado(Soldado soldado) {
        this.unidades().add(soldado);
    }

    public void obtenerSoldadosDelConjunto(ConjuntoDeUnidades otroConjunto) {
        // TODO hacer con iterador
        for (Unidad unidad: otroConjunto.unidades()) {
            this.agregar(unidad);
        }
    }
}
