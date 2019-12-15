package main.modelo.excepciones;

public class ProhibidoAtacarUnidadAliadaException extends ExcepcionEnJuego{
    @Override
    public String mensajeDeError() {
        return "No se puede atacar una unidad aliada";
    }
}
