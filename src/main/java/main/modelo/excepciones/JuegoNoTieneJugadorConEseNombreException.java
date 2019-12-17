package main.modelo.excepciones;

public class JuegoNoTieneJugadorConEseNombreException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Juego no tiene jugador con ese nombre";
    }
}
