package main.modelo.excepciones;

public class UnidadNoPuedeMoverseException extends ExcepcionEnJuego{
    @Override
    public String mensajeDeError() {
        return "Unidad no puede moverse";
    }
}
