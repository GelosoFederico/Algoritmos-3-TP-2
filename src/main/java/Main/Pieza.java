package Main;

public class Pieza {
    Casillero casillero;
    void colocarEnElCasilleroDeLaPosicion(Posicion posicion) {
        casillero = Tablero.casilleroDeLaPosicion(posicion);
    }

    Posicion posicionDeCasillero() {
        return casillero.posicion();
    }
}
