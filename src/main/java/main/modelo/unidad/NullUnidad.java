package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.Posicion;
import main.modelo.juego.Equipo;
import main.modelo.juego.EquipoNull;
import main.modelo.unidad.ataque.AtaqueEstrategia;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidadesVictimas;

public class NullUnidad implements Unidad {
    // TODO: devuelve cualquier cosa. Hay que ver que preferimos que haga
    public void atacar(Unidad unidadVictima){};
    public void avanzar(Direccion direccion){};
    public int coste(){return 0;}
    public void recibirDanio(int danio){};
    public Equipo equipo(){ return new EquipoNull();}; //TODO: se agrega equipoNull para inicializar
                                                        // correctamente NullUnidad, pero en el modelo no tiene mucho sentido.
                                                        // no se intenta colocar una unidad nula durante la inicializacion,
                                                        // los casilleros ya se inicializan con una unidad nula
    public void setEquipo(Equipo equipo){};
    public String getJugador(){return "nadie";}
    public void setJugador(String unJugador){};
    public int vida(){return 0;}
    public Posicion posicion(){return new Posicion(0,0);};
    public void setearEstrategiaDeAtaque(AtaqueEstrategia ataqueEstrategia){};
    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados) {};
    public void agregarseA(ConjuntoDeUnidades conjuntoDeUnidades) {};
    public void agregarseA(ConjuntoDeUnidadesVictimas conjuntoDeUnidades){};
    public Unidad ocuparCasillero(Unidad unidad){
        return unidad;
    };
}
