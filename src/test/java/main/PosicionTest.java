package main;

import main.modelo.direccion.Direccion;
import main.modelo.direccion.Norte;
import main.modelo.direccion.Oeste;
import main.modelo.direccion.Sureste;
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
    public void posicion11PosicionRelativaAPosicion10DevuelveOeste() {
        // Arrange
        Posicion posicion = new Posicion(1,1);
        Posicion otraPosicion = new Posicion(1,0);
        Direccion direccionEsperada = new Oeste();
        // Act
        Direccion direccionObtenida = posicion.posicionRelativaA(otraPosicion);

        // Assert
        Assert.assertTrue((direccionEsperada.posicionRelativa()).igualA(direccionObtenida.posicionRelativa()));
    }

    @Test
    public void posicion55PosicionRelativaAPosicion66DevuelveSureste() {
        // Arrange
        Posicion posicion = new Posicion(5,5);
        Posicion otraPosicion = new Posicion(6,6);
        Direccion direccionEsperada = new Sureste();
        // Act
        Direccion direccionObtenida = posicion.posicionRelativaA(otraPosicion);

        // Assert
        Assert.assertTrue((direccionEsperada.posicionRelativa()).igualA(direccionObtenida.posicionRelativa()));
    }

    @Test
    public void posicion55PosicionRelativaAPosicion56DevuelveNorte() {
        // Arrange
        Posicion posicion = new Posicion(5,5);
        Posicion otraPosicion = new Posicion(4,5);
        Direccion direccionEsperada = new Norte();
        // Act
        Direccion direccionObtenida = posicion.posicionRelativaA(otraPosicion);

        // Assert
        Assert.assertTrue((direccionEsperada.posicionRelativa()).igualA(direccionObtenida.posicionRelativa()));
    }
}
