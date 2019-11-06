package Main;

public class JugadorGanoLaPartida extends RuntimeException {
    private Jugador _jugadorGanador;

    public JugadorGanoLaPartida(Jugador jugador){
        super();
        _jugadorGanador = jugador;
    }

    public Jugador jugadorGanador(){
        return this._jugadorGanador;
    }
}
