package main.modelo.direccion;

import main.modelo.tablero.distancia.Posicion;

public class DireccionOeste extends Direccion{
    public Posicion posicionRelativa(){
        return new Posicion(0,-1);
    }
}
