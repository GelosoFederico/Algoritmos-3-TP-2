package main.modelo.excepciones;

public class UnidadEstaMuertaException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Unidad ya está muerta";
    }
}
