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
    /*
    @Mock
    public Casillero mockedCasillero = mock(Casillero.class);
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test03SoldadoAtacaACuranderoEnemigoCon10PuntosDeVidaDosVecesYEsteNoPuedeRecibirMasDanio(){
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion unaPosicion = new Posicion(2,2);
        //Posicion otraPosicion = new Posicion(2,1);
        Soldado soldadoAliado = new Soldado();
        Curandero curanderoEnemigo = new Curandero(10);
        soldadoAliado.setJugador(jugador1);
        curanderoEnemigo.setJugador(jugador2);
        soldadoAliado.colocarEn(mockedCasillero);
        curanderoEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(1);
        soldadoAliado.atacar(curanderoEnemigo);

        //Act & Assert
        thrown.expect(UnidadEstaMuertaException.class);
        soldadoAliado.atacar(curanderoEnemigo);
    }

    @Test
    public void test04CuranderoAtacaASoldadoEnemigoYEsteNoPuedeRecibirDanio() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion unaPosicion = new Posicion(2,2);
        //Posicion otraPosicion = new Posicion(2,1);
        Curandero curandero = new Curandero();
        Soldado soldadoEnemigo = new Soldado();
        curandero.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        curandero.colocarEn(mockedCasillero);
        soldadoEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(1);

        //Act & Assert
        thrown.expect(ProhibidoCurarUnidadEnemigaException.class);
        curandero.atacar(soldadoEnemigo);

    }

    @Test
    public void test05CuranderoAliadoAtacaAJineteAliadoCon50PuntosDeVidaUbicadoEnDistanciaCercanaYLeSube15PuntosDeVida() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "ingleses";
        //Posicion unaPosicion = new Posicion(1,2);
        //Posicion otraPosicion = new Posicion(1,1);
        Curandero curanderoAliado = new Curandero();
        Jinete jineteAliado = new Jinete(50);
        curanderoAliado.setJugador(jugador1);
        jineteAliado.setJugador(jugador2);
        curanderoAliado.colocarEn(mockedCasillero);
        jineteAliado.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(1);

        //Act
        curanderoAliado.atacar(jineteAliado);

        //Assert
        assertEquals(jineteAliado.vida(), 65); //danio de ataque curandero = -15
        verify(mockedCasillero, times(1)).calcularDistanciaA(mockedCasillero);
    }



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
