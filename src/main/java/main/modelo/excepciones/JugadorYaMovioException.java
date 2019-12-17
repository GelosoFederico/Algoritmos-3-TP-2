package main.modelo.excepciones;

public class JugadorYaMovioException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Jugador ya movió en este turno";
    }
}
