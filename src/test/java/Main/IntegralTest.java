package Main;

import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IntegralTest {
    @After
    public void reiniciarJuego() {
        Juego.getInstance().reiniciar();
    }

    @Test
    public void seColocaPiezaDeUnJugadorEnSuCampoYEstaAhi()
    {
        // Arrange
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        Unidad unidad = new Soldado();

        // Act
        jugador1.colocarUnidadEn(unidad,new Posicion(1,2));

        // Assert
        //assertEquals(unidad.getCasillero().posicion().posicionEnX(),1);
        //assertEquals(unidad.getCasillero().posicion().posicionEnY(),2);
        //assertEquals(unidad.getJugador(),jugador1.nombre());
        assertEquals(1,0);
    }

    @Test (expected = CasilleroEsDeEnemigoException.class)
    public void seColocaPiezaDeUnJugadorEnCampoContrarioYDaUnaExcepcion()
    {
        // Arrange
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        Unidad unidad = new Soldado();

        // Act
        jugador1.colocarUnidadEn(unidad,new Posicion(11,2));

        // Assert
    }

    @Test (expected = CasilleroOcupadoException.class)
    public void seColocaPiezaDeUnJugadorEnLaMismaPosicionQueOtraYDaUnaExcepcion()
    {
        // Arrange
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        Unidad unidad1 = new Soldado();
        Unidad unidad2 = new Jinete();

        // Act
        jugador1.colocarUnidadEn(unidad1,new Posicion(1,2));
        jugador1.colocarUnidadEn(unidad2,new Posicion(1,2));

        // Assert
    }

    @Test (expected = InsuficientePuntosRestantesAlColocarUnidadException.class)
    public void jugadorNoPuedeTomarMasUnidadesQueLoQueSusPuntosLePermiten ()
    {
        // Arrange
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

        // Act
        for(int i=0; i<7; i++){
            jugador1.colocarUnidadEn(new Jinete(),new Posicion(i+1,2));
        }
    }

    @Test
    public void jugadorPierdeTodasSusUnidadesYElOtroJugadorGana()
    {
        // Arrange
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        jugador1.nombre("Arkantos");
        Juego.getInstance().agregarJugador(jugador1);
        jugador1.set_tablero(tablero);

        Jugador jugador2 = new Jugador();
        jugador2.nombre("Gargarensis");
        Juego.getInstance().agregarJugador(jugador2);
        jugador2.set_tablero(tablero);

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

}
