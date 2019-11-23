package Main.Unidad;

import Main.Direccion.Direccion;
import Main.Unidad.Ataque.AtaqueCorto;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeSoldados;

import java.util.Iterator;

public class Soldado extends RealUnidad {

    private static final int DANIO = 10;

    public Soldado() {
        vida = 100;
        coste = 1;
        ataqueEstrategia = new AtaqueCorto(DANIO);
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
            this.movimientoEstrategia = new MovimientoEnBatallon(soldadosContiguosAliados);
        }

        this.movimientoEstrategia.avanzar(this, direccion);
        this.movimientoEstrategia = new MovimientoRegular();
    }
}
