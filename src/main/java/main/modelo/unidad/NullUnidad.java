package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.Posicion;
import main.modelo.unidad.ataque.AtaqueEstrategia;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;

public class NullUnidad implements Unidad {
    // TODO: devuelve cualquier cosa. Hay que ver que preferimos que haga
    public void atacar(Unidad unidadVictima){};
    public void avanzar(Direccion direccion){};
    public int coste(){return 0;}
    public void recibirDanio(int danio){};
    public Equipo equipo(){ return new EquipoBlanco();}; //TODO: hacer EquipoNull
    public void setEquipo(Equipo equipo){};
    public String getJugador(){return "nadie";}
    public void setJugador(String unJugador){};
    public int vida(){return 0;}
    public Posicion posicion(){return new Posicion(0,0);};
    public void setearEstrategiaDeAtaque(AtaqueEstrategia ataqueEstrategia){};
    public void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados) {};
    public void agregarseA(ConjuntoDeUnidades conjuntoDeUnidades) {};
    public Unidad ocuparCasillero(Unidad unidad){
        return unidad;
    };
}
