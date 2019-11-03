package Main;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

// Al final, agregar Pieza

public class TableroTest {
    @Test
    public void testObtenerCasilleroAliadoParaJugador1DevuelveCasilleroConExito() throws CasilleroEstaOcupado {
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = mock(Jugador.class);
        Casillero casillero = Tablero.obtenerCasilleroLibreParaJugador(posicion,jugador);
        assertEquals(casillero.posicion(),posicion);
    }

    @Test(expected = CasilleroEstaOcupado.class)
    public void testNoSePuedeObtenerCasilleroAliadoSiEstaOcupado() throws CasilleroEstaOcupado {
        Jugador jugador = mock(Jugador.class);
        Posicion posicion = new Posicion(1,1);
        Tablero.obtenerCasilleroLibreParaJugador(posicion,jugador);
        Tablero.obtenerCasilleroLibreParaJugador(posicion,jugador);
        // TODO: Va a seguir fallando hasta que este listo el Tablero.obtenerCasilleroDePosicion
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

