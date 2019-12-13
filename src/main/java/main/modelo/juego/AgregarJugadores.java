package main.modelo.juego;

public class AgregarJugadores extends Fase {

    public AgregarJugadores(Juego juego) {
        super(juego);
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        if (this.juego.jugadores().cantidad() == 0) {
            jugador.equipo(new EquipoBlanco());
            this.juego.agregarJugadorDirecto(jugador);
        } else {
            jugador.equipo(new EquipoNegro());
            this.juego.agregarJugadorDirecto(jugador);
            this.juego.setearFase( new ColocarUnidades(this.juego));
            this.juego.setJugadorDeTurno(this.juego.jugadores().primero());
            this.juego.setSiguientesJugadores();

        }
    }

    @Override
    public void cambiarJugadorDeTurno() {

    }

    @Override
    public void removerJugador(){}
}
