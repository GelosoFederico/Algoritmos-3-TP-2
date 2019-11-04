package Main;

public class CasilleroEstaOcupado extends RuntimeException {
    public CasilleroEstaOcupado() {
        super("Casillero se encuentra ocupado!!!!");
    }
}