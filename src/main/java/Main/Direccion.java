package Main;

public class Direccion {


    private String norte = "N";
    String sur = "S";
    String este = "E";
    String oeste = "O";
    String nordeste = "NE";
    String sudeste = "SE";
    String noroeste = "NO";
    String sudoeste = "SO";


    public Posicion posicionSiguienteEnElSentido(Posicion unaPosicion, String unaDireccion) {

        if(unaDireccion.equals(norte)) {
            unaPosicion.decrementarPosicionEnX();
        }
        if(unaDireccion.equals(sur)) {
            unaPosicion.incrementarPosicionEnX();
        }
        if(unaDireccion.equals(este)) {
            unaPosicion.decrementarPosicionEnY();
        }
        if(unaDireccion.equals(oeste)) {
            unaPosicion.incrementarPosicionEnY();
        }

//***********


        if(unaDireccion.equals(nordeste)) {
            unaPosicion.decrementarPosicionEnX();
            unaPosicion.decrementarPosicionEnY();
        }
        if(unaDireccion.equals(sudeste)) {
            unaPosicion.incrementarPosicionEnX();
            unaPosicion.decrementarPosicionEnY();
        }
        if(unaDireccion.equals(sudoeste)) {
            unaPosicion.incrementarPosicionEnX();
            unaPosicion.incrementarPosicionEnY();
        }
        if(unaDireccion.equals(noroeste)) {
            unaPosicion.decrementarPosicionEnX();
            unaPosicion.incrementarPosicionEnY();
        }

        return unaPosicion;

    }

}