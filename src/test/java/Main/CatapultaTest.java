package Main;

import Main.Direccion.Direccion;
import Main.Direccion.Norte;
import Main.Direccion.Posicion;
import Main.Excepciones.UnidadFueraDeRangoException;
import Main.Excepciones.UnidadNoPuedeMoverseException;
import Main.Juego.Jugador;
import Main.Tablero.Tablero;
import Main.Unidad.Catapulta;
import Main.Unidad.Jinete;
import Main.Unidad.Unidad;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CatapultaTest {
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
    public void test01CreoUnaCatapultaPorDefectoYTiene50PuntosDeVida(){
        //Act
        Catapulta unaCatapulta = new Catapulta();

        //Assert
        assertEquals(unaCatapulta.vida(),50);
    }

    @Test
    public void test02CreoUnaCatapultaCon50PuntosDeVidaReciveUnDanioDe15PuntosYSuVidaCambiaA35Puntos() {
        //Arrange
        int vidaInicial = 50;
        Jinete unJinete = new Jinete(vidaInicial);

        //Act
        unJinete.recibirDanio(15);

        //Assert
        assertEquals(unJinete.vida(), 35);

    }

    @Test
    public void test03CatapultaAliadaAtacaACatapultaEnemigaCon50PuntosDeVidaUbicadoADistanciaLejanaYLeQuita20PuntosDeVida() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.numero()).thenReturn(1);
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.numero()).thenReturn(2);
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad catapultaAliada = new Catapulta();
        Unidad catapultaEnemiga = new Catapulta();
        catapultaAliada.setJugador(jugador1);
        catapultaEnemiga.setJugador(jugador2);
        Posicion unaPosicion = new Posicion(2,2);
        Posicion otraPosicion = new Posicion(11,11);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(catapultaAliada,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(catapultaEnemiga,otraPosicion,mJugador2);

        //Act
        catapultaAliada.atacar(catapultaEnemiga);

        //Assert
        assertEquals(catapultaEnemiga.vida(), 30);
    }

    @Test (expected = UnidadFueraDeRangoException.class)
    public void test06unCatapultaAliadaAtacaACatapultaEnemigaADistanciaCercanaYSeLanzaUnidadFueraDeRangoException() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.numero()).thenReturn(1);
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.numero()).thenReturn(2);
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad catapultaAliada = new Catapulta();
        Unidad catapultaEnemiga = new Jinete();
        catapultaAliada.setJugador(jugador1);
        catapultaEnemiga.setJugador(jugador2);
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(11,11);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(catapultaAliada,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(catapultaEnemiga,otraPosicion,mJugador2);

        //Act & Assert
        catapultaAliada.atacar(catapultaEnemiga);
    }

    @Test(expected = UnidadNoPuedeMoverseException.class)
    public void test07CatapultaSeIntentaMoverParaElNorteNoPuedeMoverse() {
        //Arrange
        Direccion unaDireccion = new Norte();
        Catapulta catapulta = new Catapulta();
        Posicion unaPosicion = new Posicion(1,1);
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(catapulta,unaPosicion,mockedJugador);

        //Act & Assert
        catapulta.avanzar(unaDireccion);
    }

}
