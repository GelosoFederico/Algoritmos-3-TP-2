package Main;

import static org.junit.Assert.assertEquals;

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
}
