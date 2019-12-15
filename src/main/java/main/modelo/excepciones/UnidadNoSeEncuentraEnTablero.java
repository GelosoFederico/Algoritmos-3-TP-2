package main.modelo.excepciones;

public class UnidadNoSeEncuentraEnTablero extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Unidad no se encuentra en el tablero";
    }
}