package Main.Modelo.Unidad;

import Main.Modelo.Direccion.Direccion;
import Main.Modelo.Direccion.Posicion;
import Main.Modelo.Unidad.Ataque.AtaqueEstrategia;
import Main.Modelo.Unidad.ConjuntoDeUnidades.ConjuntoDeSoldados;
import Main.Modelo.Unidad.ConjuntoDeUnidades.ConjuntoDeUnidades;

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
}
