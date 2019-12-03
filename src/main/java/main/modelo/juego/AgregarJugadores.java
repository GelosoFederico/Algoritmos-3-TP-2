package main.modelo.juego;

public class AgregarJugadores extends Fase {

    public AgregarJugadores(Juego juego) {
        super(juego);
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        if (juego.jugadores().cantidad() == 0) {
            jugador.equipo(new EquipoBlanco());
            juego.agregarJugadorDirecto(jugador);
        } else {
            jugador.equipo(new EquipoNegro());
            juego.agregarJugadorDirecto(jugador);
            juego.setearFase( new ColocarUnidades(this.juego));
            juego.setJugadorDeTurno(juego.jugadores().primero());
        }
    }

    @Override
    public void cambiarJugadorDeTurno() {

    }

    @Override
    public void removerJugador(){}
}
