package Main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class JugadorTest
{
    @Test
    public void creoJugadorYLePongoNombre()
    {
        // Arrange
        Jugador jugador = new Jugador();

        // Act
        jugador.nombre("Arkantos");

        // Assert
        assertEquals( jugador.nombre() , "Arkantos");
    }

    @Test
    public void JugadorColocaUnaUnidadNuevaYRestaSusPuntosParaPoner()
    {
        // Arrange
        Jugador jugador = new Jugador();
        jugador.nombre("Arkantos");
        Integer puntosIniciales = jugador.puntosRestantes();
        String posicion = "(1,1)";
        // Arrange mocks
        Jinete jineteMock = mock(Jinete.class);
        when(jineteMock.coste()).thenReturn(3);
        Tablero tableroMock = mock(Tablero.class);
        jugador.set_tablero(tableroMock);

        // Act
        jugador.colocarUnidadEn(jineteMock,posicion);

        // Assert
        assertTrue( puntosIniciales - 3 == jugador.puntosRestantes());
    }
}
