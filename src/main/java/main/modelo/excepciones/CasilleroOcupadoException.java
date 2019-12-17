package main.modelo.excepciones;

public class CasilleroOcupadoException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Casillero ya ocupado";
    }
}
