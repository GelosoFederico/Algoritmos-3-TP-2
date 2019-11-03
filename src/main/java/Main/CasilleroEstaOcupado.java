package Main;

public class CasilleroEstaOcupado extends Exception {
    public CasilleroEstaOcupado() {
        super("Casillero se encuentra ocupado!!!!");
    }
}