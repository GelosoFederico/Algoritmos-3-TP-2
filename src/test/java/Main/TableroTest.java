package Main;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

// Al final, agregar Pieza

public class TableroTest {

    @Test
    public void testObtenerCasilleroAliadoParaJugador1DevuelveCasilleroConExito()  {
        Posicion posicion = new Posicion(1,1);
        Jugador jugador = mock(Jugador.class);
        Tablero unTablero = new Tablero();

        Casillero casillero = unTablero.obtenerCasilleroLibreParaJugador(posicion,jugador);

        assertEquals(casillero.posicion().posicionEnX() ,1);
        assertEquals(casillero.posicion().posicionEnY() ,1);

    }

    @Test(expected = CasilleroEstaOcupado.class)
    public void testNoSePuedeObtenerCasilleroAliadoSiEstaOcupado() throws CasilleroEstaOcupado, CasilleroEsDeEnemigo {
        Jugador jugador = mock(Jugador.class);
        Posicion posicion = new Posicion(1,1);
        Tablero unTablero = new Tablero();

        unTablero.obtenerCasilleroLibreParaJugador(posicion,jugador);
       /* unTablero.obtenerCasilleroLibreParaJugador(posicion,jugador);*/
        // TODO: Va a seguir fallando hasta que este listo el Tablero.obtenerCasilleroDePosicion
    }


    @Test(expected = CasilleroEsDeEnemigo.class)
    public void testNoSePuedeObtenerCasilleroDeEnemigoParaUnJugador() throws CasilleroEstaOcupado, CasilleroEsDeEnemigo {
        Tablero unTablero = new Tablero();
        Jugador jugador = mock(Jugador.class);
        Posicion posicionEnemigo = new Posicion(20,20); // Asumiendo que esto es del sector enemigo

        unTablero.obtenerCasilleroLibreParaJugador(posicionEnemigo,jugador);
    }

    @Test
    public void testCorrecaCreacionEInicializacionDelTablero() {

        Tablero unTablero = new Tablero();

        unTablero.crearCasillerosParaJugador(1);


    }

    @Test
    public void testSeGeneranLosCasillerosParaUnJugadorYSeBuscaUnCasilleroLibreEnPosicion11YDevuelveAlCasillero() {

        Tablero unTablero = new Tablero();
        Casillero unCasillero;
        Posicion posicion = new Posicion(2,3);

        unTablero.crearCasillerosParaJugador(1);

        unCasillero = unTablero.obtenerCasilleroLibreDePosicion(posicion);


        assertEquals(unCasillero.posicion().posicionEnX() ,2);
        assertEquals(unCasillero.posicion().posicionEnY() ,3);
    }





}

