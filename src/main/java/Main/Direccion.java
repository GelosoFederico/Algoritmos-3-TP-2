package Main;

public class Direccion {


    private String norte = "N";
    private String sur = "S";
    private String este = "E";
    private String oeste = "O";
    private String nordeste = "NE";
    private String sudeste = "SE";
    private String noroeste = "NO";
    private String sudoeste = "SO";


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