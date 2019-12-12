package main.modelo.juego.fase;

import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;

public abstract class Fase {
    protected Juego juego;

    public Fase(Juego juego){
        this.juego = juego;
    }

    public abstract void agregarJugador(Jugador jugador);

    public abstract void cambiarJugadorDeTurno();

    public abstract void removerJugador();

    public void moverUnidadHacia(Unidad unidad, Posicion posicion){}

    public void movimientoUtilizado(){}

    public void atacarConUnidadAUnidad(Unidad atacante, Unidad defensora){}
}
