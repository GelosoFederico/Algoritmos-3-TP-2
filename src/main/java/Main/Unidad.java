package Main;

public abstract class Unidad {
    protected int vida;
    protected String jugador;
    protected int coste;
    protected AtaqueEstrategia ataqueEstrategia;
    protected Movible movimientoEstrategia = new MovimientoRegular();

    public void atacar(Unidad unidadVictima) {
        ataqueEstrategia.atacar(this, unidadVictima);
    }

    ;

    public void avanzar(Direccion direccion) {
        movimientoEstrategia.avanzar(this, direccion);
    }

    public int coste() {
        return this.coste;
    }

    public void recibirDanio(int danio) {
        if (vida <= 0) {
            throw new UnidadEstaMuertaException();
        }
        vida = vida - danio;
    }

    public String getJugador() {
        return this.jugador;
    }

    public void setJugador(String unJugador) {
        this.jugador = unJugador;
    }

    public int vida() {
        return this.vida;
    }

    public Posicion posicion() {
        return Tablero.getInstance().obtenerPosicionDeUnidad(this);
    }

    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados) {
    }

    public ConjuntoDeSoldados buscarSoldadosAliadosCercanos(Soldado soldado) {
        ConjuntoDeUnidades unidadesContiguas = new ConjuntoDeUnidades();
        unidadesContiguas = Tablero.getInstance()
                .obtenerUnidadesAlrededorDe(soldado, 1, unidadesContiguas);
        ConjuntoDeUnidades unidadesAliadas = new ConjuntoDeUnidades();
        unidadesAliadas = unidadesContiguas.obtenerUnidadesDeJugador(soldado.getJugador());
        ConjuntoDeSoldados soldadosCercanosAliados = new ConjuntoDeSoldados();
        soldadosCercanosAliados.obtenerSoldadosDelConjunto(unidadesAliadas);
        return soldadosCercanosAliados;
    }
}