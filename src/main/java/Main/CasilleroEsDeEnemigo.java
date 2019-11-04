package Main;

public class CasilleroEsDeEnemigo extends Exception {
    public CasilleroEsDeEnemigo() {
        super("El casillero buscado es del enemigo.");
    }
}