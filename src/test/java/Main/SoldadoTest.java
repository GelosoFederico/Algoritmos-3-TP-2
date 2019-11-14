package Main;
import org.junit.Rule;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SoldadoTest {

    @Before // TODO: esto en algun momento se corrije
    @After
    public void reiniciarTablero()
    {
        Tablero.getInstance().reiniciar();
    }

    @Test
    public void test01CreoUnSoldadoPorDefectoYTiene100PuntosDeVida(){
        //Act
        Soldado unSoldado = new Soldado();

        //Assert
        assertEquals(unSoldado.vida(),100);
    }

    @Test
    public void test02CreoUnSolDadoCon100PuntosDeVidaReciveUnDanioDe10PuntosYSuVidaCambiaA90Puntos(){
        //Arrange
        int vidaInicial = 100;
        Soldado unSoldado = new Soldado(vidaInicial);

        //Act
        unSoldado.recibirDanio(10);

        //Assert
        assertEquals(unSoldado.vida(), 90);

    }

    @Mock
    public Casillero mockedCasillero = mock(Casillero.class);
    @Test
    public void test03SoldadoAliadoAtacaASoldadoEnemigoCon100PuntosDeVidaUbicadoADistanciaCercanaYLeQuita10PuntosDeVida() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.numero()).thenReturn(1);
        Jugador mJugador2 = mock(Jugador.class);
        when(mJugador2.numero()).thenReturn(2);
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(11,11);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoEnemigo,otraPosicion,mJugador2);

        //Act
        soldadoAliado.atacar(soldadoEnemigo);

        //Assert
        assertEquals(soldadoEnemigo.vida(), 90);
    }
/*
    //@RunWith(PowerMockRunner.class)
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test04SoldadoAtacaADistanciaCercanaASoldadoEnemigoCon10PuntosDeVidaDosVecesYEsteNoPuedeRecibirDanio(){
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion unaPosicion = new Posicion(2,2);
        //Posicion otraPosicion = new Posicion(1,2);
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado(10);
        soldadoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        soldadoAliado.colocarEn(mockedCasillero);   //DUDA HACE FALTA INICIALIZAR CON Casillero(unaPosicion,1)
        soldadoEnemigo.colocarEn(mockedCasillero);  //Y MOCKEAR ESE NEW ¿?
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(1);
        soldadoAliado.atacar(soldadoEnemigo);

        //Act & Assert
        thrown.expect(UnidadEstaMuertaException.class);
        soldadoAliado.atacar(soldadoEnemigo);
    }

    @Test
    public void test05SoldoAtacaASoldadoAliadoYEsteNoPuedeRecibirDanio() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "ingleses";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        soldadoAliado.colocarEn(mockedCasillero);
        soldadoEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(1);

        //Act & Assert
        thrown.expect(ProhibidoAtacarUnidadAliadaException.class);
        soldadoAliado.atacar(soldadoEnemigo);

    }

    @Test
    public void test06unSoldadoAliadoAtacaASoldadoEnemigoADistanciaMediaYSeLanzaUnidadFueraDeRangoException(){
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion unaPosicion = new Posicion(2,6);
        //Posicion unaPosicionMedia = new Posicion(2,1);
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        soldadoAliado.colocarEn(mockedCasillero);
        soldadoEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(5);

        //Act & Assert
        thrown.expect(UnidadFueraDeRangoException.class);
        soldadoAliado.atacar(soldadoEnemigo);
    }

    @Test
    public void test07SoldadoUbicadoEn11SeMueveParaElNorteYAhoraEstaEnLaPosicion01(){
        //Arrange
        Posicion unaPosicion = new Posicion(1,1);
//        Posicion otraPosicion = new Posicion(1,2);
        Direccion unaDireccion = new Norte();
        Soldado unSoldado = new Soldado();
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
            .colocarUnidadEnPosicionDeJugador(unSoldado,unaPosicion,mockedJugador);

        //Act
        unSoldado.avanzar(unaDireccion);

        //Assert
        assertEquals(unSoldado.posicion().posicionEnX() ,0);
        assertEquals(unSoldado.posicion().posicionEnY() ,1);
        //verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
        //verify(mockedCasillero, times(2)).posicion();
    }

    @Test
    public void test08SoldadoEn22IntentaMoverseAlNorteYElCasilleroEstaOcupado() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        Posicion posicionAlNorte = new Posicion(1,2);
        Direccion unaDireccion = new Norte();
        Soldado unSoldado = new Soldado();
        Catapulta mockedCatapulta = mock(Catapulta.class);

        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unSoldado,unaPosicion,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(mockedCatapulta,posicionAlNorte,mockedJugador);

        //Act & Assert
        thrown.expect(CasilleroOcupadoException.class);
        unSoldado.avanzar(unaDireccion);
    }
    
 */
}
