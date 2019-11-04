package Main;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

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
    public void jugadorColocaUnaUnidadNuevaYRestaSusPuntosParaPoner()
    {
        // Arrange
        Jugador jugador = new Jugador();
        jugador.nombre("Arkantos");
        Integer puntosIniciales = jugador.puntosRestantes();
        Posicion posicion = new Posicion(1,1);
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
    public void jugadorColocaUnaUnidadSinSuficientesPuntosRestantesYLanzaUnaExcepcion()
    {
        // Arrange
        Jugador jugador = new Jugador();
        jugador.nombre("Arkantos");
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(2,2);
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
    public void jugadorPierdeUnidadYYaNoLaTiene(){
        // Arrange
        Jugador jugador = new Jugador();
        // Mocks
        Tablero tableroMock = mock(Tablero.class);
        jugador.set_tablero(tableroMock);

        Jinete jinete1Mock = mock(Jinete.class);
        when(jinete1Mock.coste()).thenReturn(3);
        when(jinete1Mock.getJugador()).thenReturn(jugador.nombre());
        Posicion posicion1 = new Posicion(1,1);
        Jinete jinete2Mock = mock(Jinete.class);
        when(jinete2Mock.getJugador()).thenReturn(jugador.nombre());
        Posicion posicion2 = new Posicion(2,2);

        ArrayList<Unidad> coleccionUnidadesInicio = new ArrayList<Unidad>();
        coleccionUnidadesInicio.add(jinete1Mock);
        coleccionUnidadesInicio.add(jinete2Mock);
        ArrayList<Unidad> coleccionUnidadesFin = new ArrayList<Unidad>();
        coleccionUnidadesFin.add(jinete1Mock);

        // Act
        jugador.colocarUnidadEn(jinete1Mock,posicion1);
        jugador.colocarUnidadEn(jinete2Mock,posicion2);
        ArrayList<Unidad> unidadesInicio = (ArrayList<Unidad>) jugador.unidades().clone();
        jugador.pierdeUnidad(jinete2Mock);

        // Assert
        assertEquals(unidadesInicio,coleccionUnidadesInicio);
        assertEquals(jugador.unidades(),coleccionUnidadesFin);
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
    public void jugadorPierdeTodasSusUnidadesYAnunciaAJuegoQuePerdio(){
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
        when(jinete1Mock.getJugador()).thenReturn(jugador.nombre());
        Posicion posicion1 = new Posicion(1,1);

        jugador.colocarUnidadEn(jinete1Mock,posicion1);

        // Act
        jugador.pierdeUnidad(jinete1Mock);

        // Assert
        verify(juegoMock, times(1)).jugadorPerdio(jugador);
        resetSingleton();
    }

    @Test
    public void creoDosJugadoresYTienenNumerosSiguientes () {
        // Arrange
        // Act
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();

        // Assert
        // Casteo uno porque es ambiguo para el compilador
        assertEquals((int)jugador1.numero(), jugador2.numero()-1);
        assertEquals((int)jugador1.numero(), jugador3.numero()-2);
    }
}
