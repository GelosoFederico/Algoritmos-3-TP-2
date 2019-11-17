package Main;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ConjuntoDeUnidadesTest {

    @Test
    public void testCreoUnCOnjuntoDeUnidadesySuTamanioEs0(){
        //Arrange
        ConjuntoDeUnidades conjuntoVacio = new ConjuntoDeUnidades();

        //Act &Assert
        assertEquals(conjuntoVacio.cantidad(), 0);
    }


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

    @Test
    public void testagregoUnaUnidadDeCadaJugadorYCuandoBuscoLaUNidadDelJugadorLaOtraNoAparece(){
        //Arrange
        ConjuntoDeUnidades conjunto = new ConjuntoDeUnidades();
        String jugador1 = "mario";
        String jugador2 = "elVerde";
        Unidad soldado1 = new Soldado();
        Unidad soldado2 = new Soldado();
        soldado1.setJugador(jugador1);
        soldado2.setJugador(jugador2);
        conjunto.agregar(soldado2);

        //Act
        ConjuntoDeUnidades conjuntoNuevo = conjunto.obtenerUnidadesDeJugador(jugador1);

        //Assert
        assertFalse(conjuntoNuevo.seEncuentra(soldado2));
        assertEquals(conjuntoNuevo.cantidad(), 0);
    }
}
