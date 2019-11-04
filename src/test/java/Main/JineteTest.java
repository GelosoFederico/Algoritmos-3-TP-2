package Main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JineteTest {

    @Test
    public void test01CreounJinetePorDefectoYTiene100PuntosDeVida() {
        //Act
        Jinete unJinete = new Jinete();

        //Assert
        assertEquals(unJinete.vida(), 100);
    }

    @Test
    public void test02CreoUnJineteCon100PuntosDeVidaReciveUnDanioDe15PuntosYSuVidaCambiaA85Puntos() {
        //Arrange
        int vidaInicial = 100;
        Jinete unJinete = new Jinete(vidaInicial);

        //Act
        unJinete.recibirDanio(15);

        //Assert
        assertEquals(unJinete.vida(), 85);

    }

    @Mock
    public Casillero mockedCasillero = mock(Casillero.class);

    @Test
    public void test03JineteAliadoAtacaAJineteEnemigoCon100PuntosDeVidaUbicadoEnRangoMedioYLeQuita15PuntosDeVida() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Posicion posicionAliada = new Posicion(1,5);
        Posicion posicionEnemiga = new Posicion(1,1);
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete();
        jineteAliado.setPosicion(posicionAliada);
        jineteAliado.setPosicion(posicionEnemiga);
        jineteAliado.colocarEn(mockedCasillero);
        jineteEnemigo.colocarEn(mockedCasillero);
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(4);

        //Act
        jineteAliado.atacar(jineteEnemigo);

        //Assert
        assertEquals(jineteEnemigo.vida(), 85); //danio de jinete a media dist = 15
        verify(mockedCasillero, times(1)).calcularDistanciaA(mockedCasillero);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test04JineteAtacaAJineteEnemigoCon10PuntosDeVidaDosVecesYEsteNoPuedeRecibirMasDanio() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Posicion unaPosicion = new Posicion(2,2);
        Posicion otraPosicion = new Posicion(2,6);
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete(10);
        jineteAliado.setPosicion(unaPosicion);
        jineteEnemigo.setPosicion(otraPosicion);
        jineteAliado.colocarEn(mockedCasillero);
        jineteEnemigo.colocarEn(mockedCasillero);
        jineteAliado.setJugador(jugador1);         //Refactor: unidad no deberia conocer su posicion, casillero si
        jineteEnemigo.setJugador(jugador2);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(3);
        jineteAliado.atacar(jineteEnemigo);

        //Act & Assert
        thrown.expect(UnidadEstaMuertaException.class);
        jineteAliado.atacar(jineteEnemigo);
        verify(mockedCasillero, times(2)).calcularDistanciaA(mockedCasillero);
    }

    @Test
    public void test05JineteAtacaAJineteAliadoYEsteNoPuedeRecibirDanio() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "ingleses";
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        Posicion unaPosicion = new Posicion(2,2);
        Posicion otraPosicion = new Posicion(2,6);
        jineteAliado.colocarEn(mockedCasillero);
        jineteEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(5);

        //Act & Assert
        thrown.expect(ProhibidoAtacarUnidadAliadaExeption.class);
        jineteAliado.atacar(jineteEnemigo);
        verify(mockedCasillero, times(1)).calcularDistanciaA(mockedCasillero);
    }

    @Test
    public void test06unJineteAliadoAtacaAJineteEnemigoADistanciaLejanaYSeLanzaUnidadFueraDeRangoException() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        Posicion unaPosicion = new Posicion(2,1);
        Posicion unaPosicionLejana = new Posicion(2,8);
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete();
        jineteAliado.setPosicion(unaPosicion);
        jineteEnemigo.setPosicion(unaPosicionLejana);
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.colocarEn(mockedCasillero);
        jineteEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(7);

        //Act & Assert
        thrown.expect(UnidadFueraDeRangoException.class);
        jineteAliado.atacar(jineteEnemigo);
    }

    @Test
    public void test07JineteUbicadoEn00SeMueveParaElNorteYAhoraEstaEnLaPosicion01() {
        //Arrange
        Posicion unaPosicion = new Posicion(0,0);
        Posicion otraPosicion = new Posicion(0,1);
        String unaDireccion = "N";
        Jinete unJinete = new Jinete();
        unJinete.setPosicion(unaPosicion);
        unJinete.colocarEn(mockedCasillero);
        when(mockedCasillero.obtenerSiguienteEnDireccion(unaDireccion))
                .thenReturn(mockedCasillero);
        when(mockedCasillero.posicion()).thenReturn(otraPosicion);

        //Act
        unJinete.avanzar(unaDireccion);

        //Assert
        assertEquals(mockedCasillero.posicion().posicionEnX() ,0);
        assertEquals(mockedCasillero.posicion().posicionEnY() ,1);
        verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
//        verify(mockedCasillero, times(1)).posicion();
    }

    @Mock
    public Casillero mockedCasilleroOcupado = mock(Casillero.class);
    @Test
    public void test08SoldadoEn22IntentaMoverseAlEsteYElCasilleroEstaOcupado() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        String unaDireccion = "E";
        Jinete jinete = new Jinete();
        jinete.setPosicion(unaPosicion);
        jinete.colocarEn(mockedCasilleroOcupado);
        when(mockedCasilleroOcupado.obtenerSiguienteEnDireccion(unaDireccion))
                .thenThrow(new CasilleroOcupadoException());

        //Act & Assert
        thrown.expect(CasilleroOcupadoException.class);
        jinete.avanzar(unaDireccion);
        verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
    }
}