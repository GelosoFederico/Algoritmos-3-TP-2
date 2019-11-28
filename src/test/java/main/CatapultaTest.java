package main;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.Norte;
import main.modelo.direccion.Posicion;
import main.modelo.excepciones.UnidadFueraDeRangoException;
import main.modelo.excepciones.UnidadNoPuedeMoverseException;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Catapulta;
import main.modelo.unidad.Jinete;
import main.modelo.unidad.Unidad;
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
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad catapultaAliada = new Catapulta();
        Unidad catapultaEnemiga = new Catapulta();
        catapultaAliada.setJugador(jugador1);
        catapultaEnemiga.setJugador(jugador2);
        catapultaAliada.setEquipo(new EquipoBlanco());
        catapultaEnemiga.setEquipo(new EquipoNegro());
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
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad catapultaAliada = new Catapulta();
        Unidad catapultaEnemiga = new Catapulta();
        catapultaAliada.setJugador(jugador1);
        catapultaEnemiga.setJugador(jugador2);
        catapultaAliada.setEquipo(new EquipoBlanco());
        catapultaEnemiga.setEquipo(new EquipoNegro());
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
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        String jugador1 = "ingleses";
        Direccion unaDireccion = new Norte();
        Catapulta catapulta = new Catapulta();
        Posicion unaPosicion = new Posicion(1,1);
        Jugador mockedJugador = mock(Jugador.class);
        catapulta.setJugador(jugador1);
        catapulta.setEquipo(new EquipoBlanco());
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(catapulta,unaPosicion,mockedJugador);

        //Act & Assert
        catapulta.avanzar(unaDireccion);
    }

}
