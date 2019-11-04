package Main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class CuranderoTest {

    @Test
    public void test01CreoUnuranderoPorDefectoYTiene75PuntosDeVida(){
        //Act
        Curandero unCurandero = new Curandero();

        //Assert
        assertEquals(unCurandero.vida(),75);
    }

    @Test
    public void test02CreoUnCuranderCon75PuntosDeVidaReciveUnDanioDe10PuntosYSuVidaCambiaA65Puntos(){
        //Arrange
        Curandero unCurandero = new Curandero();

        //Act
        unCurandero.recibirDanio(10);

        //Assert
        assertEquals(unCurandero.vida(), 65);

    }
    @Mock
    public Casillero mockedCasillero = mock(Casillero.class);
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void test03SoldadoAtacaACuranderoEnemigoCon10PuntosDeVidaDosVecesYEsteNoPuedeRecibirMasDanio(){
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "irlandeses";
        String unaPosicion = "2,2";
        Soldado soldadoAliado = new Soldado();
        Curandero curanderoEnemigo = new Curandero(10);
        soldadoAliado.setPosicion(unaPosicion);
        curanderoEnemigo.colocarEn(mockedCasillero);
        soldadoAliado.setJugador(jugador1);         //Refactor: unidad no deberia conocer su posicion, casillero si
        curanderoEnemigo.setJugador(jugador2);
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
        Curandero curandero = new Curandero();
        Soldado soldadoEnemigo = new Soldado();
        curandero.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        soldadoEnemigo.colocarEn(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(1);

        //Act & Assert
        thrown.expect(ProhibidoCurarUnidadEnemigaExeption.class);
        curandero.atacar(soldadoEnemigo);

    }

    @Test
    public void test05CuranderoAliadoAtacaAJineteAliadoCon50PuntosDeVidaUbicadoEnDistanciaCercanaYLeSube15PuntosDeVida() {
        //Arrange
        String jugador1 = "ingleses";
        String jugador2 = "ingleses";
        String unaPosicion = "1,2";
        String otraPosicion = "1,1";
        Curandero curanderoAliado = new Curandero();
        Jinete jineteAliado = new Jinete(50);
        curanderoAliado.setPosicion(unaPosicion);
        jineteAliado.setPosicion(otraPosicion);
        curanderoAliado.colocarEn(mockedCasillero);
        jineteAliado.colocarEn(mockedCasillero);
        curanderoAliado.setJugador(jugador1);
        jineteAliado.setJugador(jugador2);
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
        String unaPosicion = "2,6";
        String unaPosicionMedia = "2,1";
        Curandero curanderoAliado = new Curandero();
        Soldado soldadoAliado = new Soldado();
        curanderoAliado.setPosicion(unaPosicion);
        soldadoAliado.setPosicion(unaPosicionMedia);
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
        String unaPosicion = "1,1";
        String otraPosicion = "1,2";
        String unaDireccion = "N";
        Curandero unCurandero  = new Curandero();
        unCurandero.setPosicion(unaPosicion);
        unCurandero.colocarEn(mockedCasillero);
        when(mockedCasillero.obtenerSiguienteEnDireccion(unaDireccion))
                .thenReturn(mockedCasillero);
        when(mockedCasillero.getPosicion()).thenReturn(otraPosicion);

        //Act
        unCurandero.avanzar(unaDireccion);

        //Assert
        assertEquals(mockedCasillero.getPosicion(), "1,2"); //REFACTOR: unidad no deberia conocer su pos, pedir a casillero
        verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
        verify(mockedCasillero, times(1)).getPosicion();
    }

    @Mock
    public Casillero mockedCasilleroOcupado = mock(Casillero.class);
    @Test
    public void test08CuranderoEn22IntentaMoverseAlEsteYElCasilleroEstaOcupado() {
        //Arrange
        String unaPosicion = "2,2";
        String unaDireccion = "E";
        Curandero curandero = new Curandero();
        curandero.setPosicion(unaPosicion);
        curandero.colocarEn(mockedCasilleroOcupado);
        when(mockedCasilleroOcupado.obtenerSiguienteEnDireccion(unaDireccion))
                .thenThrow(new CasilleroOcupadoException());

        //Act & Assert
        thrown.expect(CasilleroOcupadoException.class);
        curandero.avanzar(unaDireccion);
        verify(mockedCasillero, times(1)).obtenerSiguienteEnDireccion(unaDireccion);
    }

}
