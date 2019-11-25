package Main.Unidad;

import Main.Direccion.Direccion;
import Main.Direccion.Posicion;
import Main.Juego.Equipo;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeSoldados;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeUnidades;

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
