package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.juego.Bando;
import main.modelo.juego.BandoAliado;
import main.modelo.juego.BandoEnemigo;
import main.modelo.juego.Juego;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.excepciones.*;
import main.modelo.juego.Equipo;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.ataque.AtaqueEstrategia;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidadesVictimas;
import main.modelo.unidad.movimiento.MovimientoEstrategia;
import main.modelo.unidad.movimiento.MovimientoRegular;

public abstract class RealUnidad implements Unidad {
    protected int vida;
    protected String jugador;
    protected int coste;
    protected AtaqueEstrategia ataqueEstrategia;
    protected MovimientoEstrategia movimientoEstrategia = new MovimientoRegular();
    protected Equipo equipo;
    protected Bando bandoAtacable = new BandoEnemigo();

    public void atacar(Unidad unidadVictima) {
       this.validarAtaque(unidadVictima);
        ataqueEstrategia.atacar(this, unidadVictima);
    }

    protected void validarAtaque(Unidad unidadVictima){
        try {
            bandoAtacable.permiteAtacar(this.equipo().identificarBando(unidadVictima.equipo()));
        }
        catch (BandosNoCoincenExeption e){
            throw new ProhibidoAtacarUnidadAliadaException();
        }
    }


    public void avanzar(Direccion direccion) {
        movimientoEstrategia.avanzar(this, direccion);
    }

    public int coste() {
        return this.coste;
    }

    public void recibirDanio(int danio) {
        int danioFinal = this.equipo().calcularDanioFinal(this, danio);
        vida = vida - danioFinal;
        if (vida <= 0) {
            Juego.getInstance().murioUnidad(this);
        }
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
    public void agregarseA(ConjuntoDeUnidadesVictimas conjuntoDeUnidades) {
        conjuntoDeUnidades.agregarUnidad(this);
    }
    public Unidad ocuparCasillero(Unidad unidad){
        throw new CasilleroOcupadoException();
    };
}
