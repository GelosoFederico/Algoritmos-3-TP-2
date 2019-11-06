package Main;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SoldadoTest {

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
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion posicionAliada = new Posicion(1,2);
        //Posicion posicionEnemiga = new Posicion(1,1);
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        soldadoAliado.colocarEn(mockedCasillero);
        soldadoEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(1);

        //Act
        soldadoAliado.atacar(soldadoEnemigo);

        //Assert
        assertEquals(soldadoEnemigo.vida(), 90); //danio de jinete a media dist = 15
        verify(mockedCasillero, times(1)).calcularDistanciaA(mockedCasillero);
    }

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
    public void test07SoldadoUbicadoEn11SeMueveParaElNorteYAhoraEstaEnLaPosicion12(){
        //Arrange
        Posicion unaPosicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,2);
        String unaDireccion = "N";
        Soldado unSoldado = new Soldado();
        unSoldado.colocarEn(mockedCasillero);
        when(mockedCasillero.obtenerSiguienteEnDireccion(unaDireccion))
                .thenReturn(mockedCasillero);
        when(mockedCasillero.posicion()).thenReturn(otraPosicion);

        //Act
        unSoldado.avanzar(unaDireccion);

        //Assert
        assertEquals(mockedCasillero.posicion().posicionEnX() ,1);
        assertEquals(mockedCasillero.posicion().posicionEnY() ,2);
        verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
        verify(mockedCasillero, times(2)).posicion();
    }

    @Mock
    public Casillero mockedCasilleroOcupado = mock(Casillero.class);
    @Test
    public void test08SoldadoEn22IntentaMoverseAlNorteYElCasilleroEstaOcupado() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        String unaDireccion = "N" ;
        Soldado soldado = new Soldado();
        soldado.colocarEn(mockedCasilleroOcupado);
        when(mockedCasilleroOcupado.obtenerSiguienteEnDireccion(unaDireccion))
                .thenThrow(new CasilleroOcupadoException());

        //Act & Assert
        thrown.expect(CasilleroOcupadoException.class);
        soldado.avanzar(unaDireccion);
    }
}
