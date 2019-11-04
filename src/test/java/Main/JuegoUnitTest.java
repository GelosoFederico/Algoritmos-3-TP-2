package Main;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

// TODO que el juego se reinicie al principio y al final de cada test
public class JuegoUnitTest {

    @Test
    public void creoJuegoAgregoJugadoresYLosTiene()
    {
        // Arrange
        Juego.getInstance().reiniciar();
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
        Juego.getInstance().reiniciar();
    }

    @Test
    public void reinicioJuegoYNoTieneLosJugadores()
    {
        // Arrange
        Juego.getInstance().reiniciar();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Juego.getInstance().agregarJugador(jugador1);
        Juego.getInstance().agregarJugador(jugador2);


        // Act
        Juego.getInstance().reiniciar();

        // Assert
        assertEquals(Juego.getInstance().jugadores().size(), 0);
    }

    @Test(expected = JuegoNoPuedeTenerMasDe2Jugadores.class)
    public void creoJuegoAgrego3JugadoresYTiraExcepcionPorSerMasDe2()
    {
        // Arrange
        Juego.getInstance().reiniciar();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();

        // Act
        Juego.getInstance().agregarJugador(jugador1);
        Juego.getInstance().agregarJugador(jugador2);

        // Assert
        Juego.getInstance().agregarJugador(jugador3);
        Juego.getInstance().reiniciar();
    }

    @Test
    public void unidadMuereYJuegoAvisaAJugadorCorrecto()
    {
        // Arrange
        Juego.getInstance().reiniciar();
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

        Juego.getInstance().reiniciar();
    }

}
