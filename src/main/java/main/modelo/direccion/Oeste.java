package main.modelo.direccion;

import main.modelo.tablero.distancia.Posicion;

public class Oeste extends Direccion{
    public Posicion posicionRelativa(){
        return new Posicion(0,-1);
    }
}
