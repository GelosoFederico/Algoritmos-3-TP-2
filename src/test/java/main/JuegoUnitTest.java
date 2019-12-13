package main;

import main.modelo.excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Jinete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class JuegoUnitTest {
    @Before
    @After
    public void reiniciarJuegoYTablero() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Juego.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
        Field instance2 = Tablero.class.getDeclaredField("INSTANCE");
        instance2.setAccessible(true);
        instance2.set(null, null);
    }


    @Test
    public void creoJuegoAgregoJugadoresYLosTiene()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        List<Jugador> jugadores = new ArrayList<Jugador>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        // Act
        Juego.getInstance().agregarJugador(jugador1);
        Juego.getInstance().agregarJugador(jugador2);

        // Assert
        assertEquals(jugadores, Juego.getInstance().jugadores().jugadores());
    }


    @Test
    public void JuegoAlPrincipioNoTieneJugadores()
    {
        // Act and Assert
        assertEquals(Juego.getInstance().jugadores().cantidad(), 0);
    }


    @Test(expected = JuegoNoPuedeTenerMasDe2JugadoresException.class)
    public void creoJuegoAgrego3JugadoresYTiraExcepcionPorSerMasDe2()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();

        // Act
        Juego.getInstance().agregarJugador(jugador1);
        Juego.getInstance().agregarJugador(jugador2);

        // Assert
        Juego.getInstance().agregarJugador(jugador3);
    }

    @Test
    public void unidadMuereYJuegoAvisaAJugadorCorrecto()
    {
        // Arrange
        Jugador jugadorMock1 = mock(Jugador.class);
        when(jugadorMock1.nombre()).thenReturn("Arkantos");
        Juego.getInstance().agregarJugador(jugadorMock1);
        Jinete jinete1Mock = mock(Jinete.class);
        when(jinete1Mock.getJugador()).thenReturn("Arkantos");

        Jugador jugadorMock2 = mock(Jugador.class);
        Juego.getInstance().agregarJugador(jugadorMock2);

        // Act
        Juego.getInstance().murioUnidad(jinete1Mock);

        // Assert
        verify(jugadorMock1,times(1)).pierdeUnidad(jinete1Mock);
    }

    @Test
    public void alComienzoElTurnoEsDelJugadorQueSeCreoPrimero() {
        // Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.nombre()).thenReturn("Mabel");
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.nombre()).thenReturn("Horacio");

        Juego.getInstance().agregarJugador(mJugador1);
        Juego.getInstance().agregarJugador(mJugador2);

        // Act and assert
        assertEquals("Mabel",Juego.getInstance().getJugadorDeTurno().nombre());
    }

    @Test
    public void despuesDelTurnoDeUnJugadorLeTocaAlOtroJugador() {
        // Arrange
        Jugador jugador1 = new Jugador("Mabel");
        Jugador jugador2 = new Jugador("Horacio");

        Juego.getInstance().agregarJugador(jugador1);
        Juego.getInstance().agregarJugador(jugador2);

        Juego.getInstance().terminarTurno();

        // Act and assert
        assertEquals("Horacio",Juego.getInstance().getJugadorDeTurno().nombre());
    }
}
