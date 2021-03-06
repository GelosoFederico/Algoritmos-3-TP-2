package main;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.DireccionNorte;
import main.modelo.tablero.distancia.Posicion;
import main.modelo.excepciones.CasilleroOcupadoException;
import main.modelo.excepciones.ProhibidoCurarUnidadEnemigaException;
import main.modelo.excepciones.UnidadFueraDeRangoException;
import main.modelo.juego.EquipoBlanco;
import main.modelo.juego.EquipoNegro;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Catapulta;
import main.modelo.unidad.Curandero;
import main.modelo.unidad.Soldado;
import main.modelo.unidad.Unidad;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CuranderoTest {
    @Before
    @After
    public void reiniciarTableroYJuego() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Tablero.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
        Field instance2 = Juego.class.getDeclaredField("INSTANCE");
        instance2.setAccessible(true);
        instance2.set(null, null);
    }


    @Test
    public void test01CreoUnuranderoPorDefectoYTiene75PuntosDeVida(){
        //Act
        Curandero unCurandero = new Curandero();

        //Assert
        assertEquals(unCurandero.vida(),75);
    }

    @Test
    public void test02CreoUnCuranderoCon75PuntosDeVidaRecibeUnDanioDe10PuntosYSuVidaCambiaA65Puntos(){
        //Arrange
        Curandero unCurandero = new Curandero();
        unCurandero.setEquipo(new EquipoBlanco());
        Posicion unaPosicion = new Posicion(2,2);
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(unCurandero,unaPosicion,mJugador1);


        //Act
        unCurandero.recibirDanio(10);

        //Assert
        assertEquals(unCurandero.vida(), 65);

    }

    @Test(expected = ProhibidoCurarUnidadEnemigaException.class)
    public void test04CuranderoAtacaASoldadoEnemigoYDevuelveUnaExcepcion() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        Unidad curanderoAliado = new Curandero();
        Unidad soldadoEnemigo = new Soldado();
        curanderoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        curanderoAliado.setEquipo(new EquipoBlanco());
        soldadoEnemigo.setEquipo(new EquipoNegro());

        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(10,10);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(curanderoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoEnemigo,otraPosicion,mJugador2);

        //Act & assert
        curanderoAliado.atacar(soldadoEnemigo);

        //Assert
        //assertEquals(soldadoEnemigo.vida(), 90);
    }

    @Test
    public void test05CuranderoAliadoAtacaASoldadoAliadoCon100PuntosDeVidaUbicadoEnDistanciaCercanaYLeSube15PuntosDeVida() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoBlanco());
        String jugador1 = "ingleses";
        Unidad curanderoAliado = new Curandero();
        Unidad soldadoAliado = new Soldado();
        curanderoAliado.setJugador(jugador1);
        soldadoAliado.setJugador(jugador1);
        curanderoAliado.setEquipo(new EquipoBlanco());
        soldadoAliado.setEquipo(new EquipoBlanco());
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(9,8);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(curanderoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,otraPosicion,mJugador1);

        //Act
        curanderoAliado.atacar(soldadoAliado);

        //Assert
        assertEquals(soldadoAliado.vida(), 115);
    }



    @Test (expected = UnidadFueraDeRangoException.class)
    public void test06unCuranderoAliadoAtacaASoldadoAliadoADistanciaMediaYSeLanzaUnidadFueraDeRangoException(){
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.equipo()).thenReturn(new EquipoBlanco());
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.equipo()).thenReturn(new EquipoNegro());
        String jugador1 = "ingleses";
        Unidad curanderoAliado = new Curandero();
        Unidad soldadoAliado = new Soldado();
        curanderoAliado.setJugador(jugador1);
        soldadoAliado.setJugador(jugador1);
        curanderoAliado.setEquipo(new EquipoBlanco());
        soldadoAliado.setEquipo(new EquipoBlanco());
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(5,8);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(curanderoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,otraPosicion,mJugador1);

        //Act & assert
        curanderoAliado.atacar(soldadoAliado);
    }

    @Test
    public void test07CuranderoUbicadoEn11SeMueveParaElNorteYAhoraEstaEnLaPosicion12(){
        //Arrange
        Posicion unaPosicion = new Posicion(1,1);
        Direccion unaDireccion = new DireccionNorte();
        Curandero unCurandero = new Curandero();
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.equipo()).thenReturn(new EquipoBlanco());
        unCurandero.setEquipo(new EquipoBlanco());
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unCurandero,unaPosicion,mockedJugador);

        //Act
        unCurandero.avanzar(unaDireccion);

        //Assert
        assertEquals(unCurandero.posicion().posicionEnX() ,0);
        assertEquals(unCurandero.posicion().posicionEnY() ,1);
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void test08CuranderoEn22IntentaMoverseAlNorteYElCasilleroEstaOcupado() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        Posicion posicionAlNorte = new Posicion(1,2);
        Direccion unaDireccion = new DireccionNorte();
        Curandero unCurandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        unCurandero.setEquipo(new EquipoBlanco());
        catapulta.setEquipo(new EquipoBlanco());
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.equipo()).thenReturn(new EquipoBlanco());
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unCurandero,unaPosicion,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(catapulta,posicionAlNorte,mockedJugador);

        //Act & Assert
        unCurandero.avanzar(unaDireccion);
    }

}
