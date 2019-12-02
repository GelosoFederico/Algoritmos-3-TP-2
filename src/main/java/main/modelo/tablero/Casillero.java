package main.modelo.tablero;


import main.modelo.juego.Jugador;
import main.modelo.direccion.Posicion;
import main.modelo.tablero.Distancia.Distancia;
import main.modelo.unidad.NullUnidad;
import main.modelo.unidad.Unidad;
import main.modelo.juego.Equipo;

public class Casillero {
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
    }

    public Equipo equipo(){ return this.equipo; }

    public void colocarUnidadDeJugador(Unidad unidad, Jugador jugador) {
        this.equipo().colocar(unidad, unidad.equipo(), this);
    }

    public Unidad unidad() {
        return this.unidad;
    }
}
