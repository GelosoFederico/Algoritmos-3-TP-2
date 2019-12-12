package main.modelo.juego;

import main.modelo.excepciones.JugadorGanoLaPartida;
import main.modelo.juego.fase.FaseAgregarJugadores;
import main.modelo.juego.fase.Fase;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.unidad.Unidad;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    // Singleton pattern
    private static Juego INSTANCE = null;

    private ConjuntoDeJugadores jugadores = null;

    private Juego() {
        jugadores = new ConjuntoDeJugadores();
        this.setearFase(new FaseAgregarJugadores(this));
    }

    private Jugador jugadorDeTurno;
    private Fase fase;



    public static Juego getInstance() {
        if( INSTANCE == null) {
            INSTANCE = new Juego();
        }
        return INSTANCE;
    }

    public ConjuntoDeJugadores jugadores() {
        return this.jugadores;
    }

    public Jugador getJugadorDeTurno() {
        return jugadorDeTurno;
    }

    public void setJugadorDeTurno(Jugador jugador) {
        jugadorDeTurno = jugador;
    }

    public void agregarJugador(Jugador jugador) {
        fase.agregarJugador(jugador);
    }

    public void murioUnidad(Unidad unidad) {
        this.encontrarJugadorPorNombre(unidad.getJugador()).pierdeUnidad(unidad);
    }

    private Jugador encontrarJugadorPorNombre(String jugadorNombre) {
        return this.jugadores().encontrarJugadorPorNombre(jugadorNombre);
    }

    public void jugadorPerdio(Jugador jugador) {
        // Esto asume que hay exactamente dos jugadores
        this.jugadores().jugadores().remove(jugador);
        throw new JugadorGanoLaPartida(this.jugadores().primero());
    }

    public void cambiarJugadorDeTurnoDirecto() {
        this.jugadorDeTurno = this.jugadorDeTurno.obtenerSiguienteJugador();
    }

    public void terminarTurno() {
        this.fase.cambiarJugadorDeTurno();
    }

    public void terminarDeColocarParaJugador() {
        this.fase.removerJugador();
    }

    public void setearFase(Fase fase) {
        this.fase = fase;
    }

    public void agregarJugadorDirecto(Jugador jugador) {
        this.jugadores().agregarJugador(jugador);
    }

    public void setSiguientesJugadores() {
        Jugador jugador1 = this.jugadores().primero();
        Jugador jugador2 = this.jugadores().segundo();

        jugador1.setSiguienteJugador(jugador2);
        jugador2.setSiguienteJugador(jugador1);

    }

    public Fase fase() {
        return this.fase;
    }

    public void moverUnidadHacia(Unidad soldado1, Posicion posicion) {
        this.getJugadorDeTurno().moverUnidadHacia(soldado1, posicion);
    }
}
