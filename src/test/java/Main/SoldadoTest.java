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
    @Test (expected = UnidadEstaMuertaException.class)
    public void test04SoldadoAtacaADistanciaCercanaASoldadoEnemigoAunDespuesDeMuertoYEsteNoPuedeRecibirDanio(){
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
        while(1==1){
            soldadoAliado.atacar(soldadoEnemigo);
        }
        //Assert
        // Dejalo ya esta muerto
    }

    @Test (expected = ProhibidoAtacarUnidadAliadaException.class)
    public void test05SoldoAtacaASoldadoAliadoYEsteNoPuedeRecibirDanio() {
        //Arrange
        Jugador mJugador1 = mock(Jugador.class);
        when(mJugador1.numero()).thenReturn(1);
        String jugador1 = "ingleses";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoAliado2 = new Soldado();
        soldadoAliado.setJugador(jugador1);
        soldadoAliado2.setJugador(jugador1);
        Posicion unaPosicion = new Posicion(9,9);
        Posicion otraPosicion = new Posicion(9, 8);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado2,otraPosicion,mJugador1);

        //Act & Assert
        soldadoAliado.atacar(soldadoAliado2);

    }
    @Test (expected = UnidadFueraDeRangoException.class)
    public void test06unSoldadoAliadoAtacaASoldadoEnemigoADistanciaMediaYSeLanzaUnidadFueraDeRangoException(){
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
        Posicion otraPosicion = new Posicion(13,13);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoAliado,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldadoEnemigo,otraPosicion,mJugador2);

        //Act & Assert
        soldadoAliado.atacar(soldadoEnemigo);
    }

    @Test
    public void test07SoldadoUbicadoEn11SeMueveParaElNorteYAhoraEstaEnLaPosicion01(){
        //Arrange
        Posicion unaPosicion = new Posicion(1,1);
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
    }

    @Test (expected = CasilleroOcupadoException.class)
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
        unSoldado.avanzar(unaDireccion);
    }
/*
    @Test
    public void test09Creo3SoldadosContiguosEnLineaYAlAvanzarSoldado01AlNorteLos3SoldadosSeMueven(){
        //Arrange
        Posicion posicion01 = new Posicion(1,1);
        Posicion posicion02 = new Posicion(1,2);
        Posicion posicion03 = new Posicion(1,3);
        Direccion unaDireccion = new Norte();
        Soldado soldado01 = new Soldado();
        Soldado soldado02 = new Soldado();
        Soldado soldado03 = new Soldado();
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado01,posicion01,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado02,posicion01,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado03,posicion01,mockedJugador);

        //Act
        soldado01.avanzar(unaDireccion);

        //Assert
        assertEquals(soldado01.posicion().posicionEnX() ,0);
        assertEquals(soldado01.posicion().posicionEnY() ,1);
        assertEquals(soldado02.posicion().posicionEnX() ,0);
        assertEquals(soldado02.posicion().posicionEnY() ,2);
        assertEquals(soldado03.posicion().posicionEnX() ,0);
        assertEquals(soldado03.posicion().posicionEnY() ,3);
    }

    @Test
    public void test10Creo3SoldadosContiguosEnDiagonalAscendenteYAlAvanzarSoldado01AlNorteLos3SoldadosSeMueven(){
        //Arrange
        Posicion posicion01 = new Posicion(1,3);        //          x
        Posicion posicion02 = new Posicion(2,2);        //      x
        Posicion posicion03 = new Posicion(3,1);        //  x
        Direccion unaDireccion = new Norte();
        Soldado soldado01 = new Soldado();
        Soldado soldado02 = new Soldado();
        Soldado soldado03 = new Soldado();
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado01,posicion01,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado02,posicion01,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado03,posicion01,mockedJugador);

        //Act
        soldado01.avanzar(unaDireccion);

        //Assert
        assertEquals(soldado01.posicion().posicionEnX() ,0);
        assertEquals(soldado01.posicion().posicionEnY() ,3);
        assertEquals(soldado02.posicion().posicionEnX() ,1);
        assertEquals(soldado02.posicion().posicionEnY() ,2);
        assertEquals(soldado03.posicion().posicionEnX() ,2);
        assertEquals(soldado03.posicion().posicionEnY() ,1);

    }

    @Test
    public void test10Creo3SoldadosContiguosEnDiagonalDescendenteYAlAvanzarSoldado01AlNorteLos3SoldadosSeMueven(){
        //Arrange
        Posicion posicion01 = new Posicion(1,0);        //  x
        Posicion posicion02 = new Posicion(2,1);        //      x
        Posicion posicion03 = new Posicion(3,2);        //          x
        Direccion unaDireccion = new Norte();
        Soldado soldado01 = new Soldado();
        Soldado soldado02 = new Soldado();
        Soldado soldado03 = new Soldado();
        Jugador mockedJugador = mock(Jugador.class);
        when(mockedJugador.numero()).thenReturn(1);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado01,posicion01,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado02,posicion01,mockedJugador);
        Tablero.getInstance()
                .colocarUnidadEnPosicionDeJugador(soldado03,posicion01,mockedJugador);

        //Act
        soldado01.avanzar(unaDireccion);

        //Assert
        assertEquals(soldado01.posicion().posicionEnX() ,0);
        assertEquals(soldado01.posicion().posicionEnY() ,0);
        assertEquals(soldado02.posicion().posicionEnX() ,1);
        assertEquals(soldado02.posicion().posicionEnY() ,1);
        assertEquals(soldado03.posicion().posicionEnX() ,2);
        assertEquals(soldado03.posicion().posicionEnY() ,2);

    }
*/
}
