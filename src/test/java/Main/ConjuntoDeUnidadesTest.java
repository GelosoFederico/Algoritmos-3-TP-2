package Main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class ConjuntoDeUnidadesTest {
    @Test
    public void testAgregoUnaUnidadYEsta(){
        // Arrange
        ConjuntoDeUnidades conjunto = new ConjuntoDeUnidades();
        Unidad unidad = new Soldado();

        // Act
        conjunto.agregar(unidad);

        // Assert
        assertTrue(conjunto.seEncuentra(unidad));
    }

    @Test
    public void testUnidadesDeTodasLasClasesYEstan(){
        // Arrange
        ConjuntoDeUnidades conjunto = new ConjuntoDeUnidades();
        Unidad soldado = new Soldado();
        Unidad jinete = new Jinete();
        Unidad catapulta = new Catapulta();
        Unidad curandero = new Curandero();

        // Act
        conjunto.agregar(soldado);
        conjunto.agregar(jinete);
        conjunto.agregar(catapulta);
        conjunto.agregar(curandero);

        // Assert
        assertTrue(conjunto.seEncuentra(soldado));
        assertTrue(conjunto.seEncuentra(jinete));
        assertTrue(conjunto.seEncuentra(catapulta));
        assertTrue(conjunto.seEncuentra(curandero));
    }
}
