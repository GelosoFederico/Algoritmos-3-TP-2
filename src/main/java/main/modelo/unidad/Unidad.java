package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.Posicion;
import main.modelo.unidad.ataque.AtaqueEstrategia;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;

public interface Unidad {
    void atacar(Unidad unidadVictima);
    void avanzar(Direccion direccion);
    int coste();
    void recibirDanio(int danio);

    String getJugador();
    void setJugador(String unJugador);
    int vida();
    Posicion posicion();
    void setearEstrategiaDeAtaque(AtaqueEstrategia ataqueEstrategia);
    void agregarseA(ConjuntoDeSoldados conjuntoDeSoldados);
    void agregarseA(ConjuntoDeUnidades conjuntoDeUnidades);
    Unidad ocuparCasillero(Unidad unidad);
    Equipo equipo();
    void setEquipo(Equipo equipo);
}
