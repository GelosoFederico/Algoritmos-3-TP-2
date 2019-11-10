package Main;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Al final, agregar Pieza

public class TableroTest {

    @Test
    public void testObtenerCasilleroAliadoParaJugador1DevuelveCasilleroConExito() {
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = mock(Jugador.class);
        when(jugador.numero()).thenReturn(1);
        Tablero unTablero = new Tablero();
        Casillero casillero = unTablero.obtenerCasilleroParaJugador(posicion,jugador);

        Assert.assertTrue(new ReflectionEquals(posicion).matches(casillero.posicion()));
    }

    /*
    // TODO este test ya no sirve pero lo dejo por ahora
    @Test(expected = CasilleroOcupadoException.class)
    public void testNoSePuedeObtenerCasilleroAliadoSiEstaOcupado() {
        Jugador jugador = mock(Jugador.class);
        when(jugador.numero()).thenReturn(1);
        Posicion posicion = new Posicion(1,1);
        Tablero unTablero = new Tablero();

        unTablero.obtenerCasilleroEnPosicion(posicion).ocupar();

        unTablero.obtenerCasilleroLibreParaJugador(posicion,jugador);
    }
    */


    @Test(expected = CasilleroEsDeEnemigoException.class)
    public void testNoSePuedeObtenerCasilleroDeEnemigoParaUnJugador() {
        Tablero unTablero = new Tablero();
        Jugador jugador = mock(Jugador.class);
        when(jugador.numero()).thenReturn(2);
        Posicion posicionEnemigo = new Posicion(1,1); // Asumiendo que esto es del sector enemigo
        unTablero.obtenerCasilleroParaJugador(posicionEnemigo,jugador);
    }

    @Test
    public void testCorrectaCreacionEInicializacionDelTablero() {
        Tablero unTablero = new Tablero();
    }

    @Test
    public void testSeGeneranLosCasillerosParaUnJugadorYSeBuscaUnCasilleroLibreEnPosicion23YDevuelveAlCasillero() {

        Tablero unTablero = new Tablero();
        Casillero unCasillero;
        Posicion posicion = new Posicion(2,3);

        unCasillero = unTablero.obtenerCasilleroEnPosicion(posicion);


        assertEquals(unCasillero.posicion().posicionEnX() ,2);
        assertEquals(unCasillero.posicion().posicionEnY() ,3);
    }





}

