package main.modelo.direccion;

import main.modelo.excepciones.PosicionesNoEstanADistanciaUnoException;
import main.modelo.tablero.distancia.Posicion;

public class FactoryDireccion {
    private static Direccion norte = new DireccionNorte();
    private static Direccion sur = new DireccionSur();
    private static Direccion este = new DireccionEste();
    private static Direccion oeste = new DireccionOeste();
    private static Direccion noreste = new DireccionNoreste();
    private static Direccion noroeste = new DireccionNoroeste();
    private static Direccion sureste = new DireccionSureste();
    private static Direccion suroeste = new DireccionSuroeste();

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
