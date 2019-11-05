package Main;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegralTest {
    @After
    public void reiniciarJuego() {
        Juego.getInstance().reiniciar();
    }



}
