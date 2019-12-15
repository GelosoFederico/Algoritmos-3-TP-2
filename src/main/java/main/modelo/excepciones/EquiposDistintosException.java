package main.modelo.excepciones;

public class EquiposDistintosException extends ExcepcionEnJuego {
    @Override
    public String mensajeDeError() {
        return "Unidades son de equipos distintos";
    }
}
