package main.modelo.direccion;

import main.modelo.tablero.distancia.Posicion;

public class Noroeste extends Direccion{
    public Posicion posicionRelativa(){
        return new Posicion(-1,-1);
    }
}
