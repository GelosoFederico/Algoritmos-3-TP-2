package main.modelo.excepciones;

public class PosicionesNoEstanADistanciaUnoException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "La distancia es mayor a 1";
    }
}
