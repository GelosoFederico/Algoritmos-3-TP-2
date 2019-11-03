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
    private Casillero mockedCasillero = mock(Casillero.class);
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
        soldadoEnemigo.setCasillero(mockedCasillero);
        soldadoAliado.setJugador(jugador1);
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
        soldadoEnemigo.setCasillero(mockedCasillero);
        when(mockedCasillero.calcularDistanciaA(mockedCasillero)).thenReturn(1);

        //Act & Assert
        thrown.expect(ProhibidoAtacarUnidadAliadaExeption.class);
        soldadoAliado.atacar(soldadoEnemigo);

    }
    
}
