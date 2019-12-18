package main.modelo.excepciones;

public class BandosNoCoincenExeption extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Los bandos no coinciden";
    }
}
