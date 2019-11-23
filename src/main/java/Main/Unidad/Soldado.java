package Main.Unidad;

import Main.Direccion.Direccion;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeSoldados;

import java.util.Iterator;

public class Soldado extends RealUnidad {

    public Soldado() {
        vida = 100;
        coste = 1;
        ataqueEstrategia = new AtaqueSoldado();
    }

    public Soldado(int vidaInicial) {
        vida = vidaInicial;
        coste = 1;
        ataqueEstrategia = new AtaqueSoldado();
    }

    @Override
    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados) {
        conjuntoDeSoldados.agregarSoldado(this);
    }

    public ConjuntoDeSoldados obtenerBatallon() {
        Soldado soldadoCentro = this; // TODO: delegar armado del batallon
        ConjuntoDeSoldados soldadosContiguosAliados = new ConjuntoDeSoldados();
        soldadosContiguosAliados = soldadosContiguosAliados.buscarSoldadosAliadosContiguos(soldadoCentro);

        //si hay un soldado contiguo, busco los contiguos a este otro
        // y veo si puedo formar un batallon
        if (soldadosContiguosAliados.cantidad() == 1) {
            Iterator<Unidad> iterador = soldadosContiguosAliados.unidades().iterator();
            soldadoCentro = (Soldado) iterador.next();
            soldadosContiguosAliados = new ConjuntoDeSoldados();
            soldadosContiguosAliados = soldadosContiguosAliados.buscarSoldadosAliadosContiguos(soldadoCentro);
        }

        // tengo 2 o mas soldados contiguos para formar un batallon
        if (soldadosContiguosAliados.cantidad() >= 2) {
            int i=0;
            while( (soldadosContiguosAliados.cantidad()) > 2){
                // El que lo llamo tiene que estar en el batallon
                if(soldadosContiguosAliados.unidades().get(i) != this ) {
                    soldadosContiguosAliados.unidades().remove(i);
                }
            }
            soldadosContiguosAliados.agregar(soldadoCentro);

        }
        return soldadosContiguosAliados;
    }

    public Movible obtenerEstrategiaDeMovimiento() {
        Movible estrategia = new MovimientoRegular(); // Estrategia por default
        ConjuntoDeSoldados batallon = obtenerBatallon();
        if (batallon.cantidad() == 3)
            estrategia = new MovimientoEnBatallon(batallon);
        return estrategia;
    }

    @Override
    public void avanzar(Direccion direccion) {
        this.movimientoEstrategia = this.obtenerEstrategiaDeMovimiento();
        this.movimientoEstrategia.avanzar(this, direccion);
    }
}
