package main.modelo.excepciones;

public class InsuficientePuntosRestantesAlColocarUnidadException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "No quedan suficientes puntos para colocar esa unidad";
    }
}
