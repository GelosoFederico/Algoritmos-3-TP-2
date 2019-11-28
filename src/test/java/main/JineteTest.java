package main;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.Norte;
import main.modelo.direccion.Posicion;
import main.modelo.excepciones.CasilleroOcupadoException;
import main.modelo.excepciones.ProhibidoAtacarUnidadAliadaException;
import main.modelo.excepciones.UnidadFueraDeRangoException;
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

public class JineteTest {
    @Before
    @After
    public void reiniciarTablero() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Tablero.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void test01CreounJinetePorDefectoYTiene100PuntosDeVida() {
        //Act
        Jinete unJinete = new Jinete();

        //Assert
        assertEquals(unJinete.vida(), 100);
    }

    @Test
    public void test02CreoUnJineteCon100PuntosDeVidaRecibeUnDanioDe15PuntosYSuVidaCambiaA85Puntos() {
        //Arrange
        int vidaInicial = 100;
        Jinete unJinete = new Jinete(vidaInicial);

        //Act
        unJinete.recibirDanio(15);

        //Assert
        assertEquals(unJinete.vida(), 85);

    }

    @Test
    public void test03JineteAliadoAtacaAJineteEnemigoCon100PuntosDeVidaUbicadoADistanciaMediaYLeQuita15PuntosDeVida() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad jineteAliado = new Jinete();
        Unidad jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.setEquipo(new EquipoBlanco());
        jineteEnemigo.setEquipo(new EquipoNegro());
        Posicion unaPosicion = new Posicion(7,7);
        Posicion otraPosicion = new Posicion(11,11);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteEnemigo,otraPosicion,mJugador2);

        //Act
        jineteAliado.atacar(jineteEnemigo);

        //Assert
        assertEquals(jineteEnemigo.vida(), 85); //danio de jinete a media dist = 15
    }

    @Test (expected = ProhibidoAtacarUnidadAliadaException.class)
    public void test05JineteAtacaAJineteAliadoYEsteNoPuedeRecibirDanio() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        String jugador1 = "ingleses";
        Unidad jineteAliado = new Jinete();
        Unidad jineteAliado2 = new Jinete();
        jineteAliado.setJugador(jugador1);
        jineteAliado2.setJugador(jugador1);
        jineteAliado.setEquipo(new EquipoBlanco());
        jineteAliado2.setEquipo(new EquipoBlanco());
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(9, 8);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado2,otraPosicion,mJugador1);

        //Act & Assert
        jineteAliado.atacar(jineteAliado2);
    }

    @Test(expected = UnidadFueraDeRangoException.class)
    public void test06unJineteAliadoAtacaAJineteEnemigoADistanciaLejanaYSeLanzaUnidadFueraDeRangoException() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad jineteAliado = new Jinete();
        Unidad jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.setEquipo(new EquipoBlanco());
        jineteEnemigo.setEquipo(new EquipoNegro());
        Posicion unaPosicion = new Posicion(3,3);
        Posicion otraPosicion = new Posicion(11,11);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteEnemigo,otraPosicion,mJugador2);

        //Act & Assert
        jineteAliado.atacar(jineteEnemigo);

    }

    @Test
    public void test07JineteUbicadoEn22SeMueveParaElNorteYAhoraEstaEnLaPosicion12() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        Direccion unaDireccion = new Norte();
        Jinete unJinete = new Jinete();
        unJinete.setEquipo(new EquipoBlanco());
        Jugador mockedJugador = mock(Jugador.class);
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());

        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unJinete,unaPosicion,mockedJugador);

        //Act
        unJinete.avanzar(unaDireccion);

        //Assert
        assertEquals(unJinete.posicion().posicionEnX() ,1);
        assertEquals(unJinete.posicion().posicionEnY() ,2);
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void test08JineteEn22IntentaMoverseAlNorteYElCasilleroEstaOcupado() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        Posicion posicionAlNorte = new Posicion(1,2);
        Direccion unaDireccion = new Norte();
        Jinete unJinete = new Jinete();
        Catapulta catapulta = new Catapulta();
        unJinete.setEquipo(new EquipoBlanco());
        catapulta.setEquipo(new EquipoBlanco());

        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.equipo()).thenReturn(new EquipoBlanco());
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unJinete,unaPosicion,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(catapulta,posicionAlNorte,mockedJugador);

        //Act & Assert
        unJinete.avanzar(unaDireccion);
    }

    @Test
    public void test09JineteConUnSoldadoCercaAtacaAEnemigoDeDistanciaMediaExitosamente() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad jineteAliado = new Jinete();
        Unidad soldadoAliado = new Soldado();
        Unidad jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        soldadoAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.setEquipo(new EquipoBlanco());
        soldadoAliado.setEquipo(new EquipoBlanco());
        jineteEnemigo.setEquipo(new EquipoNegro());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado,new Posicion(7,7),mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,new Posicion(7,8),mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteEnemigo,new Posicion(11,11),mJugador2);

        //Act
        jineteAliado.atacar(jineteEnemigo);

        //Assert
        assertEquals(jineteEnemigo.vida(), 85); //danio de jinete a media dist = 15
    }

    @Test(expected = UnidadFueraDeRangoException.class)
    public void test10JineteConUnSoldadoCercaAtacaAEnemigoCercanoYLanzaExcepcionJineteDebeAtacarConArcoYFlecha() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad jineteAliado = new Jinete();
        Unidad soldadoAliado = new Soldado();
        Unidad jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        soldadoAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.setEquipo(new EquipoBlanco());
        soldadoAliado.setEquipo(new EquipoBlanco());
        jineteEnemigo.setEquipo(new EquipoNegro());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado,new Posicion(9,9),mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,new Posicion(8,9),mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteEnemigo,new Posicion(10,10),mJugador2);

        //Act
        jineteAliado.atacar(jineteEnemigo);
    }

    @Test
    public void test11JineteSinAliadosCercaPeroConEnemigoCercaAtacaAlEnemigoCercanoConEspadaExitosamente() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad jineteAliado = new Jinete();
        Unidad jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.setEquipo(new EquipoBlanco());
        jineteEnemigo.setEquipo(new EquipoNegro());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado,new Posicion(7,7),mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteEnemigo,new Posicion(11,11),mJugador2);

        //Act
        jineteAliado.atacar(jineteEnemigo);

        //Assert
        assertEquals(jineteEnemigo.vida(), 85);
    }

    @Test(expected = UnidadFueraDeRangoException.class)
    public void test12JineteSinAliadosCercaPeroConEnemigoCercaNoPuedeAtacarAOtroEnemigoDeDistanciaMedia() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad jineteAliado = new Jinete();
        Unidad soldadoEnemigo = new Soldado();
        Unidad jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.setEquipo(new EquipoBlanco());
        soldadoEnemigo.setEquipo(new EquipoNegro());
        jineteEnemigo.setEquipo(new EquipoNegro());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteAliado,new Posicion(9,9),mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoEnemigo,new Posicion(10,10),mJugador2);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jineteEnemigo,new Posicion(12,12),mJugador2);

        //Act
        jineteAliado.atacar(jineteEnemigo);
    }


}