package Main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnidadTest {

    @Test
    public void SoldadoSemueveDesde11Hasta12() {
        //Arrange
        String unaPosicion = "1,1";
        String otraPosicion = "1,2";
        Soldado soldado = new Soldado();
        soldado.setPosicion(unaPosicion);

        //Act
        soldado.avanzar(otraPosicion);

        //Assert
        assertEquals(soldado.getPosicion() , "1,2" );

    }

    @Test
    public void soldadoSeMueveDesde22Hasta12() {
        //Arrange
        String unaPosicion = "2,2";
        String otraPosicion = "1,2";
        Soldado soldado = new Soldado();
        soldado.setPosicion(unaPosicion);

        //Act
        soldado.avanzar(otraPosicion);

        //Assert
        assertEquals(soldado.getPosicion(), "1,2");
    }

    @Mock
    private Casillero mockedCasillero = mock(Casillero.class);
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void SoldadoEn22IntentaMoverseALCasilleroOcupado23YEsteLanzaCasilleroOcupadoException() {
        String unaPosicion = "2,2";
        String unaPosicionOcupada = "2,3";
        Soldado soldado = new Soldado();
        soldado.setPosicion(unaPosicion);
        soldado.setCasillero(mockedCasillero);
        when(mockedCasillero.obtenerSiguienteEnDireccion(unaPosicionOcupada)).thenThrow(new CasilleroOcupadoException());


        thrown.expect(CasilleroOcupadoException.class);
        soldado.avanzar(unaPosicionOcupada);
        verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaPosicionOcupada);
    }

    @Test
    public void testUnSoldadoAliadoAtacaAUnSoldadoEnemigoCercanoYElSoldadoEnemigoPierde10PuntosDeVida() {
        //Arrange
        String unaPosicion = "2,2";
        String unaPosicionCercana = "2,1";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setPosicion(unaPosicion);
        soldadoEnemigo.setPosicion(unaPosicionCercana);

        //Act
        soldadoAliado.atacar(soldadoEnemigo);

        //Assert
        assertEquals(soldadoEnemigo.vida(), 90);
    }

    @Mock
    private Casillero mockedCasilleroInicial = mock(Casillero.class);

    @Test
    public void unSoldadoAliadoAtacaASoldadoEnemigoADistanciaMediaYSeLanzaUnidadFueraDeRangoException(){
        //Arrange
        String unaPosicion = "2,6";
        String unaPosicionMedia = "2,1";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setPosicion(unaPosicion);
        soldadoEnemigo.setPosicion(unaPosicionMedia);
        soldadoAliado.setCasillero(mockedCasilleroInicial);
        soldadoEnemigo.setCasillero(mockedCasilleroInicial);
        when(mockedCasilleroInicial.calcularDistanciaA(mockedCasilleroInicial))
                .thenReturn(5);

        //Act
        thrown.expect(UnidadFueraDeRangoException.class);
        soldadoAliado.atacar(soldadoEnemigo);

        //Assert
     //   verify(mockedCasilleroInicial, times(1))
    //            .calcularDistanciaA(mockedCasilleroInicial);

    }

    @Test
    public void unjineteAliadoAtacaAJineteEnemigoAMediaDistanciaYLeResta15PuntosDeVida(){
        //Arrange
        String unaPosicion = "0,1";
        String unaPosicionMedia = "0,5";
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete();
        jineteAliado.setPosicion(unaPosicion);
        jineteEnemigo.setPosicion(unaPosicionMedia);

        //Act
        jineteAliado.atacar(jineteEnemigo);

        //Assert
        assertEquals(jineteEnemigo.getVida(), 85);


    }

}