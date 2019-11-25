package Main.Modelo.Excepciones;

public class CasilleroEsDeEnemigoException extends RuntimeException {
    public CasilleroEsDeEnemigoException() {
        super("El casillero buscado es del enemigo.");
    }
}