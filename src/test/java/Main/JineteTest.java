package Main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JineteTest {
    @Before // TODO: esto en algun momento se corrije
    @After
    public void reiniciarTablero()
    {
        Tablero.getInstance().reiniciar();
    }

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
    public void test03JineteAliadoAtacaAJineteEnemigoCon100PuntosDeVidaUbicadoADistanciaMediaYLeQuita15PuntosDeVida() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion posicionAliada = new Posicion(1,5);
        //Posicion posicionEnemiga = new Posicion(1,1);
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.colocarEn(mockedCasillero);
        jineteEnemigo.colocarEn(mockedCasillero);
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
        //Posicion unaPosicion = new Posicion(2,2);
        //Posicion otraPosicion = new Posicion(2,6);
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete(10);
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.colocarEn(mockedCasillero);
        jineteEnemigo.colocarEn(mockedCasillero);
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
        //Posicion unaPosicion = new Posicion(2,2);
        //Posicion otraPosicion = new Posicion(2,7);
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete();
        jineteAliado.setJugador(jugador1);
        jineteEnemigo.setJugador(jugador2);
        jineteAliado.colocarEn(mockedCasillero);
        jineteEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(5);

        //Act & Assert
        thrown.expect(ProhibidoAtacarUnidadAliadaException.class);
        jineteAliado.atacar(jineteEnemigo);
        verify(mockedCasillero, times(1)).calcularDistanciaA(mockedCasillero);
    }

    @Test
    public void test06unJineteAliadoAtacaAJineteEnemigoADistanciaLejanaYSeLanzaUnidadFueraDeRangoException() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion unaPosicion = new Posicion(2,1);
        //Posicion unaPosicionLejana = new Posicion(2,8);
        Jinete jineteAliado = new Jinete();
        Jinete jineteEnemigo = new Jinete();
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
    public void test07JineteUbicadoEn22SeMueveParaElNorteYAhoraEstaEnLaPosicion12() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        Direccion unaDireccion = new Norte();
        Jinete unJinete = new Jinete();
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance().reiniciar(); // TODO: esto esta maaal
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unJinete,unaPosicion,mockedJugador);

        //Act
        unJinete.avanzar(unaDireccion);

        //Assert
        assertEquals(unJinete.posicion().posicionEnX() ,1);
        assertEquals(unJinete.posicion().posicionEnY() ,2);
        //verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
        //verify(mockedCasillero, times(2)).posicion();
    }

    @Test
    public void test08JineteEn22IntentaMoverseAlNorteYElCasilleroEstaOcupado() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        Posicion posicionAlNorte = new Posicion(1,2);
        Direccion unaDireccion = new Norte();
        Jinete unJinete = new Jinete();
        Catapulta mockedCatapulta = mock(Catapulta.class);

        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(unJinete,unaPosicion,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(mockedCatapulta,posicionAlNorte,mockedJugador);

        //Act & Assert
        thrown.expect(CasilleroOcupadoException.class);
        unJinete.avanzar(unaDireccion);
    }
}