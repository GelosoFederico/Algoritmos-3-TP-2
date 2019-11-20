package Main;

public class RealUnidad implements Unidad {
    protected int vida;
    protected String jugador;
    protected int coste;
    protected AtaqueEstrategia ataqueEstrategia;
    protected Movible movimientoEstrategia = new MovimientoRegular();

    public void atacar(Unidad unidadVictima) {
        ataqueEstrategia.atacar(this, unidadVictima);
    }

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

    public String getJugador() { return this.jugador; }
    public void setJugador(String unJugador) { this.jugador = unJugador; }
    public int vida(){ return this.vida; }
    public Posicion posicion() { return Tablero.getInstance().obtenerPosicionDeUnidad(this);}
    public void setearEstrategiaDeAtaque(AtaqueEstrategia ataqueEstrategia) {
        this.ataqueEstrategia = ataqueEstrategia;
    }

    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados){};
    public void agregarseA(ConjuntoDeUnidades conjuntoDeUnidades) {
        conjuntoDeUnidades.agregarUnidad(this);
    }
    public Unidad ocuparCasillero(Unidad unidad){
        throw new CasilleroOcupadoException();
    };
}
