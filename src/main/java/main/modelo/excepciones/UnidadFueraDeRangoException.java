package main.modelo.excepciones;

public class UnidadFueraDeRangoException extends ExcepcionEnJuego{
    @Override
    public String mensajeDeError() {
        return "Esa unidad está fuera de rango";
    }
}
