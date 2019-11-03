package Main;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class JuegoUnitTest {

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

    @Test(expected = JuegoNoPuedeTenerMasDe2Jugadores.class)
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

}
