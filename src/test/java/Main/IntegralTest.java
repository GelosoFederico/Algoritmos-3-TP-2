package Main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IntegralTest {
    @Before
    @After
    public void reiniciarJuegoYTablero() throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field instance = Juego.class.getDeclaredField("INSTANCE");
        instance.setAccessible(true);
        instance.set(null, null);
        Field instance2 = Tablero.class.getDeclaredField("INSTANCE");
        instance2.setAccessible(true);
        instance2.set(null, null);
        Jugador.reiniciar();
    }
    @Test
    public void seColocaUnidadDeUnJugadorEnSuCampoYEstaAhi()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad = new Soldado();

        // Act
        jugador1.colocarUnidadEn(unidad,new Posicion(1,2));

        // Assert
        Posicion posicionFinal = Tablero.getInstance().obtenerPosicionDeUnidad(unidad);
        assertEquals(posicionFinal.posicionEnX(),1);
        assertEquals(posicionFinal.posicionEnY(),2);
        assertEquals(unidad.getJugador(),jugador1.nombre());
    }

    @Test (expected = CasilleroEsDeEnemigoException.class)
    public void seColocaUnidadDeUnJugadorEnCampoContrarioYDaUnaExcepcion()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad = new Soldado();

        // Act
        jugador1.colocarUnidadEn(unidad,new Posicion(11,2));

        // Assert
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void seColocaUnidadDeUnJugadorEnLaMismaPosicionQueOtraYDaUnaExcepcion()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Jinete();

        // Act & Assert
        jugador1.colocarUnidadEn(unidad1,new Posicion(1,2));
        jugador1.colocarUnidadEn(unidad2,new Posicion(1,2));

    }

    @Test (expected = InsuficientePuntosRestantesAlColocarUnidadException.class)
    public void jugadorNoPuedeTomarMasUnidadesQueLoQueSusPuntosLePermiten ()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        // Act
        for(int i=0; i<7; i++){
            jugador1.colocarUnidadEn(new Jinete(),new Posicion(i+1,2));
        }
    }

    @Test
    public void jugadorPierdeTodasSusUnidadesYElOtroJugadorGana()
    {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidadJ1 = new Soldado();
        Unidad unidadJ2 = new Jinete();
        jugador1.colocarUnidadEn(unidadJ1,new Posicion(7,7));
        jugador2.colocarUnidadEn(unidadJ2,new Posicion(11,11));

        // Act
        try {
            for (int i = 0; i < 20; i++) {
                jugador2.atacarConUnidadAUnidad(unidadJ2, unidadJ1);
            }
        }catch (JugadorGanoLaPartida e) {
            assertEquals(e.jugadorGanador(),jugador2);
        }
    }

    @Test
    public void testEncuentraUnidadesAlrededorDeUnaUnidadYLasAgregaSoloSoldadosAlConjuntoDeSoldados () {
        // Arrange
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Jinete();
        Unidad unidad3 = new Soldado();
        Unidad unidad4 = new Curandero();
        jugador1.colocarUnidadEn(unidad1,new Posicion(7,7));
        jugador1.colocarUnidadEn(unidad2,new Posicion(6,7));
        jugador1.colocarUnidadEn(unidad3,new Posicion(8,7));
        jugador1.colocarUnidadEn(unidad4,new Posicion(7,8));

        ConjuntoDeUnidades unidadesQueDebeTirar = new ConjuntoDeUnidades();
        unidadesQueDebeTirar.agregar(unidad1);
        unidadesQueDebeTirar.agregar(unidad3);

        // Act
        ConjuntoDeUnidades soldados = new ConjuntoDeSoldados();
        soldados = Tablero.getInstance().obtenerUnidadesAlrededorDe(unidad4,5, soldados);

        // Assert
        assertEquals(true,soldados.equals( unidadesQueDebeTirar));
    }


}
