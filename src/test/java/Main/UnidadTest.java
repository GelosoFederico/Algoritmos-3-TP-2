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
        Posicion unaPosicion = new Posicion(1,1);
        String unaDireccion = "N";
        Soldado soldado = new Soldado();
        soldado.setPosicion(unaPosicion);

        //Act
        soldado.avanzar(unaDireccion);

        //Assert
        assertEquals(soldado.getPosicion().posicionEnX() ,1);
        assertEquals(soldado.getPosicion().posicionEnY() ,2);

    }

    @Test
    public void soldadoSeMueveDesde22Hasta12() {
        //Arrange
        Posicion unaPosicion = new Posicion(2,2);
        String unaDireccion = "N";
        Soldado soldado = new Soldado();
        soldado.setPosicion(unaPosicion);

        //Act
        soldado.avanzar(unaDireccion);

        //Assert
        assertEquals(soldado.getPosicion().posicionEnX() ,1);
        assertEquals(soldado.getPosicion().posicionEnY() ,2);
    }

    @Test
    public void testUnSoldadoAliadoAtacaAUnSoldadoEnemigoCercanoYElSoldadoEnemigoPierde10PuntosDeVida() {
        //Arrange
        String jugador1 = "teutones";
        String jugador2 = "godos";
        Posicion unaPosicion = new Posicion(2,2);
        Posicion unaPosicionCercana = new Posicion(2,1);
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setPosicion(unaPosicion);
        soldadoEnemigo.setPosicion(unaPosicionCercana);
        soldadoAliado.setJugador(jugador1);
        soldadoEnemigo.setJugador(jugador2);
        //Act
        soldadoAliado.atacar(soldadoEnemigo);

        //Assert
        assertEquals(soldadoEnemigo.vida(), 90);
    }

}