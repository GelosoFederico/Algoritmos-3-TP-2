package main.modelo.unidad.conjuntodeunidades;

import main.modelo.direccion.Posicion;
import main.modelo.juego.EquipoBlanco;
import main.modelo.juego.EquipoNegro;
import main.modelo.juego.Juego;
import main.modelo.juego.Jugador;
import main.modelo.tablero.Tablero;
import main.modelo.unidad.Jinete;
import main.modelo.unidad.Soldado;
import main.modelo.unidad.Unidad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ConjuntoDeUnidadesVictimasTest {
    @Before
    @After
    public void reiniciarTableroYJuego() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Tablero.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
        Field instance2 = Juego.class.getDeclaredField("INSTANCE");
        instance2.setAccessible(true);
        instance2.set(null, null);
    }

    @Test
    public void testCreoUnConjuntoDeUnidadesVictimasySuTamanioEs0(){
        //Arrange
        ConjuntoDeUnidadesVictimas conjuntoVacio = new ConjuntoDeUnidadesVictimas();

        //Act &Assert
        assertEquals(conjuntoVacio.cantidad(), 0);
    }


    @Test
    public void testAgregoUnaUnidadAlConjuntoDeUnidadesVictimasYEsta(){
        // Arrange
        ConjuntoDeUnidadesVictimas conjuntoDeVictimas = new ConjuntoDeUnidadesVictimas();
        Unidad unidad = new Jinete();

        // Act
        conjuntoDeVictimas.agregar(unidad);

        // Assert
        assertTrue(conjuntoDeVictimas.seEncuentra(unidad));
    }


    @Test
    public void testSeBuscaUnaUnidadContiguaAUnaUnidad() {

        Unidad soldado1 = new Soldado();
        Unidad soldado2 = new Soldado();
        Unidad soldado3 = new Soldado();

        Posicion unaPosicion = new Posicion(8,9);
        Posicion otraPosicion = new Posicion(9,9);
        Posicion posicionSoldado3 = new Posicion(9,8);

        Jugador mJugador1 = new Jugador();

        soldado1.setEquipo(new EquipoBlanco());
        soldado2.setEquipo(new EquipoBlanco());
        soldado3.setEquipo(new EquipoBlanco());

        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado1,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado2,otraPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado3,posicionSoldado3,mJugador1);

        ConjuntoDeUnidadesVictimas victimas = new ConjuntoDeUnidadesVictimas();
        ConjuntoDeUnidades unidades = victimas.buscarUnidadesContiguasALaVictima(soldado1);

        assertEquals(unidades.cantidad(), 2);

    }

    @Test
    public void testSeBuscanUnidadesContiguasAUnaUnidad() {

        Unidad soldado1 = new Soldado();
        Unidad jinete = new Jinete();
        Unidad soldado2 = new Soldado();
        Unidad soldado3 = new Soldado();
        Unidad soldado4 = new Soldado();


        Posicion posicionSoldado1 = new Posicion(8,9);
        Posicion posicionSoldado2 = new Posicion(7,9);
        Posicion posicionSoldado3 = new Posicion(6,9);
        Posicion posicionSoldado4 = new Posicion(5,9);
        Posicion posicionJinete = new Posicion(4,9);

        Jugador mJugador1 = new Jugador();

        soldado1.setEquipo(new EquipoBlanco());
        soldado2.setEquipo(new EquipoBlanco());
        soldado3.setEquipo(new EquipoBlanco());
        soldado4.setEquipo(new EquipoBlanco());
        jinete.setEquipo(new EquipoBlanco());

        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado1,posicionSoldado1,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado2,posicionSoldado2,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado3,posicionSoldado3,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado4,posicionSoldado4,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jinete,posicionJinete,mJugador1);

        ConjuntoDeUnidadesVictimas victimas = new ConjuntoDeUnidadesVictimas();
        ConjuntoDeUnidades unidades = victimas.buscarUnidadesContiguasALaVictima(soldado1);
        victimas.buscarUnidadesContiguasParaCadaVictima(unidades);

        assertEquals(unidades.cantidad(), 1);
        assertEquals(victimas.cantidad(), 5);

    }
    @Test
    public void testUnaUnidadTieneDosUnidadesAdyacentesYTodasSeAgreganAlConjunto() {
        //Arrange
        ConjuntoDeUnidadesVictimas conjunto = new ConjuntoDeUnidadesVictimas();

        Jugador mJugador1 = new Jugador();
        Jugador mJugador2 = new Jugador();

        Unidad soldado1 = new Soldado();
        Unidad soldado2 = new Soldado();
        Unidad jinete = new Jinete();

        soldado1.setEquipo(new EquipoBlanco());
        soldado2.setEquipo(new EquipoBlanco());
        jinete.setEquipo(new EquipoBlanco());

        Posicion unaPosicion = new Posicion(5,9);
        Posicion otraPosicion = new Posicion(4,9);
        Posicion posicionJinete = new Posicion(4,8);


        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado1,unaPosicion,mJugador1);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(soldado2,otraPosicion,mJugador2);
        Tablero.getInstance().colocarUnidadEnPosicionDeJugador(jinete,posicionJinete,mJugador2);


         ConjuntoDeUnidadesVictimas victimas = conjunto.buscarTodasLasVictimasDeExpansion(soldado1);
        // Assert
        assertEquals(victimas.cantidad(), 3);

    }


}
