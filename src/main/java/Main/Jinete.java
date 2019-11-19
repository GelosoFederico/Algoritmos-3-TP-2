package Main;

public class Jinete extends Unidad {

    public Jinete() {
        vida = 100;
        coste = 3;
    }

    public Jinete(int vidaInicial) {
        vida = vidaInicial;
        coste = 3;
    }

    @Override
    public void atacar(Unidad unidadEnemiga) {
        // Si hay un soldado de infanteria aliado cerca o ningun enemigo,
        // ataca con arco y flecha
        // Obtengo los conjuntos necesarios
        ConjuntoDeUnidades unidadesCercanas = new ConjuntoDeUnidades();
        unidadesCercanas = Tablero.getInstance()
                .obtenerUnidadesAlrededorDe(this, 2, unidadesCercanas);

        ConjuntoDeUnidades unidadesCercanasEnemigas = unidadesCercanas.obtenerUnidadesDeJugador(unidadEnemiga.getJugador());
        ConjuntoDeSoldados soldadosCercanosAmigos = new ConjuntoDeSoldados();
        soldadosCercanosAmigos.obtenerSoldadosDelConjunto(unidadesCercanas.obtenerUnidadesDeJugador(this.getJugador()));

        if( (soldadosCercanosAmigos.cantidad() > 0) || (unidadesCercanasEnemigas.cantidad() == 0)) {
            this.setearEstrategiaDeAtaque(new AtaqueJineteArco());
        }else {
            this.setearEstrategiaDeAtaque(new AtaqueJineteEspada());
        }
        // TODO tirar mejores excepciones
        this.ataqueEstrategia.atacar(this, unidadEnemiga);
    }

}
