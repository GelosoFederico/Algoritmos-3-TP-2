package Main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CatapultaTest {

    @Test
    public void test01CreoUnaCatapultaPorDefectoYTiene50PuntosDeVida(){
        //Act
        Catapulta unaCatapulta = new Catapulta();

        //Assert
        assertEquals(unaCatapulta.vida(),50);
    }

    @Test
    public void test02CreoUnaCatapultaCon50PuntosDeVidaReciveUnDanioDe15PuntosYSuVidaCambiaA35Puntos() {
        //Arrange
        int vidaInicial = 50;
        Jinete unJinete = new Jinete(vidaInicial);

        //Act
        unJinete.recibirDanio(15);

        //Assert
        assertEquals(unJinete.vida(), 35);

    }

    @Mock
    public Casillero mockedCasillero = mock(Casillero.class);

    @Test
    public void test03CatapultaAliadaAtacaACatapultaEnemigaCon50PuntosDeVidaUbicadoADistanciaLejanaYLeQuita20PuntosDeVida() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion posicionAliada = new Posicion(1,9);
        //Posicion posicionEnemiga = new Posicion(1,1);
        Catapulta CatapultaAliada = new Catapulta();
        Catapulta CatapultaEnemiga = new Catapulta();
        CatapultaAliada.setJugador(jugador1);
        CatapultaEnemiga.setJugador(jugador2);
        CatapultaAliada.colocarEn(mockedCasillero);
        CatapultaEnemiga.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(8);

        //Act
        CatapultaAliada.atacar(CatapultaEnemiga);

        //Assert
        assertEquals(CatapultaEnemiga.vida(), 30); //danio de catapulta a larga dist = 20
        verify(mockedCasillero, times(1)).calcularDistanciaA(mockedCasillero);
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test04CatapultaAtacaACatapultaEnemigaCon15PuntosDeVidaDosVecesYEsteNoPuedeRecibirMasDanio() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion unaPosicion = new Posicion(2,2);
        //Posicion otraPosicion = new Posicion(2,9);
        Catapulta catapultaAliada = new Catapulta();
        Catapulta catapultaEnemiga = new Catapulta(15);
        catapultaAliada.setJugador(jugador1);
        catapultaEnemiga.setJugador(jugador2);
        catapultaAliada.colocarEn(mockedCasillero);
        catapultaEnemiga.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero))
                .thenReturn(7);
        catapultaAliada.atacar(catapultaEnemiga);

        //Act & Assert
        thrown.expect(UnidadEstaMuertaException.class);
        catapultaAliada.atacar(catapultaEnemiga);
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
    public void test06unCatapultaAliadaAtacaACatapultaEnemigaADistanciaCercanaYSeLanzaUnidadFueraDeRangoException() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        //Posicion unaPosicion = new Posicion(2,1);
        //Posicion unaPosicionLejana = new Posicion(2,2);
        Catapulta catapultaAliada = new Catapulta();
        Catapulta catapultaEnemiga = new Catapulta();
        catapultaAliada.setJugador(jugador1);
        catapultaEnemiga.setJugador(jugador2);
        catapultaAliada.colocarEn(mockedCasillero);
        catapultaEnemiga.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(2);

        //Act & Assert
        thrown.expect(UnidadFueraDeRangoException.class);
        catapultaAliada.atacar(catapultaEnemiga);
    }

    @Test
    public void test07CatapultaSeIntentaMoverParaElNorteNoPuedeMoverse() {
        //Arrange
        String unaDireccion = "N";
        Catapulta catapulta = new Catapulta();
        catapulta.colocarEn(mockedCasillero);

        //Act & Assert
        thrown.expect(UnidadNoPuedeMoverseException.class);
        catapulta.avanzar(unaDireccion);
    }



}
