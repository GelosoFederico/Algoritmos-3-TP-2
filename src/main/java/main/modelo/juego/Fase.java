package main.modelo.juego;

public abstract class Fase {
    protected Juego juego;

    public Fase(Juego juego){
        this.juego = juego;
    }

    public abstract void agregarJugador(Jugador jugador);

    public abstract void cambiarJugadorDeTurno();

    public abstract void removerJugador();
}
