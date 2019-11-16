package Main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DireccionTest {

    // En este caso no tiene sentido hacer el mock para la posición.
    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElNorteYDevuelvePosicion45(){
        // Arrange
        Direccion unaDireccion = new Norte();
        Posicion unaPosicion = new Posicion(5,5);

        // Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());

        // Assert
        assertEquals(unaPosicion.posicionEnX(), 4);
        assertEquals(unaPosicion.posicionEnY(), 5);
    }


    @Test
    public void test02EstaEnPosicion1510YSeMueveHaciaElNorteYDevuelvePosicion1410(){
        //Arrange
        Direccion unaDireccion = new Norte();
        Posicion unaPosicion = new Posicion(15,10);

        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),14);
        assertEquals(unaPosicion.posicionEnY() ,10);
    }

    @Test
    public void test03EstaEnPosicion55YSeMueveHaciaElSurYDevuelvePosicion65(){
        //Arrange
        Direccion unaDireccion = new Sur();
        Posicion unaPosicion = new Posicion(5,5);
        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),6);
        assertEquals(unaPosicion.posicionEnY() ,5);
    }

    @Test
    public void test04EstaEnPosicion55YSeMueveHaciaElOesteYDevuelvePosicion56(){
        //Arrange
        Direccion unaDireccion = new Oeste();
        Posicion unaPosicion = new Posicion(5,5);
        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),5);
        assertEquals(unaPosicion.posicionEnY() ,4);
    }

    @Test
    public void test05EstaEnPosicion55YSeMueveHaciaElEsteYDevuelvePosicion54(){
        //Arrange
        Direccion unaDireccion = new Este();
        Posicion unaPosicion = new Posicion(5,5);
        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),5);
        assertEquals(unaPosicion.posicionEnY() ,6);
    }

    @Test
    public void test06EstaEnPosicion55YSeMueveHaciaElNoresteYDevuelvePosicion44(){
        //Arrange
        Direccion unaDireccion = new Noreste();
        Posicion unaPosicion = new Posicion(5,5);
        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),4);
        assertEquals(unaPosicion.posicionEnY() ,6);
    }

    @Test
    public void test07EstaEnPosicion55YSeMueveHaciaElSuresteYDevuelvePosicion64(){
        //Arrange
        Direccion unaDireccion = new Sureste();
        Posicion unaPosicion = new Posicion(5,5);
        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),6);
        assertEquals(unaPosicion.posicionEnY() ,6);
    }

    @Test
    public void test08EstaEnPosicion55YSeMueveHaciaElSuroesteYDevuelvePosicion66(){
        //Arrange
        Direccion unaDireccion = new Suroeste();
        Posicion unaPosicion = new Posicion(5,5);
        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),6);
        assertEquals(unaPosicion.posicionEnY() ,4);
    }

    @Test
    public void test09EstaEnPosicion55YSeMueveHaciaElNoroesteYDevuelvePosicion46(){
        //Arrange
        Direccion unaDireccion = new Noroeste();
        Posicion unaPosicion = new Posicion(5,5);
        //Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());
        //Assert
        assertEquals(unaPosicion.posicionEnX(),4);
        assertEquals(unaPosicion.posicionEnY() ,4);
    }
}
