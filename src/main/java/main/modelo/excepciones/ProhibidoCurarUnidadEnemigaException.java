package main.modelo.excepciones;

public class ProhibidoCurarUnidadEnemigaException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "No se puede curar una unidad enemiga";
    }
}
