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
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test03SoldadoAtacaASoldadoEnemigoCon10PuntosDeVidaDosVecesYEsteNoPuedeRecibirDanio(){
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        String unaPosicion = "2,2";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado(10);
        soldadoAliado.setPosicion(unaPosicion);
        soldadoEnemigo.colocarEn(mockedCasillero);
        soldadoAliado.setJugador(jugador1);         //Refactor: unidad no deberia conocer su posicion, casillero si
        soldadoEnemigo.setJugador(jugador2);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(1);
        soldadoAliado.atacar(soldadoEnemigo);

        //Act & Assert
        thrown.expect(UnidadEstaMuertaException.class);
        soldadoAliado.atacar(soldadoEnemigo);
    }

    @Test
    public void test04SoldoAtacaASoldadoAliadoYEsteNoPuedeRecibirDanio() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "ingleses";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        soldadoEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(1);

        //Act & Assert
        thrown.expect(ProhibidoAtacarUnidadAliadaExeption.class);
        soldadoAliado.atacar(soldadoEnemigo);

    }

    @Test
    public void test05unSoldadoAliadoAtacaASoldadoEnemigoADistanciaMediaYSeLanzaUnidadFueraDeRangoException(){
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        String unaPosicion = "2,6";
        String unaPosicionMedia = "2,1";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setPosicion(unaPosicion);
        soldadoEnemigo.setPosicion(unaPosicionMedia);
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
    public void test06SoldadoUbicadoEn11SeMueveParaElNorteYAhoraEstaEnLaPosicion12(){
        //Arrange
        String unaPosicion = "1,1";
        String otraPosicion = "1,2";
        String unaDireccion = "N";
        Soldado unSoldado = new Soldado();
        unSoldado.setPosicion(unaPosicion);
        unSoldado.colocarEn(mockedCasillero);
        when(mockedCasillero.obtenerSiguienteEnDireccion(unaDireccion))
                .thenReturn(mockedCasillero);
        when(mockedCasillero.getPosicion()).thenReturn(otraPosicion);

        //Act
        unSoldado.avanzar(unaDireccion);

        //Assert
        assertEquals(mockedCasillero.getPosicion(), "1,2"); //REFACTOR: unidad no deveria conoces su pos, pedir a casillero
        verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
        verify(mockedCasillero, times(1)).getPosicion();
    }

    @Mock
    public Casillero mockedCasilleroOcupado = mock(Casillero.class);
    @Test
    public void test07SoldadoEn22IntentaMoverseAlSurYElCasilleroEstaOcupado() {
        //Arrange
        String unaPosicion = "2,2";
        String unaDireccion = "S" ;
        Soldado soldado = new Soldado();
        soldado.setPosicion(unaPosicion);
        soldado.colocarEn(mockedCasilleroOcupado);
        when(mockedCasilleroOcupado.obtenerSiguienteEnDireccion(unaDireccion))
                .thenThrow(new CasilleroOcupadoException());

        //Act & Assert
        thrown.expect(CasilleroOcupadoException.class);
        soldado.avanzar(unaDireccion);
    }
}
