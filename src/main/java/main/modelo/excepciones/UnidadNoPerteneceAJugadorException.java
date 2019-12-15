package main.modelo.excepciones;

public class UnidadNoPerteneceAJugadorException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Unidad no pertenece a jugador";
    }
}
