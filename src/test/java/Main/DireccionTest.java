package Main;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DireccionTest {

    // En este caso no tiene sentido hacer el mock para la posición.
    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElNorteYDevuelvePosicion45(){
        // Arrange
        Direccion unaDireccion = new Direccion("N");
        Posicion unaPosicion = new Posicion(5,5);

        // Act
        unaPosicion.sumarle(unaDireccion.posicionRelativa());

        // Assert
        assertEquals(unaPosicion.posicionEnX(), 4);
        assertEquals(unaPosicion.posicionEnY(), 5);

    }

/*
    @Test
    public void test02EstaEnPosicion1510YSeMueveHaciaElNorteYDevuelvePosicion1410(){
        Direccion unaDireccion = new Direccion("N");

        Posicion unaPosicion = new Posicion(15,10);



        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "N");

        assertEquals(otraPosicion.posicionEnX(),14);
        assertEquals(otraPosicion.posicionEnY() ,10);

    }

    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElSurYDevuelvePosicion65(){
        Direccion unaDireccion = new Direccion();

        Posicion unaPosicion = new Posicion(5,5);

        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "S");

        assertEquals(otraPosicion.posicionEnX(),6);
        assertEquals(otraPosicion.posicionEnY() ,5);

    }

    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElOesteYDevuelvePosicion56(){
        Direccion unaDireccion = new Direccion();

        Posicion unaPosicion = new Posicion(5,5);

        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "O");

        assertEquals(otraPosicion.posicionEnX(),5);
        assertEquals(otraPosicion.posicionEnY() ,6);

    }

    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElEsteYDevuelvePosicion54(){
        Direccion unaDireccion = new Direccion();

        Posicion unaPosicion = new Posicion(5,5);

        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "E");

        assertEquals(otraPosicion.posicionEnX(),5);
        assertEquals(otraPosicion.posicionEnY() ,4);

    }

    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElNordesteYDevuelvePosicion44(){
        Direccion unaDireccion = new Direccion();

        Posicion unaPosicion = new Posicion(5,5);

        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "NE");

        assertEquals(otraPosicion.posicionEnX(),4);
        assertEquals(otraPosicion.posicionEnY() ,4);

    }

    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElSudesteYDevuelvePosicion64(){
        Direccion unaDireccion = new Direccion();

        Posicion unaPosicion = new Posicion(5,5);

        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "SE");

        assertEquals(otraPosicion.posicionEnX(),6);
        assertEquals(otraPosicion.posicionEnY() ,4);

    }

    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElSudoesteYDevuelvePosicion66(){
        Direccion unaDireccion = new Direccion();

        Posicion unaPosicion = new Posicion(5,5);

        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "SO");

        assertEquals(otraPosicion.posicionEnX(),6);
        assertEquals(otraPosicion.posicionEnY() ,6);

    }


    @Test
    public void test01EstaEnPosicion55YSeMueveHaciaElNoroesteYDevuelvePosicion46(){
        Direccion unaDireccion = new Direccion();

        Posicion unaPosicion = new Posicion(5,5);

        Posicion otraPosicion = unaDireccion.posicionSiguienteEnElSentido(unaPosicion, "NO");

        assertEquals(otraPosicion.posicionEnX(),4);
        assertEquals(otraPosicion.posicionEnY() ,6);

    }
*/
}
