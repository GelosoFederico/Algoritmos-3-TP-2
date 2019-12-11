package main.modelo.direccion;

import main.modelo.tablero.distancia.Posicion;

public class DireccionEste extends Direccion{
    public Posicion posicionRelativa(){
        return new Posicion(0,1);
    }
}
