package main.modelo.excepciones;

public class JugadorYaAtacoException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "El jugado ya atacó este turno";
    }
}
