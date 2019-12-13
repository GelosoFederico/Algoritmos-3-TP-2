package main.modelo.direccion;

import main.modelo.tablero.distancia.Posicion;

public class DireccionSuroeste extends Direccion{
    public Posicion posicionRelativa(){
        return new Posicion(1,-1);
    }
}
