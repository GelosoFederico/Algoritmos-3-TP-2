package Main;

import Main.Unidad.*;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeSoldados;
import Main.Unidad.ConjuntoDeUnidades.ConjuntoDeUnidades;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConjuntoDeSoldadosTest {
    @Test
    public void testAgregoUnSoldadoAlConjunto() {
        // Arrange
        ConjuntoDeUnidades soldaditos = new ConjuntoDeSoldados();
        Unidad soldado1 = new Soldado();

        // Act
        soldaditos.agregar(soldado1);

        // Assert
        assertTrue(soldaditos.seEncuentra(soldado1));
    }

    @Test
    public void testIntentoAgregarUnSoldadoYUnJineteYElJineteNoEsta() {
        // Arrange
        ConjuntoDeUnidades soldaditos = new ConjuntoDeSoldados();
        Unidad soldado1 = new Soldado();
        Unidad jinete = new Jinete();

        // Act
        soldaditos.agregar(soldado1);
        soldaditos.agregar(jinete);

        // Assert
        assertTrue(soldaditos.seEncuentra(soldado1));
        assertFalse(soldaditos.seEncuentra(jinete));
    }
}
