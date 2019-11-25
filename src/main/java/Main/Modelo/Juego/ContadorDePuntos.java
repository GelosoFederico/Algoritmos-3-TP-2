package Main.Modelo.Juego;

import Main.Modelo.Excepciones.InsuficientePuntosRestantesAlColocarUnidadException;
import Main.Modelo.Unidad.Unidad;

//TODO: Esta clase deberia ser accesible unicamente desde jugador, pero no se podrian hacer tests unitarios de esa forma.
//TODO: Consultar esto
public class ContadorDePuntos
{
    private static final int PUNTOS_INICIALES = 20;
    private int _puntosRestantes;

    public ContadorDePuntos() {
        _puntosRestantes = PUNTOS_INICIALES;
    }

    public int puntosRestantes() {
        return this._puntosRestantes;
    }

    public void contarPuntosDe(Unidad unidad) {
        if (this.puntosRestantes() - unidad.coste() < 0) {
            throw new InsuficientePuntosRestantesAlColocarUnidadException();
        }
        this._puntosRestantes -= unidad.coste();
    }
}
