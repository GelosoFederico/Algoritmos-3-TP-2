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

    @Override
    // TODO: ¡PRECAUCION! el siguiente método contiene codigo replicado y estructuras de control
    //  que podrían herir su sensibilidad hacia las buenas practicas de la POO
    public void avanzar(Direccion direccion) {
        //intento formar un batallon desde un pivote
        Soldado soldadoCentro = this;
        //si se pudo cambio la estrategia de movimiento a batallon
        //y vuelvo a setear la estrategia regular

        ConjuntoDeSoldados soldadosContiguosAliados = new ConjuntoDeSoldados();
        soldadosContiguosAliados = soldadosContiguosAliados.buscarSoldadosAliadosContiguos(soldadoCentro);

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
                if(iterador.next() != this ) {
                    iterador.remove();
                }
            }
            soldadosContiguosAliados.agregar(soldadoCentro);
            this.movimientoEstrategia = new MovimientoEnBatallon(soldadosContiguosAliados);
        }

        this.movimientoEstrategia.avanzar(this, direccion);
        this.movimientoEstrategia = new MovimientoRegular();
    }
}
