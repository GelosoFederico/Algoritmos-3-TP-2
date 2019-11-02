package Main;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

// Al final, agregar Pieza

public class TableroTest {
    @Test
    public void testObtenerCasilleroAliadoParaJugador1DevuelveCasilleroConExito() {
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = mock(Jugador.class);
        Casillero casillero = Tablero.obtenerCasilleroLibreParaJugador(posicion,jugador);
        assertEquals(casillero.posicion(),posicion);
    }
    @Test
    public void testNoSePuedeColocarPiezaAliadaEnUnCasilleroOcupadoDelSectorAliado() {
        Jugador jugador1 = new Jugador();
        Pieza pieza1 = new Pieza();
        Pieza pieza2 = new Pieza();
        Tablero tablero = new Tablero();
        //tablero.colocarPiezaDeJugadorEnCasillero(pieza1,jugador1,"A1");
        //tablero.colocarPiezaDeJugadorEnCasillero(pieza2,jugador1,"A1");

    }

    @Test
    public void testNoSePuedeColocarPiezaAliadaEnUnCasilleroDelSectorEnemigo() {

        Assert.assertTrue(true);
    }

    @Test
    public void testCorrecaCreacionEInicializacionDelTablero() {

        Assert.assertTrue(true);
    }


}

