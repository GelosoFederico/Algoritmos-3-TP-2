package main.modelo.excepciones;

public abstract class ExcepcionEnJuego extends RuntimeException {
    private String mensajeDeError;

    public abstract String mensajeDeError();
}
