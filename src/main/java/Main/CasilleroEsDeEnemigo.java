package Main;

public class CasilleroEsDeEnemigo extends RuntimeException {
    public CasilleroEsDeEnemigo() {
        super("El casillero buscado es del enemigo.");
    }
}