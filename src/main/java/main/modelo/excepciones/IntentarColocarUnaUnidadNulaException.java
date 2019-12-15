package main.modelo.excepciones;

public class IntentarColocarUnaUnidadNulaException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "No se puede colocar una unidad nula";
    }
}
