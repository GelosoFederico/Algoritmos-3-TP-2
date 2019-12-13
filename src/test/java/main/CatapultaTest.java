package main;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.DireccionNorte;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.excepciones.UnidadFueraDeRangoException;
import main.modelo.excepciones.UnidadNoPuedeMoverseException;
import main.modelo.juego.EquipoBlanco;
import main.modelo.juego.EquipoNegro;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Catapulta;
import main.modelo.unidad.Jinete;
import main.modelo.unidad.Soldado;
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
    public void test02CreoUnaCatapultaCon50PuntosDeVidaRecibeUnDanioDe15PuntosYSuVidaCambiaA35Puntos() {
        //Arrange
        Unidad unidad = new Catapulta();
        unidad.setEquipo(new EquipoBlanco());
        Posicion unaPosicion = new Posicion(2,2);
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(unidad,unaPosicion,mJugador1);

        //Act
        unidad.recibirDanio(15);

        //Assert
        assertEquals(unidad.vida(), 35);

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
    public void test04unCatapultaAliadaAtacaACatapultaEnemigaADistanciaCercanaYSeLanzaUnidadFueraDeRangoException() {
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
    public void test05CatapultaSeIntentaMoverParaElNorteNoPuedeMoverse() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        String jugador1 = "ingleses";
        Direccion unaDireccion = new DireccionNorte();
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

    @Test
    public void test06CatapultaAliadaAtacaAUnidadEnemigaCon50PuntosDeVidaUbicadoADistanciaLejanaYLeQuita20PuntosDeVida() {
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

    @Test
    public void test07CatapultaAliadaAtacaAUnidadEnemigaConExpansionDistanciaLejanaYLeQuita20PuntosDeVidaYASusAlrededores() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";

        Unidad catapultaAliada = new Catapulta();
        Unidad catapultaEnemiga = new Catapulta();
        Unidad soldadoEnemigo1 = new Soldado();
        Unidad unJinete = new Jinete();

        catapultaAliada.setJugador(jugador1);
        catapultaEnemiga.setJugador(jugador2);

        catapultaAliada.setEquipo(new EquipoBlanco());
        catapultaEnemiga.setEquipo(new EquipoNegro());
        soldadoEnemigo1.setEquipo(new EquipoNegro());
        unJinete.setEquipo(new EquipoNegro());

        Posicion unaPosicion = new Posicion(2,2);
        Posicion otraPosicion = new Posicion(11,11);
        Posicion posicionSoldado = new Posicion(12,11);
        Posicion posicionJinete = new Posicion(12,12);

        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(catapultaAliada,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(catapultaEnemiga,otraPosicion,mJugador2);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoEnemigo1,posicionSoldado,mJugador2);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(unJinete,posicionJinete,mJugador2);


        //Act
        catapultaAliada.atacar(catapultaEnemiga);

        //Assert
        assertEquals(catapultaEnemiga.vida(), 30);
        assertEquals(soldadoEnemigo1.vida(), 80);
        assertEquals(unJinete.vida(), 80);
    }

}
