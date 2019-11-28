package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.Posicion;
import main.modelo.excepciones.*;
import main.modelo.juego.Equipo;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.ataque.AtaqueEstrategia;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;

public abstract class RealUnidad implements Unidad {
    protected int vida;
    protected String jugador;
    protected int coste;
    protected AtaqueEstrategia ataqueEstrategia;
    protected MovimientoEstrategia movimientoEstrategia = new MovimientoRegular();
    protected Equipo equipo;

    public void atacar(Unidad unidadVictima) {
        if (this.getJugador().equals(unidadVictima.getJugador())) {
            throw new ProhibidoAtacarUnidadAliadaException();
        }
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

    public Equipo equipo(){ return this.equipo; }
    public void setEquipo(Equipo equipo){ this.equipo = equipo; }
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
