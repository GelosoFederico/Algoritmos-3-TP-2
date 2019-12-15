package main.modelo.excepciones;

public class CasilleroEsDeEnemigoException extends ExcepcionEnJuego {

    @Override
    public String mensajeDeError() {
        return "El casillero es del jugador rival";
    }
}