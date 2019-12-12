package main;

import main.modelo.direccion.*;
import main.modelo.tablero.distancia.Posicion;
import org.junit.Assert;
import org.junit.Test;


public class PosicionTest {
    @Test
    public void obtengoDistanciaEntreDosPosicionesEnEjeXYDaBien() {
        // Assert
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(1,5);

        // Act
        int distancia = posicion1.distanciaA(posicion2).distanciaExacta();

        // Assert
        Assert.assertEquals(distancia,4);
    }

    @Test
    public void obtengoDistanciaEntreDosPosicionesEnEjeYYDaBien() {
        // Assert
        Posicion posicion1 = new Posicion(1,1);
        Posicion posicion2 = new Posicion(5,1);

        // Act
        int distancia = posicion1.distanciaA(posicion2).distanciaExacta();

        // Assert
        Assert.assertEquals(distancia,4);
    }

    @Test
    public void obtengoDistanciaEntreDosPosicionesCualquieraYDaBien() {
        // Assert
        Posicion posicion1 = new Posicion(3,4);
        Posicion posicion2 = new Posicion(13,8);

        // Act
        int distancia = posicion1.distanciaA(posicion2).distanciaExacta();

        // Assert
        Assert.assertEquals(distancia,10);
    }

    @Test
    public void obtengoLaDireccionDeUnaPosicionAOtraYSeObtiene() {
        // Assert
        Posicion posicion1 = new Posicion(3,4);
        Posicion posicion2 = new Posicion(4,4);

        // Act
        Direccion dir = posicion1.direccionHacia(posicion2);

        // Assert
        Assert.assertEquals(dir.getClass(),DireccionSur.class);

    }
}
