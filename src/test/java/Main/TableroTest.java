package Main;

import org.junit.*;
import org.junit.Test;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.Mock;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TableroTest {

    @Before
    @After
    public void reiniciarTablero()
    {
        Tablero.getInstance().reiniciar();
    }
    @Test
    public void testSePuedeColocarUnidadDeJugador1EnCasilleroAliado() {
        Posicion posicion = new Posicion(1,1); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Soldado mSoldado = mock(Soldado.class);
        when(mJugador.numero()).thenReturn(1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mSoldado,posicion,mJugador);
    }
    @Test(expected = CasilleroOcupadoException.class)
    public void testColocarUnidadEnCasilleroOcupadoTiraExcepcion() {
        Posicion posicion = new Posicion(1,2); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Soldado mSoldado = mock(Soldado.class);
        when(mJugador.numero()).thenReturn(1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mSoldado,posicion,mJugador);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mSoldado,posicion,mJugador);
    }

    @Test(expected = CasilleroEsDeEnemigoException.class)
    public void testColocarUnidadDeJugador2EnCasilleroEnemigoTiraExcepcion() {
        Posicion posicion = new Posicion(1,3); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Soldado mSoldado = mock(Soldado.class);
        when(mJugador.numero()).thenReturn(2);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(mSoldado,posicion,mJugador);
    }

    @After
    public void reiniciarJuego()
    {
        Juego.getInstance().reiniciar();
    }
    @Test
    public void testUnidadEn13SeMueveEnUnaDireccionNorte() {
        // Assert
        Posicion posicion = new Posicion(1,3); // Area del jugador 1
        Jugador mJugador = mock(Jugador.class);
        Juego.getInstance().agregarJugador(mJugador);
        Unidad mSoldado = mock(Soldado.class);
        when(mJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(mSoldado, posicion, mJugador);

        // Act
        Tablero.getInstance().moverUnidadEnDireccion(mSoldado,new Norte());
        when(mSoldado.posicion()).thenReturn(Tablero.getInstance().obtenerPosicionDeUnidad(mSoldado));
        when(mSoldado.posicion()).thenReturn(Tablero.getInstance().obtenerPosicionDeUnidad(mSoldado));


        // Assert
        assertEquals(mSoldado.posicion().posicionEnX(),0);
        assertEquals(mSoldado.posicion().posicionEnY(),3);
    }

}
