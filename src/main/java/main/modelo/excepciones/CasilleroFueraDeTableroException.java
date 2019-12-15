package main.modelo.excepciones;

public class CasilleroFueraDeTableroException extends ExcepcionEnJuego {

    @Override
    public String mensajeDeError() {
        return "El casillero no está en el tablero";
    }
}
