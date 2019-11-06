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
        assertEquals(unidad.getCasillero().posicion().posicionEnX(),1);
        assertEquals(unidad.getCasillero().posicion().posicionEnY(),2);
        assertEquals(unidad.getJugador(),jugador1.nombre());
    }

    @Test (expected = CasilleroEsDeEnemigo.class)
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

    @Test (expected = CasilleroEstaOcupado.class)
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

    @Test (expected = InsuficientePuntosRestantesAlColocarUnidad.class)
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

}
