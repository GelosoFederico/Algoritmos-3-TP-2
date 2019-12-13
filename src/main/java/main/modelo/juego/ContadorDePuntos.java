package main.modelo.juego;

import main.modelo.excepciones.InsuficientePuntosRestantesAlColocarUnidadException;
import main.modelo.unidad.Unidad;

//TODO: Esta clase deberia ser accesible unicamente desde jugador, pero no se podrian hacer tests unitarios de esa forma.
//TODO: Consultar esto
public class ContadorDePuntos
{
    private static final int PUNTOS_INICIALES = 20;
    private int puntosRestantes;

    public ContadorDePuntos() {
        puntosRestantes = PUNTOS_INICIALES;
    }

    public int puntosRestantes() {
        return this.puntosRestantes;
    }

    public void contarPuntosDe(Unidad unidad) {
        if (this.puntosRestantes() - unidad.coste() < 0) {
            throw new InsuficientePuntosRestantesAlColocarUnidadException();
        }
        this.puntosRestantes -= unidad.coste();
    }
}
