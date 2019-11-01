
import TP2.Unidad.Casillero;
import TP2.Unidad.CasilleroOcupadoException;
import TP2.Unidad.Jinete;
import TP2.Unidad.Unidad;
import com.sun.security.auth.module.JndiLoginModule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class UnidadTest {

    @Test
    public void UnidadMovibleSemueveDesdeB2HastaB3() {
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
    public void test02UnidadMovibleSeMueveDesdeB2HastaA2() {
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

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testUnidadMovibleIntentaMoverseAUnCasilleroOcupadoYEsteLanzaCasilleroOcupadoException() {
        String unaPosicion = "2,2";
        String unaPosicionOcupada = "2,3";
        Soldado soldado = new Soldado();

        soldado.setPosicion(unaPosicion);
        thrown.expect(CasilleroOcupadoException.class);
        soldado.avanzar(unaPosicionOcupada);
    }

    @Test
    public void testUnSoldadoAliadoAtacaAUnSoldadoEnemigoCercanoYElSoldadoEnemigoPierde10PuntosDeVida() {

        String unaPosicion = "2,2";
        String unaPosicionCercana = "2,1";
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.setPosicion(unaPosicion);
        soldadoEnemigo.setPosicion(unaPosicionCercana);

        soldadoAliado.atacar(soldadoEnemigo);

        assertEquals(soldadoEnemigo.getVida(), 90);
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