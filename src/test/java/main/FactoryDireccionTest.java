package main;

import main.modelo.direccion.*;
import main.modelo.tablero.distancia.Posicion;
import org.junit.Assert;
import org.junit.Test;

public class FactoryDireccionTest {

    @Test
    public void testCrearAPartirDePosicion11DevuelveObjetoDeClaseSureste(){
        // Arrange
        Posicion posicionRelativa = new Posicion(1,1);

        // Act
        Direccion direccionObtenida = FactoryDireccion.crear(posicionRelativa);

        // Assert
        Assert.assertEquals(direccionObtenida.getClass(), DireccionSureste.class);
    }

    @Test
    public void testCrearAPartirDePosicion11DevuelveObjetoDeClaseNorte(){
        // Arrange
        Posicion posicionRelativa = new Posicion(-1,0);

        // Act
        Direccion direccionObtenida = FactoryDireccion.crear(posicionRelativa);

        // Assert
        Assert.assertEquals(direccionObtenida.getClass(), DireccionNorte.class);
    }

    @Test
    public void testCrearAPartirDePosicion11DevuelveObjetoDeClaseOeste(){
        // Arrange
        Posicion posicionRelativa = new Posicion(0,-1);

        // Act
        Direccion direccionObtenida = FactoryDireccion.crear(posicionRelativa);

        // Assert
        Assert.assertEquals(direccionObtenida.getClass(), DireccionOeste.class);
    }
}
