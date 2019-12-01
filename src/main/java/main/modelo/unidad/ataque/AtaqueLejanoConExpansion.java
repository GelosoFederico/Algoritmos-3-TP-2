package main.modelo.unidad.ataque;

        import main.modelo.tablero.Distancia.Lejana;
        import main.modelo.tablero.Tablero;
        import main.modelo.unidad.Unidad;
        import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;
        import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidadesVictimas;

public class AtaqueLejanoConExpansion  extends AtaqueEstrategia {

    public AtaqueLejanoConExpansion(int danio) {
        super(danio);
    }

    @Override
    public void atacar(Unidad atacante, Unidad victima) {
        Tablero.getInstance().daniarUnidadEnRango(atacante, victima, new Lejana(), danio);
        ConjuntoDeUnidadesVictimas victimas = new ConjuntoDeUnidadesVictimas();
        victimas.buscarTodasLasVictimasDeExpansion(victima);
        victimas.recibirDanio(victima, danio);
    }

}