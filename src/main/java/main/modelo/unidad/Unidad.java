package main.modelo.unidad;

import main.modelo.direccion.Direccion;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.juego.Equipo;
import main.modelo.unidad.ataque.AtaqueEstrategia;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeSoldados;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidades;
import main.modelo.unidad.conjuntodeunidades.ConjuntoDeUnidadesVictimas;

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
    void agregarseA(ConjuntoDeUnidadesVictimas conjuntoDeUnidades);

    Unidad ocuparCasillero(Unidad unidad);
    Equipo equipo();
    void setEquipo(Equipo equipo);
}
