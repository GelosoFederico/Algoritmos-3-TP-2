package Main;

import Main.Excepciones.JuegoNoPuedeTenerMasDe2JugadoresException;
import Main.Juego.Juego;
import Main.Juego.Jugador;
import Main.Unidad.Jinete;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class JuegoUnitTest {
    @Before
    @After
    public void reiniciarJuego()
    {
        Juego.getInstance().reiniciar();
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
        assertEquals(jugadores, Juego.getInstance().jugadores());
    }

    @Test
    public void reinicioJuegoYNoTieneLosJugadores()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Juego.getInstance().agregarJugador(jugador1);
        Juego.getInstance().agregarJugador(jugador2);


        // Act
        Juego.getInstance().reiniciar();

        // Assert
        assertEquals(Juego.getInstance().jugadores().size(), 0);
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
}
