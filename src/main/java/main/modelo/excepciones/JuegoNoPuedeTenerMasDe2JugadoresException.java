package main.modelo.excepciones;

public class JuegoNoPuedeTenerMasDe2JugadoresException extends ExcepcionEnJuego {

    @Override
    public String mensajeDeError() {
        return "Juego no puede tener más de 2 jugadores";
    }
}
