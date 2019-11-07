package Main;

public class Direccion {

    private String direccionString;

    private String norte = "N";
    private String sur = "S";
    private String este = "E";
    private String oeste = "O";
    private String nordeste = "NE";
    private String sudeste = "SE";
    private String noroeste = "NO";
    private String sudoeste = "SO";

    public Direccion(String direccion) {
        this.direccionString = direccion;
    }

    public Posicion posicionRelativa() {
        // TODO hacer esto bien

        if(this.direccionString.equals(norte)) {
            return new Posicion(-1,0);
        }
        if(this.direccionString.equals(sur)) {
            return new Posicion(1,0);
        }
        if(this.direccionString.equals(este)) {
            return new Posicion(0,-1);
        }
        if(this.direccionString.equals(oeste)) {
            return new Posicion(0,1);
        }

        if(this.direccionString.equals(nordeste)) {
            return new Posicion(-1,-1);
        }
        if(this.direccionString.equals(sudeste)) {
            return new Posicion(1,-1);
        }
        if(this.direccionString.equals(sudoeste)) {
            return new Posicion(1,1);
        }
        if(this.direccionString.equals(noroeste)) {
            return new Posicion(-1,1);
        }

        // Esto no deberia llamarase
        // TODO tirar excepcion
        return new Posicion(0,0);
    }

}