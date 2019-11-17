package Main;

public class Soldado extends Unidad{

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
    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados){
        conjuntoDeSoldados.agregarSoldado(this);
    }
    @Override
    public void avanzar(Direccion direccion){
        //intento formar un batallon
        //si se pudo cambio la estrategia de movimiento a batallon
        //vuelvo a setear la estrategia regular

        // TODO: hay replicaion de codigo, refactorizar en metodo buscarSoldadosAliadosCercanos
       ConjuntoDeUnidades unidadesContiguas = new ConjuntoDeUnidades();
       unidadesContiguas = Tablero.getInstance()
               .obtenerUnidadesAlrededorDe(this, 1, unidadesContiguas);
        ConjuntoDeUnidades unidadesAliadas = new ConjuntoDeUnidades();
        unidadesAliadas = unidadesContiguas.obtenerUnidadesDeJugador(this.getJugador());
        if(unidadesAliadas.cantidad() == 0){
            movimientoEstrategia.avanzar(this, direccion);
        }
         ConjuntoDeSoldados soldadosCercanosAliados = new ConjuntoDeSoldados();
         soldadosCercanosAliados.obtenerSoldadosDelConjunto(unidadesAliadas);
        if (soldadosCercanosAliados.cantidad() == 0) {
            movimientoEstrategia.avanzar(this , direccion);
        }
        if(soldadosCercanosAliados.cantidad() == 2){
            //tengo que avanzar a los 3 soldaditus
            soldadosCercanosAliados.agregar(this);
            movimientoEstrategia = new MovimientoEnBatallon(soldadosCercanosAliados);
            this.movimientoEstrategia.avanzar(this, direccion);
            this.movimientoEstrategia = new MovimientoRegular();
            }

        }

    }
