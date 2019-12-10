package main.modelo.unidad.ataque;

import main.modelo.unidad.Unidad;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidadesVictimas;

public class Expansion extends ModificadorAtaque {
    private int danio;

    public Expansion(int danio){
        this.danio = danio;
    }

    @Override
    public void ejecutar(Unidad victima) {
        ConjuntoDeUnidadesVictimas victimas = new ConjuntoDeUnidadesVictimas();
        victimas.recibirDanio(victima, this.danio);
    }
}
