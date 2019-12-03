package main.modelo.juego;

public class AgregarJugadores extends Fase {

    public AgregarJugadores(Juego juego) {
        super(juego);
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        if (juego.jugadores().size() == 0) {
            jugador.equipo(new EquipoBlanco());
        } else {
            jugador.equipo(new EquipoNegro());
            juego.setearFase( new ColocarUnidades(this.juego));
            juego.setJugadorDeTurno(juego.jugadores().get(0));
        }
        juego.agregarJugadorDirecto(jugador);
    }

    @Override
    public void cambiarJugadorDeTurno() {

    }
}
