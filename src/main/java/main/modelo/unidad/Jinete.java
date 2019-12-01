package main.modelo.unidad;

import main.modelo.excepciones.*;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.ataque.*;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;

public class Jinete extends RealUnidad {

    private static final int DANIO_ATAQUE_ARCO = 15;
    private static final int DANIO_ATAQUE_ESPADA = 5;

    public Jinete() {
        vida = 100;
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
            this.setearEstrategiaDeAtaque(new AtaqueMedio(DANIO_ATAQUE_ARCO));
        }else {
            this.setearEstrategiaDeAtaque(new AtaqueCorto(DANIO_ATAQUE_ESPADA));
        }
        // TODO tirar mejores excepciones
        if (this.getJugador().equals(unidadEnemiga.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
        this.ataqueEstrategia.atacar(this, unidadEnemiga);
    }

}
