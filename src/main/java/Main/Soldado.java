package Main;

import java.util.Iterator;

public class Soldado extends Unidad {

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
        //intento formar un batallon
        //si se pudo cambio la estrategia de movimiento a batallon
        //vuelvo a setear la estrategia regular
        ConjuntoDeSoldados soldadosCercanosAliados = this.buscarSoldadosAliadosCercanos(this);
        // no se puede formar batallon
        if (soldadosCercanosAliados.cantidad() == 0) {
            movimientoEstrategia.avanzar(this, direccion);
        }
        // tengo 2 o mas soldados contiguos para formar un batallon
        else if(soldadosCercanosAliados.cantidad() >= 2){
            //tengo que avanzar al soldado que invocaron y a los primeros 2 soldaditos
            int tamanio;
            while( (tamanio = soldadosCercanosAliados.cantidad()) > 2){
                soldadosCercanosAliados.unidades().remove(tamanio);
            }
            soldadosCercanosAliados.agregar(this);
            movimientoEstrategia = new MovimientoEnBatallon(soldadosCercanosAliados);
            this.movimientoEstrategia.avanzar(this, direccion);
            this.movimientoEstrategia = new MovimientoRegular();
        }
        //si hay un soldado contiguo, busco los contiguos a este otro
        // y veo si puedo formar un batallon
        else if (soldadosCercanosAliados.cantidad() == 1) {
            Iterator<Unidad> iterador = soldadosCercanosAliados.unidades().iterator();
            Soldado soldadoCentro = (Soldado) iterador.next();
            ConjuntoDeSoldados soldadosAliadosCercanosCentro = soldadoCentro
                    .buscarSoldadosAliadosCercanos(soldadoCentro);

            //si el nuevo conjunto es igual al anterior hay dos putos soldados y esto fue al pedo
            // avanzar el primero (this)  :S
            if (soldadosAliadosCercanosCentro.equals(soldadosCercanosAliados)) {
                movimientoEstrategia.avanzar(this, direccion);
            }
            //Contemplad esta replicacion de codigo ლ(´ڡ`ლ) ¡MA CHE BELLA COSA!
            else if(soldadosAliadosCercanosCentro.cantidad() >= 2){
                //tengo que avanzar al soldado que invocaron (this) y a los primeros 2 soldaditos
                int tamanio;
                while( (tamanio = soldadosAliadosCercanosCentro.cantidad()) > 2){
                    soldadosAliadosCercanosCentro.unidades().remove(tamanio);
                }
                soldadosAliadosCercanosCentro.agregar(soldadoCentro);
                movimientoEstrategia = new MovimientoEnBatallon(soldadosAliadosCercanosCentro);
                this.movimientoEstrategia.avanzar(this, direccion);
                this.movimientoEstrategia = new MovimientoRegular();
            }
        }
        // por si las moscas ¯\_(ツ)_/¯
        else
            movimientoEstrategia.avanzar(this, direccion);
    }
}
