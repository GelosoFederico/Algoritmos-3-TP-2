package Main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CuranderoTest {
    @Before // TODO: esto en algun momento se corrije
    @After
    public void reiniciarTablero()
    {
        Tablero.getInstance().reiniciar();
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

        //Act
        unCurandero.recibirDanio(10);

        //Assert
        assertEquals(unCurandero.vida(), 65);

    }

    @Test(expected = ProhibidoCurarUnidadEnemigaException.class)
    public void test04CuranderoAtacaASoldadoEnemigoYDevuelveUnaExcepcion() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.numero()).thenReturn(1);
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.numero()).thenReturn(2);
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Unidad curanderoAliado = new Curandero();
        Unidad soldadoEnemigo = new Soldado();
        curanderoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(11,11);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(curanderoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoEnemigo,otraPosicion,mJugador2);

        //Act & assert
        curanderoAliado.atacar(soldadoEnemigo);

        //Assert
        assertEquals(soldadoEnemigo.vida(), 90);
    }

    @Test
    public void test05CuranderoAliadoAtacaASoldadoAliadoCon100PuntosDeVidaUbicadoEnDistanciaCercanaYLeSube15PuntosDeVida() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.numero()).thenReturn(1);
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.numero()).thenReturn(2);
        String jugador1 = "ingleses";
        Unidad curanderoAliado = new Curandero();
        Unidad soldadoAliado = new Soldado();
        curanderoAliado.setJugador(jugador1);
        soldadoAliado.setJugador(jugador1);
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(9,8);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(curanderoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,otraPosicion,mJugador1);

        //Act & assert
        curanderoAliado.atacar(soldadoAliado);

        //Assert
        assertEquals(soldadoAliado.vida(), 115);
    }
    /*



    @Test
    public void test06unCuranderoAliadoAtacaASoldadoAliadoADistanciaMediaYSeLanzaUnidadFueraDeRangoException(){
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "ingleses";
        //Posicion unaPosicion = new Posicion(2,6);
        //Posicion unaPosicionMedia = new Posicion(2,1);
        Curandero curanderoAliado = new Curandero();
        Soldado soldadoAliado = new Soldado();
        curanderoAliado.setJugador(jugador1);
        soldadoAliado.setJugador(jugador2);
        curanderoAliado.colocarEn(mockedCasillero);
        soldadoAliado.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(5);

        //Act & Assert
        thrown.expect(UnidadFueraDeRangoException.class);
        curanderoAliado.atacar(soldadoAliado);
    }

    @Test
    public void test07CuranderoUbicadoEn11SeMueveParaElNorteYAhoraEstaEnLaPosicion12(){
        //Arrange
        Posicion unaPosicion = new Posicion(1,1);
        Direccion unaDireccion = new Norte();
        Curandero unCurandero = new Curandero();
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unCurandero,unaPosicion,mockedJugador);

        //Act
        unCurandero.avanzar(unaDireccion);

        //Assert
        assertEquals(unCurandero.posicion().posicionEnX() ,0);
        assertEquals(unCurandero.posicion().posicionEnY() ,1);
        //verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
        //verify(mockedCasillero, times(2)).posicion();
    }

    @Test
    public void test08CuranderoEn22IntentaMoverseAlNorteYElCasilleroEstaOcupado() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        Posicion posicionAlNorte = new Posicion(1,2);
        Direccion unaDireccion = new Norte();
        Curandero unCurandero = new Curandero();
        Catapulta mockedCatapulta = mock(Catapulta.class);

        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unCurandero,unaPosicion,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(mockedCatapulta,posicionAlNorte,mockedJugador);

        //Act & Assert
        thrown.expect(CasilleroOcupadoException.class);
        unCurandero.avanzar(unaDireccion);
    }

     */

}
