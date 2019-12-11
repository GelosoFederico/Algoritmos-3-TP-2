package main.modelo.direccion;

import main.modelo.excepciones.PosicionesNoEstanADistanciaUnoException;
import main.modelo.tablero.distancia.Posicion;

public class FactoryDireccion {
    private static Direccion norte = new Norte();
    private static Direccion sur = new Sur();
    private static Direccion este = new Este();
    private static Direccion oeste = new Oeste();
    private static Direccion noreste = new Noreste();
    private static Direccion noroeste = new Noroeste();
    private static Direccion sureste = new Sureste();
    private static Direccion suroeste = new Suroeste();

    public static Direccion crear(Posicion posicionRelativa) {
        if (posicionRelativa.igualA(norte.posicionRelativa()))
            return norte;
        else if (posicionRelativa.igualA(sur.posicionRelativa()))
            return sur;
        else if (posicionRelativa.igualA(este.posicionRelativa()))
            return este;
        else if (posicionRelativa.igualA(oeste.posicionRelativa()))
            return oeste;
        else if (posicionRelativa.igualA(noreste.posicionRelativa()))
            return noreste;
        else if (posicionRelativa.igualA(noroeste.posicionRelativa()))
            return noroeste;
        else if (posicionRelativa.igualA(sureste.posicionRelativa()))
            return sureste;
        else if (posicionRelativa.igualA(suroeste.posicionRelativa()))
            return suroeste;
        else
            throw new PosicionesNoEstanADistanciaUnoException();
    }
}
