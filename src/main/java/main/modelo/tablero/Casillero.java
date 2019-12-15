package main.modelo.tablero;


import main.modelo.Observable;
import main.modelo.juego.Jugador;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.NullUnidad;
import main.modelo.unidad.Unidad;
import main.modelo.juego.Equipo;

public class Casillero extends Observable {
    private Posicion posicion;
    private Equipo equipo;
    private Unidad unidad;

    public Casillero(Posicion posicionAsignada, Equipo equipo) {
        posicion = posicionAsignada;
        this.equipo = equipo;
        unidad = new NullUnidad();
    }

    public Posicion posicion() {
        return posicion;
    }

    public void ocupar(Unidad unaUnidad) {
        this.unidad = this.unidad.ocuparCasillero(unaUnidad);
    }

    public void liberar() {
        this.unidad = new NullUnidad();
        this.notifyObservers();
    }

    public Equipo equipo(){ return this.equipo; }

    public void colocarUnidadDeJugador(Unidad unidad, Jugador jugador) {
        this.equipo().colocar(unidad, unidad.equipo(), this);
    }

    public Unidad unidad() {
        return this.unidad;
    }
}
