package Main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Vector;

public class JugadorUnitTest
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

    @Test(expected = InsuficientePuntosRestantesAlColocarUnidad.class)
    public void JugadorColocaUnaUnidadSinSuficientesPuntosRestantesYLanzaUnaExcepcion()
    {
        // Arrange
        Jugador jugador = new Jugador();
        jugador.nombre("Arkantos");
        String posicion1 = "(1,1)";
        String posicion2 = "(2,2)";
        // Mocks
        Jinete jinete1Mock = mock(Jinete.class);
        when(jinete1Mock.coste()).thenReturn(11);
        Tablero tableroMock = mock(Tablero.class);
        jugador.set_tablero(tableroMock);
        // Act
        // Lleno el tablero
        jugador.colocarUnidadEn(jinete1Mock,posicion1);
        Jinete jinete2Mock = mock(Jinete.class);
        when(jinete2Mock.coste()).thenReturn(11);

        // Assert
        // Espera una excepcion
        jugador.colocarUnidadEn(jinete2Mock,posicion2);
    }

    @Test
    public void JugadorPierdeUnidadYYaNoLaTiene(){
        // Arrange
        Jugador jugador = new Jugador();
        // Mocks
        Tablero tableroMock = mock(Tablero.class);
        jugador.set_tablero(tableroMock);

        Jinete jinete1Mock = mock(Jinete.class);
        when(jinete1Mock.coste()).thenReturn(3);
        when(jinete1Mock.jugador()).thenReturn(jugador);
        String posicion1 = "(1,1)";
        Jinete jinete2Mock = mock(Jinete.class);
        when(jinete2Mock.jugador()).thenReturn(jugador);
        String posicion2 = "(2,2)";

        Vector<Unidad> vectorUnidadesInicio = new Vector<Unidad>();
        vectorUnidadesInicio.add(jinete1Mock);
        vectorUnidadesInicio.add(jinete2Mock);
        Vector<Unidad> vectorUnidadesFin = new Vector<Unidad>();
        vectorUnidadesFin.add(jinete1Mock);

        // Act
        jugador.colocarUnidadEn(jinete1Mock,posicion1);
        jugador.colocarUnidadEn(jinete2Mock,posicion2);
        Vector<Unidad> unidadesInicio = (Vector<Unidad>) jugador.unidades().clone();
        jugador.pierdeUnidad(jinete2Mock);

        // Assert
        assertEquals(unidadesInicio,vectorUnidadesInicio);
        assertEquals(jugador.unidades(),vectorUnidadesFin);
    }

    private void setMock(Juego juegoMock) {
        // Esto hace que el campo sea accesible y lo cambia por el mock
        try {
            Field instance = Juego.class.getDeclaredField("INSTANCE");
            instance.setAccessible(true);
            instance.set(instance, juegoMock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void resetSingleton()  {
        // Esto hace que el campo sea como era antes, aunque el set(null,null) me deja dudando
        try {
        Field instance = Juego.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null); // TODO consultar esto
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void JugadorPierdeTodasSusUnidadesYAnunciaAJuegoQuePerdio(){
        // Es necesario mockear la clase Juego que es un singleton para ver si le envia el mensaje correctamente
        // Sacado de https://stackoverflow.com/a/50199670
        // Usa reflexion
        Juego juegoMock = mock(Juego.class);
        setMock(juegoMock);

        // Arrange
        Jugador jugador = new Jugador();

        Tablero tableroMock = mock(Tablero.class);
        jugador.set_tablero(tableroMock);

        Jinete jinete1Mock = mock(Jinete.class);
        when(jinete1Mock.coste()).thenReturn(3);
        when(jinete1Mock.jugador()).thenReturn(jugador);
        String posicion1 = "(1,1)";

        jugador.colocarUnidadEn(jinete1Mock,posicion1);

        // Act
        jugador.pierdeUnidad(jinete1Mock);

        // Assert
        verify(juegoMock, times(1)).jugadorPerdio(jugador);
        resetSingleton();
    }
}
